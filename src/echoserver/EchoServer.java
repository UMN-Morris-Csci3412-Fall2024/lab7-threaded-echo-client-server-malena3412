package echoserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//******************************This is my multi-threaded code**************************/
public class EchoServer {
    
    public static final int PORT_NUMBER = 6013;
    private static final int THREAD_POOL_SIZE = 12;

    public static void main(String[] args) throws IOException {
        EchoServer server = new EchoServer();
        server.start();
    }

    private void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT_NUMBER);
        ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        while (true) {
            Socket socket = serverSocket.accept();

            // Submit a task to the thread pool for each client connection
            threadPool.submit(() -> {
                try {
                    InputStream inputStream = socket.getInputStream();
                    OutputStream outputStream = socket.getOutputStream();

                    int data;
                    while ((data = inputStream.read()) != -1) {
                        outputStream.write(data);
                    }

                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}


//******************************Below is my single threaded code**************************/

/*
package echoserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    
    // REPLACE WITH PORT PROVIDED BY THE INSTRUCTOR
    public static final int PORT_NUMBER = 6013;

    public static void main(String[] args) throws IOException, InterruptedException {
        EchoServer server = new EchoServer();
        server.start();
    }

    private void start() throws IOException, InterruptedException {
        ServerSocket serverSocket = new ServerSocket(PORT_NUMBER);
        while (true) {
            Socket socket = serverSocket.accept();

            // Create and start a new thread for each client connection
            Thread clientThread = new Thread(() -> {
                try {
                    InputStream inputStream = socket.getInputStream();
                    OutputStream outputStream = socket.getOutputStream();

                    int data;
                    while ((data = inputStream.read()) != -1) {
                        outputStream.write(data);
                    }

                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            clientThread.start();
        }
    }
}
*/