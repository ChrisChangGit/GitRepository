package com.chris.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import com.chris.bean.ClientServerBean;

public class Client {
	private Socket socket = null;
	
	public Client(String host, int port) {
		if(socket == null) {
			try {
				// 建立連線
				socket = new Socket(host, port);
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("連線失敗");
			}
		}
	}
	
	public void run() {
		
		BufferedReader br = null;
		ObjectOutputStream oos = null;
		
		if (socket != null) {
			try {
				// 取得 寫入的串流
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				// 取得 寫出的串流
				oos = new ObjectOutputStream(socket.getOutputStream());

				// 資訊
				ClientServerBean clientServerBean = new ClientServerBean();
				clientServerBean.setNumber(1);
				System.out.println("client 傳送的資料" + clientServerBean);
				
				// 傳送資訊給Server
				oos.writeObject(clientServerBean);
				oos.flush();

				// 取得Server回傳的訊息
				String message = br.readLine();
				System.out.println("from server message = " + message);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (br != null) {
					try {
						br.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (oos != null) {
					try {
						oos.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

				if (socket != null) {
					try {
						socket.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} 
		}
	}
	public static void main(String[] args) {
		new Client("localhost", 8080).run();
	}
}
