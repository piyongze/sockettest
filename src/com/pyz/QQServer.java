package com.pyz;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class QQServer {

	public static void main(String[] args) {
		QQServer.startServer();
	}
	
	public static void startServer(){
		
		final ServerSocket serSocket;
		Socket socket;
		try{
			serSocket=new ServerSocket(9000);
			
			//ѭ���������� �����̴߳����߳�
			while(true){
				socket=serSocket.accept();
				new Thread(new MyThread(socket)).start();
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
} 
class MyThread implements Runnable{
	private Socket socket;
	public MyThread(Socket socket){
		this.socket=socket;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			System.out.println("�û�,IP:"+socket.getLocalPort()+",�˿�:"+socket.getPort()+"���ӳɹ�");
			InputStream in=socket.getInputStream();
			byte[] tmp=new byte[1024];
			int cnt;
			while((cnt=in.read(tmp))!=-1){
				System.out.println(new String(tmp,0,cnt));
			}
		}catch(Exception e){
			
		}
	}
	
}