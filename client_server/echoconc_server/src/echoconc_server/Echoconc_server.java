package echoconc_server;

import java.net.*;
import java.io.*;


public class Echoconc_server {


    public static void main(String[] args) throws Exception {
        System.out.println("Server Signing ON");
        ServerSocket ss = new ServerSocket(9081);
        for(int i=0;i<10;i++){
            Socket soc = ss.accept();
            Conversation c = new Conversation(soc);
            c.start();
        }
        System.out.println("Server Singing OFF");   // TODO code application logic here
    }
}

class Conversation extends Thread {



    Socket soc;



    Conversation(Socket soc) {

        this.soc = soc;

    }



    @Override

    public void run() {

        try {

            BufferedReader nis = new BufferedReader(

                    new InputStreamReader(

                            soc.getInputStream()

                    )

            );

            PrintWriter nos = new PrintWriter(

                                 new BufferedWriter(

                                    new OutputStreamWriter(

                                         soc.getOutputStream()

                                    )

                                 ),true

            );

            String str = nis.readLine();

            while (!str.equals("End")) {
                System.out.println("Server Received " + str);
                nos.println(" I am server " + str);
                str = nis.readLine();
            }
            nos.println("End"); 

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}