import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Scanner;
import java.net.InetSocketAddress;



public class tcp1cli {
    public static void main(String[] args){
        if(args.length!=2){
            System.out.println("Numero de argumentos incorrecto;introduzca la IP y el puerto");
        }
        else{
        String host=args[0];
        DataInputStream in;
        DataOutputStream out;
        try{
        int puerto=Integer.parseInt(args[1]);
        
        while(true){
            Socket scliente=new Socket();
            //scliente.setSoTimeout(15000);
            scliente.connect(new InetSocketAddress(host,puerto),15000);
        Scanner scanf=new Scanner(System.in);
        System.out.println("Introduzca la operacion(3_+_1 ; 6! por ejemplo):");//3_+_1 ; 6! por ejemplo
        String cadena=scanf.nextLine();
       
        if(cadena.equals("QUIT")){
            System.out.println("SE CIERRA EL CLIENTE");
            scliente.close();
            break;

        }
        else{
            byte[] TLV=null;
            if(cadena.contains("_")){
            String[] cadenas =new String[3];
            cadenas=cadena.split("_");
            byte num1=(byte)Integer.parseInt(cadenas[0]);
            TLV=new byte[4];
            byte num2=(byte)Integer.parseInt(cadenas[2]);
            String operando=cadenas[1];
            
            byte l=(byte)2;
            byte t;
            
           
            switch(operando){
                
                case "+":
                t=(byte)1;
                TLV[0]=t;
                TLV[1]=l;
                TLV[2]=num1;
                TLV[3]=num2;
                break;
                case "-":
                t=(byte)2;
                TLV[0]=t;
                TLV[1]=l;
                TLV[2]=num1;
                TLV[3]=num2;
                break;
                case "*":
                t=(byte)3;
                TLV[0]=t;
                TLV[1]=l;
                TLV[2]=num1;
                TLV[3]=num2;
                break;
                case "/":
                t=(byte)4;
                TLV[0]=t;
                TLV[1]=l;
                TLV[2]=num1;
                TLV[3]=num2;
                break;
                case "%":
                t=(byte)5;
                TLV[0]=t;
                TLV[1]=l;
                TLV[2]=num1;
                TLV[3]=num2;
                break;
                default:
                scliente.close();
                System.out.println("Las operaciones son:suma +,resta -,producto *,division /,resto % y factorial !");
                System.out.println("Introdujiste la operacion de forma erronea,en caso de ser 2 numeros debes incluir '_' entre el simbolo de operacion,y para el factorial solo un numero y una exclamacion");
                System.out.println("Por ejemplo: 5_+_3 para las 5 primeras operaciones,y 7! para el factorial");
                
                
            }
        }
        else{
            if(cadena.charAt(cadena.length()-1)=='!'){
               
            TLV=new byte[3];
            byte l=(byte)1;
            byte t=(byte)6;
            String cad=cadena.substring(0,cadena.length()-1);
            
            byte num1=(byte)Integer.parseInt(cad);
            TLV[0]=t;
            TLV[1]=l;
            TLV[2]=num1;
            
        
            }
            else{
                scliente.close();
                System.out.println("Las operaciones son:suma +,resta -,producto *,division /,resto % y factorial !");
                System.out.println("Introdujiste la operacion de forma erronea,en caso de ser 2 numeros debes incluir '_' entre el simbolo de operacion,y para el factorial solo un numero y una exclamacion");
                System.out.println("Por ejemplo: 5_+_3 para las 5 primeras operaciones,y 7! para el factorial");
                continue;
            }
        }
            in=new DataInputStream(scliente.getInputStream());
            out=new DataOutputStream(scliente.getOutputStream());
            
            out.write(TLV);
            byte[] m=new byte[10];
            in.readFully(m);
            byte[] j=new byte[8];
            System.arraycopy(m,2,j,0,8);
            //System.out.println(Arrays.toString(j));
            long x=ByteBuffer.wrap(j).getLong();
            System.out.println("El contador es: "+x);
            
            
        }
        scliente.close();
        }

        }catch(SocketTimeoutException s){
            System.out.println("Pasaron los 15 segundos sin establecer conexion");
        }catch(IOException e){

        }
    }
    }
}
