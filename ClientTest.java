package Network.Exam5;

import java.io.BufferedReader;
import java.net.Socket;


public class ClientTest {
    public static void main(String[] arrgs) {
        String name = null;
  

        try {
            Socket s = new Socket("127.0.0.1", 5434);

            ChatThread chatThread = new ChatThread(s);
            chatThread.start();

          
            
            CommunicateThread communicateThread = new CommunicateThread(s);
            
            BufferedReader inputName = new BufferedReader(new java.io.InputStreamReader(System.in));
            System.out.println("닉네임을 입력하세요 : ");
            name = inputName.readLine();
            System.out.println("Welcome ("+name+")!");
            System.out.println("====================");
            System.out.println("채팅방 생성");
            

            communicateThread.start();
            communicateThread.outMessage(name);

  
            //pw.close();
            s.close();
            System.out.println("서버 접속 해제");

            if(chatThread.isAlive()) {
                chatThread.interrupt();;
                chatThread = null;
            }
            if(communicateThread.isAlive()) {
                communicateThread.interrupt();;
                communicateThread = null;
            }
            
        } catch (Exception e) {
            e.printStackTrace();

        }
        

        
        
        
    }
    
}
