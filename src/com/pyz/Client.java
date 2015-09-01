package com.pyz;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.InetAddress;
import java.net.Socket;


public class Client {

	public static void main(String[] args) throws Exception{
		Client.startClient();
	}
	
	public static void startClient(){
		
		Socket socket=null;
		OutputStream out=null;
		InputStream in=null;
		try{
			//��ʼ���ͻ���socket
			socket=new Socket(InetAddress.getLocalHost(),6001);
			out=socket.getOutputStream();
			out.write("it's a request from client".getBytes());
			in=socket.getInputStream();
			byte[] tmp=new byte[4000000];
			int cnt;
			while((cnt=in.read(tmp))!=-1){
				System.out.println("��ȡ�����С�����");
				System.out.println("content from server:"+new String(tmp,0,cnt));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			System.out.println("�ͻ��˹ر�");
			try{
			
				if(in!=null){
					in.close();
				}
				if(out!=null){
					out.close();
				}
				if(socket!=null){
					socket.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		
	}
}
