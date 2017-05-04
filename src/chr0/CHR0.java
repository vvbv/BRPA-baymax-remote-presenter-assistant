/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chr0;

/**
 *
 * @author Jeison C.
 */
public class CHR0 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String ayuda = "\n    Baymax\n\n"
                + "      -servidor <puerto>\n"
                + "      -cliente <IP_servidor> <puerto>\n"
                + "      -s <puerto>\n"
                + "      -c <IP_servidor> <puerto>\n\n";
        if(args.length == 0){
            System.out.print(ayuda);
        }else{
        
            if((args[0].equals("-s"))||(args[0].equals("-servidor"))){
                if(args.length == 2){
                    try {
                        int puerto = Integer.valueOf(args[1]) + 1;
                        //Iniciar servidor
                        Servidor server = null;
                        server = new Servidor(Integer.valueOf(args[1]));
                    } catch (ArithmeticException e) {
                        System.out.print(ayuda);
                        return;
                    }
                }else{
                    System.out.print(ayuda);
                }
            }else if((args[0].equals("-c"))||(args[0].equals("-cliente"))){
                if(args.length == 3){
                    try {
                        int puerto = Integer.valueOf(args[2]) + 1;
                        //Conectar Servidor
                        Cliente client = null;
                        client = new Cliente(args[1], Integer.valueOf(args[2]));
                    } catch (ArithmeticException e) {
                        System.out.print(ayuda);
                        return;
                    }
                }else{
                    System.out.print(ayuda);
                    return;
                }
            }else{
                System.out.print(ayuda);
                return;
            }
        }
    }
}
