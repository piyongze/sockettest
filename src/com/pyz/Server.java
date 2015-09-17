package com.pyz;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.log4j.Logger;


public class Server {

    private static final Logger LOGGER=Logger.getLogger(Server.class);
    private Server(){
        
    }
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
             LOGGER.debug("The Server is start: " + serverSocket);

             //开启监听
             socket = serverSocket.accept();
             LOGGER.debug("Accept request from: " + socket.getInetAddress());                

  
             in = socket.getInputStream();
             byte[] tmp=new byte[1024];
             int cnt;
             if((cnt=in.read(tmp))!=-1){
                 LOGGER.debug("content from client:"+new String(tmp,0,cnt));
             }
             out=socket.getOutputStream();
             out.write("i am server.i receive it.i will close the connection.".getBytes());
             socket.close();
         }catch(Exception e){
             LOGGER.debug(e);
         }finally{
             if(serverSocket!=null){
                 try {
                     LOGGER.debug("服务器端关闭");
                    serverSocket.close();
                } catch (IOException e) {
                    LOGGER.debug(e);
                }
             }
         }
     }
}
