import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class MiThread extends Thread{
    Socket scliente;
    DataInputStream in;
    DataOutputStream out;
    byte[] message=new byte[4];
    public MiThread(Socket cliente,DataInputStream in,DataOutputStream out,byte[] buffer ){
        scliente=cliente;
        this.in=in;
        this.out=out;
        message=buffer;
        
    }
    public void run(){
        try{
            String ipCliente = scliente.getInetAddress().getHostAddress();
            int puertoCliente = scliente.getPort();
            long contador=0;
            
            
          
            
            
   
            while(true){
            //in=new DataInputStream(scliente.getInputStream());
            //out=new DataOutputStream(scliente.getOutputStream());
          
            int n=0;
            String l="0";
            String error=null;
            int p=in.read(message);
            
            String t=String.valueOf(message[0]);
            /*if(t.equals("0")){
                
                break;
            }*/
            if(p==-1){
                break;
            }
            l=String.valueOf(message[1]);
            int num1=(int)message[2];
            
            if(l.equals("2")){
                
                int num2=(int)message[3];
                switch(t){
                    case("1")://Suma
                    contador=contador + (num1 + num2);
                    
                    
                    System.out.print(num1+" + "+num2+" = "+(num1 + num2));
                    System.out.println(" | IP: "+ipCliente+" y Puerto: "+puertoCliente);
                    break;
                    case("2")://Resta
                    contador=contador + (num1 - num2);
                  
                    
                    System.out.print(num1+" - "+num2+" = "+(num1 - num2));
                    System.out.println(" | IP: "+ipCliente+" y Puerto: "+puertoCliente);
                    break;
                    case("3")://Producto
                    contador=contador + (num1 * num2);
                    
                    
                    System.out.print(num1+" * "+num2+" = "+(num1 * num2));
                    System.out.println(" | IP: "+ipCliente+" y Puerto: "+puertoCliente);
                    break;
                    case("4")://Division
                    if(num2==0){
                        error ="Division entre 0";
                        n++;
                    }
                    else{
                    contador=contador + (num1 / num2);
                
                    
                    
                    System.out.print(num1+" / "+num2+" = "+(num1 / num2));
                    System.out.println(" | IP: "+ipCliente+" y Puerto: "+puertoCliente);
                    }
                    break;
                    case("5")://Resto
                    if(num2==0){
                        error="Resto de 0";
                        n++;
                    }
                    else{
                    contador=contador + (num1 % num2);
                    
                    
                    System.out.print(num1+" % "+num2+" = "+(num1 % num2));
                    System.out.println(" | IP: "+ipCliente+" y Puerto: "+puertoCliente);
                    }
                    break;
                    default:
                    System.out.println("Error");
                    break;
                }
            }
            else{
                if(num1<0){
                    error="Factorial de un numero negativo";
                    n++;
                }
                else{
                long resultado=1;
                double resultado2=1;
                
                for(int i=num1;i>0;i--){//Factorial
                    resultado=resultado*i;
                    resultado2=resultado2*i;
                }
                if(resultado2 != resultado){
                    n++;
                    error="Overflow";
                }
                else{
                System.out.print(num1+"! = "+resultado);
                System.out.println(" | IP: "+ipCliente+" y Puerto: "+puertoCliente);
                contador=contador + resultado;
                
                
            }
                
                
            }
            }
            
            
            if(error!= null){
                System.out.print(error);
                System.out.println(" | IP: "+ipCliente+" y Puerto: "+puertoCliente);
            }

            if(n==1){//Que hay un error vaya
                ByteBuffer buffer=ByteBuffer.allocate(8);
                byte[] ss=new byte[8];
                buffer.order(ByteOrder.BIG_ENDIAN);
                buffer.putLong(contador);
                ss=buffer.array();
                byte[] cadena=error.getBytes();
                int tam=cadena.length;
                int total =tam + 12;
                byte[] result=new byte[total + 2];
                result[0]=(byte)10;
                result[1]=(byte)total;
                result[2]=(byte)11;
                result[3]=(byte)tam;
                byte[] ff=new byte[2];
                ff[0]=(byte)16;
                ff[1]=(byte)8;
                System.arraycopy(cadena,0,result,4,tam);
                
                System.arraycopy(ff,0,result,tam+4,2);
                System.arraycopy(ss,0,result,6+tam,8);
                out.write(result);
                //System.out.println(Arrays.toString(result));
                
                 

            }
            else{
            ByteBuffer buffer=ByteBuffer.allocate(8);
            byte[] ss=new byte[8];
            buffer.order(ByteOrder.BIG_ENDIAN);
            buffer.putLong(contador);
            ss=buffer.array();
            byte[] result=new byte[12];
            
            System.arraycopy(ss,0,result,4,8);
            result[0]=(byte)10;
            result[1]=(byte)10;
            result[2]=(byte)16;
            result[3]=(byte)8;
            out.write(result);
            }
            
            
           
            
            
            
            //scliente.close();
            
        }
        //scliente.close();
        }catch(IOException a){}
    }
}
