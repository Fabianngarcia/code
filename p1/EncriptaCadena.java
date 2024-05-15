
import java.util.Scanner;
import java.io.*;
public class EncriptaCadena{
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        String cadena=scan.nextLine();
        System.out.println(""+cadena);
        System.out.println(""+cadena.length());
        System.out.println(""+cadena.toLowerCase());
        System.out.println(""+cadena.toUpperCase());
        for(int i=0;i<cadena.length();i++){
            System.out.print(""+(char)((int)cadena.charAt(i)+i));
        }
        System.out.println("");
    } 
}