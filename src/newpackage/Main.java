/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pavel
 */
public class Main {
    public static void main(String[] arg) throws IOException {
    byte[] buff = new byte[10485760];
    new Random().nextBytes(buff);
    long startBuff = System.nanoTime();
    for (byte t : buff){
    try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("file.txt", true))) {       
                bos.write(t);
              //  System.out.println(t);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    long stopBuff = System.nanoTime();
    
    for (byte t : buff){
      try (FileOutputStream bos2 =  new FileOutputStream("file2.txt", true)) {       
                bos2.write(t);
               // System.out.println(t);
            
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    long stopStrem = System.nanoTime();
    //System.out.println(Arrays.toString(buff));
    long speadB = stopBuff-startBuff;
     long speadS = stopStrem-stopBuff;
     int deltSpead = (int) ((speadS-speadB)/1000000000) ;
     System.out.println("SPeaD Buff : " + speadB);
     System.out.println("SPeaD Strem : " +speadS );
     System.out.println("sekonds " +deltSpead);
    }
}
