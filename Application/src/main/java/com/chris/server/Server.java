package com.chris.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.chris.bean.ClientServerBean;

public class Server {
	
	private ServerSocket serverSocket = null;
	
	public Server(int prot) {
		if(serverSocket == null) {
			try {
				// 建立 serverSocket PORT = ??
				serverSocket = new ServerSocket(prot);
			} catch (IOException e) {
				System.err.println("Server Error");
			}
		}
	}
	
	public void run() {
		Socket socket = null;
		ObjectInputStream ois = null;
		PrintStream ps = null;

		if (serverSocket != null) {
			try {
				System.out.println("等待連線中...");
				// 取得 連線...
				socket = serverSocket.accept();
				System.out.println("已建立連線...");

				// 取得 寫入的串流
				ois = new ObjectInputStream(socket.getInputStream());
				// 取得 寫出的串流
				ps = new PrintStream(socket.getOutputStream(), true);

				// 讀取 資料
				ClientServerBean clientServerBean = (ClientServerBean) ois.readObject();
				System.out.println("接收的資訊 = " + clientServerBean);

				// 回傳 資訊
				ps.print("已成功取得資料。");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (socket != null) {
					try {
						socket.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

				if (serverSocket != null) {
					try {
						serverSocket.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

				if (ois != null) {
					try {
						ois.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

				if (ps != null) {
					try {
						ps.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			} 
		}
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		new Server(8080).run();
	}
}
