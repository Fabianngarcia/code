package P3;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class P3 {
    static ClientNormal[] normalClients=new ClientNormal[25];
    static ClientVIP[] vipClients=new ClientVIP[25];
    static ClientPremium[] premiumClients=new ClientPremium[25];
    static int i=0;
    static int j=0;
    static int k=0;

    public static void main(String[] args) {
    // atributos de varios clientes
    // atributos de varios clientes normales
    

    String id3="ES628875432L", country3="Spain";
    int points3=300, dep3=100;
    String id4="FR07451345R", country4="France7";
    int points4=400, dep4=1200;
    String id5="UK35785436K", country5="UK";
    int points5=10000, dep5=400;
    //String id6="DE44785437K", country6="DE";
    //int points6=600, dep6=1400;
    ClientNormal cliente1=new ClientNormal("ES11111111S","Spain",250,200);
    ClientNormal cliente2=new ClientNormal();
    cliente2.setId("FR22222222X");
    cliente2.setCountry("France");
    cliente2.setDeposit(400);
    cliente2.setPoints(350);
    System.out.println("cliente1:"+cliente1.toString());
    System.out.println("cliente2:"+cliente2.toString());
    int x=0;//Cliente3
    if(!ClientNormal.isValidId(id3)){
        System.out.println("Incorrect id value:"+id3+".Not comply with format "+ClientNormal.ID_FORMAT);
        x=1;
    }
    if(!ClientNormal.isValidCountry(country3)){
        System.out.println("Incorrect country name:"+country3+".Valid name must contain only letters");
        x=1;
    }
    if(!ClientNormal.isValidPoints(points3)){
        System.out.println("Incorrect points value:"+points3+".Valid range is "+ClientNormal.MIN_POINTS+"-"+ClientNormal.MAX_POINTS);
        x=1;
    }
    if(!ClientNormal.isValidDeposit(dep3)){
        System.out.println("Incorrect deposit value:"+dep3+".Valid range is "+ClientNormal.MIN_DEPOSIT+"-"+ClientNormal.MAX_DEPOSIT);
        x=1;
    }
    if(x==0){
        ClientNormal cliente3=new ClientNormal(id3,country3,points3,dep3);
        System.out.println("cliente3:"+cliente3.toString());
    }
    x=0;//Cliente4
    if(!ClientNormal.isValidId(id4)){
        System.out.println("Incorrect id value:"+id4+".Not comply with format "+ClientNormal.ID_FORMAT);
        x=1;
    }
    if(!ClientNormal.isValidCountry(country4)){
        System.out.println("Incorrect country name:"+country4+".Valid name must contain only letters");
        x=1;
    }
    if(!ClientNormal.isValidPoints(points4)){
        System.out.println("Incorrect points value:"+points4+".Valid range is "+ClientNormal.MIN_POINTS+"-"+ClientNormal.MAX_POINTS);
        x=1;
    }
    if(!ClientNormal.isValidDeposit(dep4)){
        System.out.println("Incorrect deposit value:"+dep4+".Valid range is "+ClientNormal.MIN_DEPOSIT+"-"+ClientNormal.MAX_DEPOSIT);
        x=1;
    }
    if(x==0){
        ClientNormal cliente4=new ClientNormal(id4,country4,points4,dep4);
        System.out.println("cliente4:"+cliente4.toString());
    }
    x=0;//Cliente5

    if(!ClientNormal.isValidId(id5)){
        System.out.println("Incorrect id value:"+id5+".Not comply with format "+ClientNormal.ID_FORMAT);
        x=1;
    }
    if(!ClientNormal.isValidCountry(country5)){
        System.out.println("Incorrect country name:"+country5+".Valid name must contain only letters");
        x=1;
    }
    if(!ClientNormal.isValidPoints(points5)){
        System.out.println("Incorrect points value:"+points5+".Valid range is "+ClientNormal.MIN_POINTS+"-"+ClientNormal.MAX_POINTS);
        x=1;
    }
    if(!ClientNormal.isValidDeposit(dep5)){
        System.out.println("Incorrect deposit value:"+dep5+".Valid range is "+ClientNormal.MIN_DEPOSIT+"-"+ClientNormal.MAX_DEPOSIT);
        x=1;
    }
    if(x==0){
        ClientNormal cliente5=new ClientNormal(id5,country5,points5,dep5);
        System.out.println("cliente5:"+cliente5.toString());
    }
    readClientsFile("P3/"+args[0]);
    computeTotalCardPoints();
    increasePremiumPoints(10);
    writePremiumFile("P3/"+args[1]);
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
        
    }catch (FileNotFoundException e) {
            
        }
    }
    public static int computeTotalCardPoints(){
        int suma=0;
        for(int a=0;a<i;a++){
            suma=normalClients[a].getPoints() + suma;
        }
        for(int a=0;a<j;a++){
            suma=vipClients[a].getPoints() + suma;
        }
        for(int a=0;a<k;a++){
            suma=premiumClients[a].getPoints() + suma;
        }
        System.out.println("Suma de puntos de las tarjetas= "+suma);
        return suma;
        
    }
    public static void increasePremiumPoints(float incr){
        for(int a =0;a<k;a++){
            int p=premiumClients[a].getPoints();
            float pp=((incr/100) *p);
            //int valor=(int)Math.ceil(pp);
            premiumClients[a].addPoints((int)pp);
            
        }
    }
    public static void writePremiumFile(String Filename){
        try{
        File fichero1=new File(Filename);
        PrintWriter pw=new PrintWriter(fichero1);
        for(int a=0;a<k;a++){
        pw.println(premiumClients[a].toString());
        }
        pw.close();
        }catch(FileNotFoundException r){}

    }

    
}