
import java.util.Scanner;
import java.util.Arrays;
public class LeeArray{
    public static void main(String[] args){
        
        int[] numeros=new int[5];
        Scanner scan1=new Scanner(System.in);
        Scanner scan2=new Scanner(System.in);
        Scanner scan3=new Scanner(System.in);
        Scanner scan4=new Scanner(System.in);
        Scanner scan5=new Scanner(System.in);
        
        String cadena1=scan1.nextLine();
        String cadena2=scan2.nextLine();
        String cadena3=scan3.nextLine();
        String cadena4=scan4.nextLine();
        String cadena5=scan5.nextLine();
        numeros[0]=Integer.parseInt(cadena1);
        numeros[1]=Integer.parseInt(cadena2);
        numeros[2]=Integer.parseInt(cadena3);
        numeros[3]=Integer.parseInt(cadena4);
        numeros[4]=Integer.parseInt(cadena5);
        for(int i =0;i<5;i++){
            System.out.print(""+numeros[i]);
        }
        System.out.println("");
        Arrays.sort(numeros);
        for(int i =0;i<5;i++){
            System.out.print(""+numeros[i]);
        }
        System.out.println("");
    }
}