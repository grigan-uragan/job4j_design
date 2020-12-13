package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    private static boolean isWorked = true;

    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(9000)) {
            while (isWorked) {
                Socket socket = serverSocket.accept();
                try (OutputStream output = socket.getOutputStream();
                     BufferedReader input = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    while (!(str = input.readLine()).isEmpty()) {
                        System.out.println(str);
                        if (str.equals("/exit")) {
                            isWorked = false;
                            output.write("HTTP/1.1 400 ERROR\r\n\\".getBytes());
                        } else {
                            output.write("HTTP/1.1 200 OK\r\n\\".getBytes());
                        }

                    }
                }
            }

        }
    }
}
