package com.pyz;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class QQClient {

	public static void main(String[] args) {
		QQClient.startQQ();
	}
	
	
	public static void startQQ(){
		
		System.out.println("开启监听");
		//服务器端socket 用于接收
		Socket socket=null;
		OutputStream out=null;
		try{
			socket=new Socket("127.0.0.1",9000);
			out=socket.getOutputStream();
			out.write("link it".getBytes());
			Thread.sleep(30000);
			socket.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(socket!=null){
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
