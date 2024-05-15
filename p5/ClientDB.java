package p5;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

public class ClientDB{
    static Client[] clients=new Client[100];
    static int i=0;
    public static void readClientsFile(String filename){
        try{
        File fichero1=new File(filename);//fichero de clientes
        
        
            Scanner scan=new Scanner(fichero1);
            
            while(scan.hasNext()){
                String cadena=scan.nextLine();
                if(cadena.charAt(0)!='#'){
                    String[] c=cadena.split(";");
                    if(c[0].charAt(0)=='N'){
                        if(ClientNormal.isValidId(c[1])){
                            if(ClientNormal.isValidCountry(c[2])){
                                if(ClientNormal.isValidPoints(Integer.parseInt(c[3]))){
                                    if(ClientNormal.isValidPoints(Integer.parseInt(c[4]))){
                                        
                                        clients[i]=new ClientNormal(c[1],c[2],Integer.parseInt(c[3]),Integer.parseInt(c[4]));
                                      
                                        i++;
                                    }
                                }
                            }
                        }
                    }
                    else if(c[0].charAt(0)=='V'){
                        if(ClientVIP.isValidId(c[1])){
                            if(ClientVIP.isValidCountry(c[2])){
                                if(ClientVIP.isValidPoints(Integer.parseInt(c[3]))){
                                    if(c[4].contains(",")){
                                        String[] ff=c[4].split(",");
                                        c[4]=ff[0]+"."+ff[1];
                                    }
                                    if(ClientVIP.isValidSeniority(Float.parseFloat(c[4]))){
                                        
                                        clients[i]=new ClientVIP(c[1],c[2],Integer.parseInt(c[3]),Float.parseFloat(c[4]));
                                      
                                        i++;
                                        
                                    }
                                }
                            }
                        }
                    }
                    else if(c[0].charAt(0)=='P'){
                        if(ClientPremium.isValidId(c[1])){
                            if(ClientPremium.isValidCountry(c[2])){
                                if(ClientPremium.isValidPoints(Integer.parseInt(c[3]))){
                                    if(c[4].contains(",")){
                                        String[] ff=c[4].split(",");
                                        c[4]=ff[0]+"."+ff[1];
                                    }
                                    if(ClientPremium.isValidSeniority(Float.parseFloat(c[4]))){
                                        if(ClientPremium.isValidCredit(Integer.parseInt(c[5]))){
                                            clients[i]=new ClientPremium(c[1],c[2],Integer.parseInt(c[3]),Float.parseFloat(c[4]),Integer.parseInt(c[5]));
                                           
                                        i++;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        
        }catch (FileNotFoundException e) {} 
    }
    public Client getClientFromId(String Idobject){
        for(int z=0;z<i;z++){
            if((clients[z].getId()).equals(Idobject)){
                
                return clients[z];
                
            }
          
        }
        return null;
    }
    public int computeTotalPoints(){
        int suma =0;
        for(int a=0;a<i;a++){
            
            suma=suma + clients[a].getTotalPoints();
            
        }
        return suma;
    }
    public float computeAverageSeniority(){
        int contador=0;
        float media=0;
        for(int a=0;a<i;a++){
            
            if(clients[a] instanceof ClientPremium){
                media=((ClientPremium)clients[a]).getSeniority() + media;
                contador++;
            }
            else if(clients[a] instanceof ClientVIP){
                media=((ClientVIP)clients[a]).getSeniority() + media;
                contador++;
            }
        
        }
        media=media/contador;
        return media;
    }
}
