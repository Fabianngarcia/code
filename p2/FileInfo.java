import java.io.File;
import java.util.Scanner;
public class FileInfo{
    public static void main(String[] args){
        File fichero=new File(args[0]);
        if(fichero.isFile()){
            System.out.println("Sí existe");
            System.out.println(fichero.getAbsolutePath());
            System.out.println("Tamaño:"+fichero.length());
            if(fichero.canRead()){
                System.out.println("See puede leer");
            }
            else{
                System.out.println("No se puede leer");
            }
            if(fichero.canWrite()){
                System.out.println("See puede escribir");
            }
            else{
                System.out.println("No se puede escribir");
            }
            System.out.println("Ultima modificación: "+fichero.lastModified());
            System.out.print("Nuevo nombre de fichero: ");
            Scanner scan=new Scanner(System.in);

            File fichero2=new File(scan.nextLine());
            fichero.renameTo(fichero2);


        }
        else{
            System.out.println("No existe el fichero");
        }
        
    }
}