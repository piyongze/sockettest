package com.pyz;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

import org.apache.log4j.Logger;

public class QQClient {

    private static final Logger LOGGER=Logger.getLogger(QQClient.class);
    private QQClient(){
        
    }
    public static void main(String[] args) {
        QQClient.startQQ(args[0]);
    }
    
    
    public static void startQQ(String ip){
        
        LOGGER.debug("开启监听");
        //服务器端socket 用于接收
        Socket socket=null;
        OutputStream out=null;
        try{
            socket=new Socket(ip,9000);
            out=socket.getOutputStream();
            out.write("link it".getBytes());
            Thread.sleep(30000);
            socket.close();
        }catch(Exception e){
            LOGGER.debug(e);
        }finally{
            if(socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    LOGGER.debug(e);
                }
            }
        }
        
    }
}