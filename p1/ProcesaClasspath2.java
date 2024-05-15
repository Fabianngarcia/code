
import java.util.Scanner;

public class ProcesaClasspath2{
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        String cadena=s.nextLine();
        int hh=0;
        String[] v=cadena.split(":");
        String[][] bidim=new String[v.length][50];

        for(int i=0;i<v.length;i++){
            String[] h=v[i].split("/");
            for(int j=0;j<h.length;j++){
                bidim[i][j]=h[j];
            }
            hh=h.length;
        }
        for(int i=0;i<v.length;i++){
            
            for(int j=0;j<hh;j++){
                if(bidim[i][j]!=null){
                System.out.print(""+bidim[i][j]);
                if(bidim[i][j+1]!=null&& j>0){
                if((j+1)!=hh){
                    System.out.print("-");
                }}
            }

                
            }
            System.out.println("");
        }
    
}}