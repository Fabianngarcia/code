import java.net.*;

import java.io.IOException;


public class udpcli{
    public static void main(String[] args){
        if(args.length!=3){
            System.out.println("El numero de parametros por argumento es incorrecto");
            System.out.println("Se deben pasar 3 argumentos de la forma IP,puerto y operación(Suma: +;Resta: -;Producto: *;División: /)entre '_' ejemplo:127.0.0.1 5000 2_+_3");
        }
        else{
        
        byte[] buffer2=new byte[200];
        int Port_Ser=Integer.parseInt(args[1]);
        String cadena=args[2];
        
        try{
            InetAddress IP_Ser=InetAddress.getByName(args[0]);
            DatagramSocket socket=new DatagramSocket();
            byte[] buffer=cadena.getBytes();
            DatagramPacket respuesta=new DatagramPacket(buffer,buffer.length,IP_Ser, Port_Ser);
            
            socket.send(respuesta); //Enviamos la operacion y los 2 numeros
            socket.setSoTimeout(10000);
            System.out.println("Enviado paquete al servidor");
            DatagramPacket paquete=new DatagramPacket(buffer2,buffer2.length);
            socket.receive(paquete); //Recibimos el resultado
            System.out.println("Paquete recibido del servidor");
            String resultado =new String(paquete.getData());
            System.out.println("El resultado es "+resultado);
            socket.close();
        }catch(SocketTimeoutException e){
            System.out.println("Pasaron los 10 segundos"); 

        }catch(IOException ex){
            
        } 
    
       
        
    }
}
}