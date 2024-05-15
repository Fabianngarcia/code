package p9;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class ClientDB{
    static LinkedHashMap<String,Client> clients;
    static int i=0;
    public ClientDB(){
        clients=new LinkedHashMap<String,Client>();
    }
    public static void readClientsFile(String filename){
        try{
        File fichero1=new File(filename);//fichero de clientes
        
        
            Scanner scan=new Scanner(fichero1);
            
            while(scan.hasNext()){
                String cadena=scan.nextLine();
                
                cadena=cadena.trim();
                if(cadena.length()==0){
                    continue;
                }
                if(cadena.charAt(0)!='#'){
                    String[] c=cadena.split(";");
                    if(c[0].charAt(0)=='N'){
                        if(ClientNormal.isValidId(c[1])){
                            if(ClientNormal.isValidCountry(c[2])){
                                if(ClientNormal.isValidPoints(Integer.parseInt(c[3]))){
                                    if(ClientNormal.isValidPoints(Integer.parseInt(c[4]))){
                                        
                                        clients.put(c[1],new ClientNormal(c[1],c[2],Integer.parseInt(c[3]),Integer.parseInt(c[4])));
                                      
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
                                        
                                        clients.put(c[1],new ClientVIP(c[1],c[2],Integer.parseInt(c[3]),Float.parseFloat(c[4])));
                                      
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
                                            clients.put(c[1],new ClientPremium(c[1],c[2],Integer.parseInt(c[3]),Float.parseFloat(c[4]),Integer.parseInt(c[5])));
                                           
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
      
            if(clients.containsKey(Idobject)){
                
                return clients.get(Idobject);
                
            }
            else{
          
        
                return null;
            }
    }
    public int computeTotalPoints(){
        int suma =0;
        for(Client aux : clients.values()){
            
            suma=suma + aux.getTotalPoints();
            
        }
        return suma;
    }
    public float computeAverageSeniority(){
        int contador=0;
        float media=0;

        for(Client aux : clients.values()){
            
            if(aux instanceof ClientVIP && !(aux instanceof ClientPremium)){//Vip
                
                media=((ClientVIP)aux).getSeniority() + media;
                contador++;
            }
            else if(aux instanceof ClientVIP && aux instanceof ClientPremium){//Premium
                
                media=((ClientVIP)aux).getSeniority() + media;
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
            for(Client aux : clients.values()){
                String ajuste=aux.toString();
                if(aux instanceof ClientVIP && aux instanceof ClientPremium){//Premium
                    
                    
                    String[] ff=ajuste.split("\\.");
                    
                    pw.println(ff[0] + "," + ff[1]);
                    
                }
                else if(aux instanceof ClientVIP && !(aux instanceof ClientPremium)){//Vip
                    
                    
                    String[] ff=ajuste.split("\\.");
                    pw.println(ff[0] + "," + ff[1]);
                    
                }
                else{
                    
                    pw.println(ajuste);
                }
            }
            pw.close();
        }catch(FileNotFoundException e){}
    }
    public void increaseCardPoints(String id,String checkInDate,String checkOutDate){
        for(Client x:clients.values()){
            if(x.getId().equals(id)){
              
                int days=stayDays(checkInDate,checkOutDate);
                int stayPoints;
                if(x instanceof ClientNormal){               
                    stayPoints=days * ClientNormal.POINTS_DAY;
                }
                else{
                    stayPoints=days * ClientVIP.POINTS_DAY;
                }
               
                x.addPoints(stayPoints);

            }
        } 
    }
    private int stayDays (String checkInDate, String checkOutDate) {
        long days;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yy");
        LocalDate parsedDateIn = LocalDate.parse(checkInDate, formatter);
        LocalDate parsedDateOut = LocalDate.parse(checkOutDate, formatter);
        days = ChronoUnit.DAYS.between(parsedDateIn, parsedDateOut);
        return (int)days;
        }
    public void sortById(){
        ArrayList <Client>lista=new ArrayList<Client>();
        lista.addAll(clients.values());
        Collections.sort(lista);
        clients.clear();
        for(Client aux:lista){
            clients.put(aux.getId(),aux);
        }
    }
    public void sortByPointsAndId(){
        ArrayList <Client>lista=new ArrayList<Client>();
        lista.addAll(clients.values());
        Collections.sort(lista,new ClientComparatorByPointsAndId());
        clients.clear();
        for(Client aux:lista){
            clients.put(aux.getId(),aux);
        }
        
    }
}
