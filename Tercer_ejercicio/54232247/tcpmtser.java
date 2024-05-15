
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class tcpmtser {
    public static void main(String[] args){
        
        if(args.length!=1){
            System.out.println("Numero de argumentos incorrecto;introduzca solo el puerto");
        }
        else{
            int puerto=Integer.parseInt(args[0]);
            try{
            ServerSocket servidor=new ServerSocket(puerto);
            Socket scliente;
            DataInputStream in;
            DataOutputStream out;
	        byte[] buffer = new byte[4];
            System.out.println("Servidor iniciado");
            while(true){
                scliente=servidor.accept();
                in=new DataInputStream(scliente.getInputStream());
                out=new DataOutputStream(scliente.getOutputStream());
                MiThread hilo=new MiThread(scliente,in,out,buffer);
                System.out.println("Nuevo hilo");
                hilo.start();
            }
            }catch(IOException e){}
        }
    }
}
