package echoserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class EchoClient {
	public static final int PORT_NUMBER = 6013;

	public static void main(String[] args) throws IOException {
		EchoClient client = new EchoClient();
		client.start();
	}

	private void start() throws IOException {
		Socket socket = new Socket("localhost", PORT_NUMBER);
		InputStream socketInputStream = socket.getInputStream();
		OutputStream socketOutputStream = socket.getOutputStream();
	
		Thread inputThread = new Thread(() -> {
			try {
				int data;
				while ((data = System.in.read()) != -1) {
					socketOutputStream.write(data);
				}
				socket.shutdownOutput();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	
		Thread outputThread = new Thread(() -> {
			try {
				int data;
				while ((data = socketInputStream.read()) != -1) {
					System.out.write(data);
				}
				System.out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	
		inputThread.start();
		outputThread.start();
	
		try {
			inputThread.join();
			outputThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
		socket.close();
	}
}