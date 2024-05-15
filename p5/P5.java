package p5;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class P5{
    static ClientDB cdb=new ClientDB();
    static Hotel miHotel;
    public static void main(String[] args){
        ClientDB.readClientsFile(args[3]);//fichero3
        System.out.println("Total points= "+cdb.computeTotalPoints()); 
        System.out.println("Average Seniority= "+cdb.computeAverageSeniority());
        miHotel=new Hotel(args[0]);//file0
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
            if(c[0].charAt(0)=='I'){
                
                unHotel.checkIn(cdb.getClientFromId(c[1]));
                
                
            }
            else{
                unHotel.checkOut(c[1]);
                
                
            }
        }
    }catch(FileNotFoundException e){}
    }
}