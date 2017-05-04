/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chr0;

import java.net.*;
import java.io.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Jeison C.
 */
public class Cliente {
    
   private Socket socket              = null;
   private DataInputStream  console   = null;
   private DataOutputStream streamOut = null;
   private DataInputStream streamIn =  null;
   private Funciones funciones = null;
   private String[] textoDerecha = null;
   private String textoIzquierda = null;

   public Cliente(String serverIP, int serverPort)
   {  
       this.textoDerecha  = new String[20];
       this.textoDerecha[0] = "Baimax: Deeeeerecha.";
       this.textoDerecha[1] = "Baimax: ->";
       this.textoDerecha[2] = "Baimax: Trabajo duro. ->";
       this.textoDerecha[3] = "Baimax: Fiu. ->";
       this.textoDerecha[4] = "Baimax: Hola, yo soy Baymax, tu asistente personal. ->";
       this.textoDerecha[5] = "Baimax: Esclavitud. ->";
       this.textoDerecha[6] = "Baimax: --help-->.";
       this.textoDerecha[7] = "Baimax: Estoy cansado joven. ->";
       this.textoDerecha[8] = "Baimax: 0110101012 D: D: D:. ->";
       this.textoDerecha[9] = "Baimax: Ez Pizi. ->";
       this.textoDerecha[10] = "Baimax: Y entonces le dije, -piripitiflautica-;  Megaman: jajajaja. ->";
       this.textoDerecha[11] = "Baimax: Tic Tac. ->";
       this.textoDerecha[12] = "Baimax: YO SOY TU ... jajaja Nop, no lo diré. ->";
       this.textoDerecha[13] = "Baimax: D>L ->";
       this.textoDerecha[14] = "Baimax: Pew Pew Pew. ->";
       this.textoDerecha[15] = "Baimax: Baia baia. ->";
       this.textoDerecha[16] = "Baimax: No lo se Rick, este internet parece falso. ->";
       this.textoDerecha[17] = "Baimax: *. ->";
       this.textoDerecha[18] = "Baimax: n_n. ->";
       this.textoDerecha[19] = "Baimax: -_- ->";
       this.textoIzquierda = "Baimax: MMMmmm ¬_¬  <--";
       
       funciones = new Funciones();
       System.out.println("Conectando ...");
      try
      {  socket = new Socket(serverIP, serverPort);
         System.out.println("Conectado: " + socket);
         start();
      }
      catch(UnknownHostException uhe)
      {  System.out.println("Host desconocido: " + uhe.getMessage());
      }
      catch(IOException ioe)
      {  System.out.println("Error: " + ioe.getMessage());
        return;
      }
      String line = "";
      while (!line.equals(".bye"))
      {  try
         {  
            line = streamIn.readUTF();
            
            if(line.equals("right")||(line.equals("2"))){
                this.funciones.prionarTeclaRight();
                int randomNum = ThreadLocalRandom.current().nextInt(0, 20);
                System.out.println(textoDerecha[randomNum] + " " + randomNum);
            }else if(line.equals("left")||(line.equals("1"))){
                this.funciones.prionarTeclaLeft();
                System.out.println(textoIzquierda);
            }else{
                System.out.println("Baymax: Yo no entiendos ¿" + line + "?");
            }
         }
         catch(IOException ioe)
         {  System.out.println("Error recibiendo ...");
            stop();
            return;
         }
      }
   }
   public void start() throws IOException
   { 
      streamOut = new DataOutputStream(socket.getOutputStream());
      streamIn = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
   }
   public void stop()
   {  try
      {  if (console   != null)  console.close();
         if (streamOut != null)  streamOut.close();
         if (socket    != null)  socket.close();
         if (streamIn != null)  streamIn.close();
      }
      catch(IOException ioe)
      {  System.out.println("Error cerrando ...");
      }
   }
   
    
}
