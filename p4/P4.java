package p4;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
public class P4{
    static ClientNormal[] normalClients=new ClientNormal[25];
    static ClientVIP[] vipClients=new ClientVIP[25];
    static ClientPremium[] premiumClients=new ClientPremium[25];
    static int i=0;
    static int j=0;
    static int k=0;
    
    public static void main(String[] args){
        readClientsFile(args[3]);//file3
        Hotel miHotel=new Hotel(args[0]);//file0
        processIO(miHotel,args[1]);//file1
        miHotel.saveHotelToFile(args[2]);//file2
    }
    public static void processIO(Hotel unHotel,String file){
        File fichero=new File(file);
        try{
        Scanner scan=new Scanner(fichero);
        while(scan.hasNext()){
            String cadena=scan.nextLine();
            String c[]=cadena.split(";");
            if(c.length==3){
                unHotel.checkIn(c[1],c[2].charAt(0));
                
            }
            else{
                unHotel.checkOut(c[1]);
                
                
            }
        }
    }catch(FileNotFoundException e){}
    }
    public static void readClientsFile(String filename){
    File fichero1=new File(filename);
    
    try {
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
                                    normalClients[i]=new ClientNormal(c[1],c[2],Integer.parseInt(c[3]),Integer.parseInt(c[4]));
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
                                    vipClients[j]=new ClientVIP(c[1],c[2],Integer.parseInt(c[3]),Float.parseFloat(c[4]));
                                    j++;
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
                                        premiumClients[k]=new ClientPremium(c[1],c[2],Integer.parseInt(c[3]),Float.parseFloat(c[4]),Integer.parseInt(c[5]));
                                    k++;
                                }
                            }
                        }
                    }
                }
            }
        }
    } 
    
    }catch (FileNotFoundException e) {} 
}}
