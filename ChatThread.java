package Network.Exam5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ChatThread extends Thread{ 
    BufferedReader br_in;
    Socket s = null;
    String inMessage = null;
    InputStream is;



    public  ChatThread(Socket s) {
        this.s = s;

        
    }
    public void run() {
        try {
            is = s.getInputStream();

            
            while(true) {
                br_in = new BufferedReader(new InputStreamReader(is));
                inMessage = br_in.readLine();
                System.out.println(inMessage);

            }


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    
}
