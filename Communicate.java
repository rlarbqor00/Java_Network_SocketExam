package Network.Exam5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Communicate {
    BufferedReader br_out;
    PrintWriter pw = null;
    OutputStream os;
    Socket s = null;
    BufferedWriter bw;

    String outMessage = null;
    // Date date;
    // Calendar cal;
  


   public Communicate(Socket s) {
       this.s = s;

   } 
   public void outMessage(String str) {
       try {
        
        os = s.getOutputStream();

        br_out = new BufferedReader(new InputStreamReader(System.in));

        
        bw = new BufferedWriter(new OutputStreamWriter(os));
        
        pw = new PrintWriter(bw, true);

        Time time = new Time();
        time.start();
        
        while(true) {
            outMessage = br_out.readLine();
            if(outMessage.equals("exit")) {
                break;
                
            }


            pw.println(str + " : " + outMessage + "          "+time.time());


            
        }
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
       



   }

  
}
