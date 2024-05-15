package p9;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class P9{
    static ClientDB cdb=new ClientDB();
    static Hotel miHotel;
    public static void main(String[] args){
        ClientDB.readClientsFile(args[3]);//file3
        System.out.println("Total points= "+cdb.computeTotalPoints());//Esto es antes de incrementar los puntos con los clientyes que salen
        System.out.println("Average Seniority= "+cdb.computeAverageSeniority());
        miHotel=new Hotel(args[0]);//file0
        processIO(miHotel,args[1]);//file1
        miHotel.saveHotelToFile(args[2]);//file2
        cdb.sortById();
        cdb.saveClientsToFile(args[4]);//file4

    }
    public static void processIO(Hotel unHotel,String file){
        File fichero=new File(file);
        try{
        Scanner scan=new Scanner(fichero);
        while(scan.hasNext()){
            String cadena=scan.nextLine();
            cadena=cadena.trim();
            if(cadena.charAt(0)!= '#'){
            String c[]=cadena.split(";");
            if(c[0].charAt(0)=='I'){
                
                unHotel.checkIn(cdb.getClientFromId(c[1]),c[2]);
                
                
            }
            else{
                String fecha_entrada=unHotel.checkOut(c[1]);
                cdb.increaseCardPoints(c[1],fecha_entrada, c[2]);
                
                
            }
        }
        }
    }catch(FileNotFoundException e){}
    }
}
