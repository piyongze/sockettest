package com.pyz;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

	 public static void main(String[] args) {
		Server.startServer();
	}
	 
	 public static void startServer(){
		 
		 ServerSocket serverSocket=null;
		 Socket socket=null;
		 InputStream in=null;
		 OutputStream out=null;
         try{
        	 //创建服务器端socket
        	 serverSocket = new ServerSocket(6001);
             System.out.println("The Server is start: " + serverSocket);

             //开启监听
             socket = serverSocket.accept();
        	 System.out.println("Accept request from: " + socket.getInetAddress());                  
             in = socket.getInputStream();
             byte[] tmp=new byte[1024];
             int cnt;
             if((cnt=in.read(tmp))!=-1){
            	 System.out.println("content from client:"+new String(tmp,0,cnt));
             }
             out=socket.getOutputStream();
             out.write("i am server.i receive it.i will close the connection.".getBytes());
             socket.close();
         }catch(Exception e){
        	 e.printStackTrace();
         }finally{
        	 if(serverSocket!=null){
        		 try {
        			 System.out.println("服务器端关闭");
					serverSocket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	 }
         }
	 }
}
