package p2;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ReadWriteClientsFile{
    public static void main(String[] args){
        int numclientes=0;
        int[] cliente_length=new int[100];
        try{
            File fichero1=new File(args[0]);
            File fichero2=new File(args[1]);
            Scanner scan=new Scanner(fichero1);
            String[][] clientes=new String[100][100];
            while(scan.hasNext()){
                String cadena=scan.nextLine();
                if(cadena.charAt(0)!='#'){
                    String [] c=cadena.split(";");
                    cliente_length[numclientes]=c.length;
                    for(int k=0;k<c.length;k++){
                        
                        clientes[numclientes][k]=c[k];//Construye el array bidimensional
                    
                }
            
                
                    numclientes++;
                }
            }
            
            String[][] clientes2=new String[numclientes][100];
            for(int j=0;j<numclientes;j++){
                for(int k=0;k<cliente_length[j];k++){
                    clientes2[j][k]=clientes[j][k];
                }
            }
            for(int l=0;l<numclientes;l++){
                clientes[l][1]=clientes2[l][2];//Intercambiamos columnas ID y pais
                clientes[l][2]=clientes2[l][1];
            }
            PrintWriter pw=new PrintWriter(fichero2);
            for(int j=0;j<numclientes;j++){//Escribiendo Vip y Premium
                if(clientes[j][0].charAt(0)=='V'||clientes[j][0].charAt(0)=='P'){
                    for(int k=0;k<cliente_length[j];k++){
                        if(k+1<cliente_length[j]){

                            pw.print(clientes[j][k]+";");
                            
                        }
                        else{

                                pw.println(clientes[j][k]);
                            }
                            
                        
                    }
                    if(clientes[j][4].contains(",")){
                        
                        String[] ff=clientes[j][4].split(",");
                        clientes[j][4]=ff[0]+"."+ff[1];
                    
                    }
                    if(Float.parseFloat(clientes[j][4])>5){
                        pw.println("# good client");
                    }
                }
                else{
                    for(int k=0;k<cliente_length[j];k++){//Escribiendo Normal
                        if(k+1<cliente_length[j]){
                            pw.print(clientes[j][k]+";");
                            
                        }
                        else{
                            
                            pw.println(clientes[j][k]);
                            
                        }
                    } 
                }
            }
    
            pw.close();
        }catch(FileNotFoundException e){}
    }
}
