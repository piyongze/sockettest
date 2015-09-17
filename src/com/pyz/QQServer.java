package com.pyz;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.log4j.Logger;

public class QQServer {

    private static final Logger LOGGER=Logger.getLogger(QQServer.class);
    
    private QQServer(){
        
    }
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
            LOGGER.debug(e);
        }
    }
} 
class MyThread implements Runnable{
    
    private static final Logger LOGGER=Logger.getLogger(MyThread.class);
    private Socket socket;
    public MyThread(Socket socket){
        this.socket=socket;
    }
    @Override
    public void run() {
        try{
            LOGGER.debug("�û�,IP:"+socket.getLocalPort()+",�˿�:"+socket.getPort()+"���ӳɹ�");
            InputStream in=socket.getInputStream();
            byte[] tmp=new byte[1024];
            int cnt;
            String p;
            while((cnt=in.read(tmp))!=-1){
                p=new String(tmp,0,cnt);
                LOGGER.info(p);
            }
        }catch(Exception e){
            LOGGER.info(e);
        }
    }
    
}