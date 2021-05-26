package com.cloudtest.payment.util;

import ch.ethz.ssh2.Connection;
import cn.hutool.extra.ssh.JschUtil;
import com.jcraft.jsch.*;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * This program enables you to connect to sshd server and get the shell prompt.
 * You will be asked username, hostname and passwd.
 * If everything works fine, you will get the shell prompt. Output may
 * be ugly because of lacks of terminal-emulation, but you can issue commands.
 */


public class Test{
    private static final String USER="root";
    private static final String PASSWORD="********";
    private static final String HOST="localhost";
    private static final int DEFAULT_SSH_PORT=22;
    public static List<String> remoteExecute2(Session session, String command) throws JSchException {
        List<String> resultLines = new ArrayList<>();
        ChannelExec channel = null;
        try{
            channel = (ChannelExec) session.openChannel("exec");
            channel.setCommand(command);
            InputStream input = channel.getInputStream();
            channel.connect();
            try {
                BufferedReader inputReader = new BufferedReader(new InputStreamReader(input));
                String inputLine = null;
                while((inputLine = inputReader.readLine()) != null) {
                    resultLines.add(inputLine);
                }
            } finally {
                if (input != null) {
                    try {
                        input.close();
                    } catch (Exception e) {
                        System.out.println("JSch inputStream close error:");
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("IOcxecption:");
        } finally {
            if (channel != null) {
                try {
                    channel.disconnect();
                } catch (Exception e) {
                    System.out.println("JSch channel disconnect error:");
                }
            }
        }
        return resultLines;
    }
    public static void main(String[] arg) throws JSchException {
        Session session = JschUtil.getSession("10.43.127.16", 22, "root", "Sxry@016^");
        String c = JschUtil.exec(session,"ls /", Charset.forName("utf-8"));
        System.out.println(c);

    }
    public static List<String> remoteExecute(Session session, String command) throws JSchException {
        List<String> resultLines = new ArrayList<>();
        ChannelExec channel = null;
        try{
            channel = (ChannelExec) session.openChannel("exec");
            channel.setCommand(command);
            InputStream input = channel.getInputStream();
            channel.connect();
            try {
                BufferedReader inputReader = new BufferedReader(new InputStreamReader(input));
                String inputLine = null;
                while((inputLine = inputReader.readLine()) != null) {
                    resultLines.add(inputLine);
                }
            } finally {
                if (input != null) {
                    try {
                        input.close();
                    } catch (Exception e) {
                        System.out.println("JSch inputStream close error:");
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("IOcxecption:");
        } finally {
            if (channel != null) {
                try {
                    channel.disconnect();
                } catch (Exception e) {
                    System.out.println("JSch channel disconnect error:");
                }
            }
        }
        return resultLines;
    }
}
