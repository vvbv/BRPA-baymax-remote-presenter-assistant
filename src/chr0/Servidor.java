/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chr0;

import java.net.*;
import java.io.*;

/**
 *
 * @author Jeison C.
 */
public class Servidor
{  private Socket          socket   = null;
   private ServerSocket    server   = null;
   private DataInputStream streamIn =  null;
   private DataOutputStream streamOut = null;

   public Servidor(int port)
   {  try
      {  System.out.println("Iniciando en el puerto " + port + " ...");
         server = new ServerSocket(port);  
         System.out.println("Servidor iniciado: " + server);
         System.out.println("Esperando cliente ..."); 
         socket = server.accept();
         System.out.println("Cliente aceptado: " + socket);
         open();
         boolean done = false;
         while (!done)
         {  try
            {  
                String line = streamIn.readLine();
                streamOut.writeUTF(line);
                streamOut.flush();
            }
            catch(IOException ioe)
            {  done = true;
            }
         }
         close();
      }
      catch(IOException ioe)
      {  System.out.println(ioe); 
      }
   }
   public void open() throws IOException
   {   streamIn   = new DataInputStream(System.in);
       streamOut = new DataOutputStream(socket.getOutputStream());
   }
   public void close() throws IOException
   {  if (socket != null)    socket.close();
      if (streamOut != null)  streamOut.close();
      if (streamIn != null)  streamIn.close();
   }
}
