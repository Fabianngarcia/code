import java.io.*;
import java.util.Scanner;
public class ModificaCadena{
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        String cadena=scan.nextLine();
        int p=0;
        int u=0;
        int z=0;
        if(cadena.contains("nueve")){
            System.out.println("Sí contiene nueve");
            System.out.println(""+cadena.replaceAll("nueve","9"));
        }
        if(cadena.length()>"nueve".length()){
            System.out.println("Es mayor que nueve");
        }
        for(int i=0;i<cadena.length();i++){
        if(Character.toString(cadena.charAt(i)).equals("0")){
             z++;   
        }
    }
        if(z>1){
            p=cadena.indexOf("0");
            u=cadena.lastIndexOf("0");
            String c2=cadena.substring(0,p)+"cero"+cadena.substring(p+1,u)+"cero"+cadena.substring(u+1,cadena.length());
            System.out.println(c2);
        }
        



        }

        

    }
    
