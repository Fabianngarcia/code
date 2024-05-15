import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
public class WriteClientsFile{
    public static void main(String[] args) throws FileNotFoundException{
        File fichero=new File(args[0]);
        if(fichero.isFile()){
            System.out.println("Su fichero se va a borrar,¿quiere continuar?(s/n): ");
            Scanner scan=new Scanner(System.in);
            if((scan.nextLine()).toUpperCase().equals("SI")){
                fichero.delete();
                PrintWriter pw=new PrintWriter(fichero);
                System.out.println("Escribe el contenido del fichero");
                Scanner texto=new Scanner(System.in);
                pw.println(texto.nextLine());
                pw.close();
            }
        }
        else{
            PrintWriter pw=new PrintWriter(fichero); 
            System.out.println("Escribe el contenido del fichero");
            Scanner texto=new Scanner(System.in);
            pw.println(texto.nextLine()); 
            pw.close();
        }
        
    }
}