package Network.Exam5;

import java.net.ServerSocket;
import java.net.Socket;


public class ServerTest {
    public static void main(String[] args) {

        ServerSocket serverSocket;

        Socket s = null;

        
        try {
            serverSocket = new ServerSocket(5434);
            System.out.println("서버 실행중...");
            
            s = serverSocket.accept();
            
            ChatThread chatThread = new ChatThread(s);
            chatThread.start();
           
            CommunicateThread communicateThread = new CommunicateThread(s);
            communicateThread.start();
            communicateThread.outMessage("Server");


            //pw.close();
            s.close();
            System.out.println("클라이언트 접속 해제");

            if(chatThread.isAlive()) {
                chatThread.interrupt();
                chatThread = null;

            }
            if(communicateThread.isAlive()) {
                communicateThread.interrupt();
                communicateThread = null;

            }



        } catch (Exception e) {
            e.printStackTrace();
            
        }
        

    }
    
}
