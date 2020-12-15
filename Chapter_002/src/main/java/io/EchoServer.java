package io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    private static final Logger LOG = LoggerFactory.getLogger(EchoServer.class.getName());
    private static boolean isWorked = true;

    private static String parse(String data) {
        String result = "";
        for (String str : data.split("\\s")) {
            if (str.contains("/?msg=")) {
                result = str.substring(str.indexOf("/?msg=") + 6);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String result = "";
        try (ServerSocket serverSocket = new ServerSocket(9000)) {
            System.out.println("server started");
            while (isWorked) {
                Socket socket = serverSocket.accept();
                try (OutputStream output = socket.getOutputStream();
                     BufferedReader input = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    while (true) {
                        str = input.readLine();
                        if (str.isEmpty()) {
                            break;
                        }
                        System.out.println(str);
                         if (!parse(str).isEmpty()) {
                             result = parse(str);
                         }
                        if (result.equals("exit")) {
                            socket.close();
                            isWorked = false;
                            break;
                        }
                    }
                        if (isWorked) {
                            output.write(("HTTP/1.1 200 OK\r\n"
                                    + "Content-type: text/html\n"
                                    + "\n"
                                    + "<h2> " + result + "</h2>").getBytes());
                        }
                }
            }

        } catch (IOException e) {
            LOG.error("We have some IO troubles", e);
        }
    }
}
