package p6;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientDB{
    static ArrayList<Client>clients;
    static int i=0;
    public ClientDB(){
        clients=new ArrayList<Client>();
    }
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
                                        
                                        clients.add(new ClientNormal(c[1],c[2],Integer.parseInt(c[3]),Integer.parseInt(c[4])));
                                      
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
                                        
                                        clients.add(new ClientVIP(c[1],c[2],Integer.parseInt(c[3]),Float.parseFloat(c[4])));
                                      
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
                                            clients.add(new ClientPremium(c[1],c[2],Integer.parseInt(c[3]),Float.parseFloat(c[4]),Integer.parseInt(c[5])));
                                           
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
            if((clients.get(z).getId()).equals(Idobject)){
                
                return clients.get(z);
                
            }
          
        }
        return null;
    }
    public int computeTotalPoints(){
        int suma =0;
        for(int a=0;a<i;a++){
            
            suma=suma + clients.get(a).getTotalPoints();
            
        }
        return suma;
    }
    public float computeAverageSeniority(){
        int contador=0;
        float media=0;
        for(int a=0;a<i;a++){
            
            if(clients.get(a) instanceof ClientPremium){
                media=((ClientPremium)clients.get(a)).getSeniority() + media;
                contador++;
            }
            else if(clients.get(a) instanceof ClientVIP){
                media=((ClientVIP)clients.get(a)).getSeniority() + media;
                contador++;
            }
        
        }
        media=media/contador;
        return media;
    }
    public void saveClientsToFile(String filename){
        File fichero2=new File(filename);
        try{
            PrintWriter pw=new PrintWriter(fichero2);
            for(int k=0;k<clients.size();k++){
                System.out.println(clients.get(k).toString());
                pw.println((clients.get(k)).toString());
            }
            pw.close();
        }catch(FileNotFoundException e){}
    }
}
