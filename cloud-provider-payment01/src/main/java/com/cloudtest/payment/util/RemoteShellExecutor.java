package com.cloudtest.payment.util;

import ch.ethz.ssh2.ChannelCondition;
import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;
import cn.hutool.json.JSONObject;
import io.micrometer.core.instrument.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Arrays;

@Slf4j
public class RemoteShellExecutor {
    private Connection conn;
    /**
     * 远程机器IP
     */
    private String ip;
    private Integer port;
    /**
     * 用户名
     */
    private String osUsername;
    /**
     * 密码
     */
    private String password;
    private String charset = Charset.defaultCharset().toString();

    private static final int TIME_OUT = 1000 * 5 * 60;

    public RemoteShellExecutor(String ip, String usr, String password) {
        this.ip = ip;
        this.osUsername = usr;
        this.password = password;
        this.port = 22;
    }

    public RemoteShellExecutor(String ip, String usr, String password, Integer port) {
        this.ip = ip;
        this.osUsername = usr;
        this.password = password;
        this.port = port;
    }

    /**
     * 登录
     *
     * @return
     * @throws IOException
     */
    private boolean login() throws IOException {
        conn = new Connection(ip, port);
        conn.connect();
        return conn.authenticateWithPassword(osUsername, password);
    }

    /**
     * 执行脚本
     *
     * @param cmds
     * @return
     * @throws Exception
     */
    public JSONObject exec(String cmds) throws Exception {
        JSONObject jsonObject = new JSONObject();
        InputStream stdOut = null;
        InputStream stdErr = null;
        String outStr;
        String outErr;
        int ret = -1;
        try {
            if (login()) {
                // Open a new {@link Session} on this connection
                Session session = conn.openSession();
                // Execute a command on the remote machine.
                session.execCommand(cmds);
                stdOut = new StreamGobbler(session.getStdout());
                outStr = processStream(stdOut, charset);
                stdErr = new StreamGobbler(session.getStderr());
                outErr = processStream(stdErr, charset);
                session.waitForCondition(ChannelCondition.EXIT_STATUS, TIME_OUT);
                if (StringUtils.isNotBlank(outErr) && outErr.length() > 0) {
                    log.error("shh error:{}", outErr);
                }
                if (StringUtils.isNotBlank(outStr)) {
                    log.info("shh info:{}", outStr);
                }
                ret = session.getExitStatus();
            } else {
                throw new Exception("登录远程机器失败" + ip); // 自定义异常类 实现略
            }
        } finally {
            if (conn != null) {
                conn.close();
            }
            IOUtils.closeQuietly(stdOut);
            IOUtils.closeQuietly(stdErr);
        }
        jsonObject.put("status", ret);
        jsonObject.put("message", Arrays.asList(outStr.replaceAll("                 ", "").split("\\n")));
        jsonObject.put("error", outErr);
        return jsonObject;
    }

    private String processStream(InputStream in, String charset) throws Exception {
        byte[] buf = new byte[1024];
        StringBuilder sb = new StringBuilder();
        while (in.read(buf) != -1) {
            sb.append(new String(buf, charset));
        }
        return sb.toString().replaceAll("\\u0000", "");
    }

    public static void main(String args[]) throws Exception {
//        RemoteShellExecutor executor = new RemoteShellExecutor("192.168.200.138", "root", "asd123");
//        RemoteShellExecutor executor = new RemoteShellExecutor("10.43.127.16", "root", "Sxry@016^");
        RemoteShellExecutor executor = new RemoteShellExecutor("10.43.127.16", "vedio_ftp", "sxvedio_ftp");
//        System.setProperty("java.net.preferIPv6Addresses", "true");
//        System.setProperty("java.net.preferIPv4Stack", "true");
        System.out.println(System.getProperty("java.net.preferIPv6Addresses"));
        System.out.println(executor.exec("ls / "));
    }
}
