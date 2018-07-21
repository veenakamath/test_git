package echoserver;

import java.net.*;
import java.io.*;

public class Echoserver {

    public static void main(String[] args) throws Exception {

        System.out.println("Server Signing ON");

       ServerSocket ss = new ServerSocket(9081);

        Socket soc = ss.accept();

        PrintWriter nos = new PrintWriter(
                new BufferedWriter(
                        new OutputStreamWriter(
                                soc.getOutputStream()
                        )
                ),
                true);

        BufferedReader nis = new BufferedReader(
                new InputStreamReader(
                        soc.getInputStream()
                )
        );
        System.out.println(" inside server ");
        String str = nis.readLine();
        while (!str.equals("End")) {
            System.out.println("Server received " + str);
            nos.println(" how are u " + str);
            str = nis.readLine();
        }
        nos.println("End");
        System.out.println("Server Signing OFF");

    }

}
