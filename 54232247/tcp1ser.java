import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;



public class tcp1ser {
    public static void main(String [] args){
        if(args.length!=1){
            System.out.println("Numero de argumentos incorrecto;introduzca solo el puerto");
        }
        else{
        int puerto=Integer.parseInt(args[0]);
        try{
        
        System.out.println("Servidor iniciado");
        
        DataInputStream in;
        DataOutputStream out;
        /*ServerSocket servidor=new ServerSocket(puerto);
        scliente=servidor.accept();*/
        long contador=0;
        
            
            ServerSocket servidor;
            Socket scliente;
            servidor=new ServerSocket(puerto);
            scliente=servidor.accept();
            
        while(true){
            
            
            
            byte[] message=new byte[4];
   
            
            in=new DataInputStream(scliente.getInputStream());
            out=new DataOutputStream(scliente.getOutputStream());
            String l="0";
            in.read(message);
            
            String t=String.valueOf(message[0]);
            l=String.valueOf(message[1]);
            int num1=(int)message[2];
            //System.out.println(l);
            if(!(l.equals("2") || l.equals("1"))){
                
                //ssscliente.close();
                scliente=servidor.accept();
                continue;
            }
            if(l.equals("2")){
                
                int num2=(int)message[3];
                switch(t){
                    case("1")://Suma
                    contador=contador + (num1 + num2);
                    System.out.println(num1+" + "+num2+" = "+(num1 + num2));
                    break;
                    case("2")://Resta
                    contador=contador + (num1 - num2);
                    System.out.println(num1+" - "+num2+" = "+(num1 - num2));
                    break;
                    case("3")://Producto
                    contador=contador + (num1 * num2);
                    System.out.println(num1+" * "+num2+" = "+(num1 * num2));
                    break;
                    case("4")://Division
                    contador=contador + (num1 / num2);
                    System.out.println(num1+" / "+num2+" = "+(num1 / num2));
                    break;
                    case("5")://Resto
                    contador=contador + (num1 % num2);
                    System.out.println(num1+" % "+num2+" = "+(num1 % num2));
                    break;
                    default:
                    System.out.println("Error");
                    break;
                }
            }
            else{
                //System.out.println("Factorial");
                long resultado=1;
                for(int i=num1;i>0;i--){//Factorial
                    resultado=resultado*i;
                }
                System.out.println(num1+"! = "+resultado);
                contador=contador + resultado;
            }
            ByteBuffer buffer=ByteBuffer.allocate(8);
            byte[] ss=new byte[8];
            buffer.order(ByteOrder.BIG_ENDIAN);
            buffer.putLong(contador);
            ss=buffer.array();
            byte[] result=new byte[10];
            
            System.arraycopy(ss,0,result,2,8);
            result[0]=(byte)16;
            result[1]=(byte)8;
            
            
            //System.out.println(Arrays.toString(result));
            out.write(result);
            
            
            
            
           
        }
        }catch(IOException e){}
    }
    }
    
}
