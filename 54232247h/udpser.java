import java.io.IOException;
import java.net.*;


public class udpser{
    public static void main(String[] args) {
        if(args.length!=2){
            System.out.println("El número de parametros por argumento es incorrecto");
        }
        else{
        try{
        int puerto=Integer.parseInt(args[0]);
        
        
        String[] cadenas =new String[3];
        int secreto=Integer.parseInt(args[1]);
        int puerto_Cli;
        int resultado=0;
        InetAddress IP_Cli;
        
            
            DatagramSocket socket=new DatagramSocket(puerto);
            while(true){
            byte[] buffer=new byte[200];
            DatagramPacket paquete=new DatagramPacket(buffer,buffer.length);
            socket.receive(paquete);
            System.out.println("Paquete recibido del cliente");

            String cadena =new String(paquete.getData());
            
            //Realizamos la operacion
            cadenas=cadena.split("_");
            
            int num1=Integer.parseInt(cadenas[0]);
            int num2=Integer.parseInt(cadenas[2].trim());
            String operando=cadenas[1];
            switch(operando){
                case "+":
                System.out.println("Suma de "+num1+"+"+num2);
                resultado = (num1 + num2)+ secreto;
                System.out.println("Result is "+resultado);
                break;
                case "-":
                System.out.println("Resta de" +num1+"-"+num2);
                resultado= (num1 - num2)+ secreto;
                break;
                case "*":
                System.out.println("Producto de "+num1+"*"+num2);
                resultado = (num1 * num2)+ secreto;
                break;
                case "/":
                System.out.println("División de "+num1+"/"+num2);
                resultado = (num1 / num2)+ secreto;
                break;
                default:
                System.out.println("Error en la operacion");
            }
            
            puerto_Cli=paquete.getPort();
            IP_Cli=paquete.getAddress();
            
            byte[] buffer2=(Integer.toString(resultado)).getBytes();
            DatagramPacket respuesta=new DatagramPacket(buffer2, buffer2.length,IP_Cli,puerto_Cli);
            
            socket.send(respuesta);
            buffer=null;
            buffer2=null;
            
        }
    
    } catch (IOException ex) {
        
    }

    }
    }
}
