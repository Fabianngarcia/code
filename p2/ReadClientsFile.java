import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class ReadClientsFile{
    public static void main(String[] args){
        try{
        File fichero=new File(args[0]);
        Scanner scan=new Scanner(fichero);
        while(scan.hasNext()){
            String cadena=scan.nextLine();
            if(cadena.charAt(0)!='#'){
                String[] c=cadena.split(";");
                if(c[0].charAt(0)=='N'){
                    System.out.print("Tipo:N ID:"+c[1]+" Pais:"+c[2]+" Puntos:"+c[3]+" Deposito:"+c[4]);
                    if(c.length>5){
                        System.out.print(" Facturas:");
                        for(int i=5;i<c.length;i++){
                            System.out.print(c[i]);
                            if((i+1)<c.length){
                                System.out.print(" ");
                            }
                            else{
                                System.out.println("");
                            }
                        }

                    }
                    else{
                        System.out.println("");
                    }
                }
                else if(c[0].charAt(0)=='V'){
                    System.out.print("Tipo:V ID:"+c[1]+" Pais:"+c[2]+" Puntos:"+c[3]+" Antig.:"+c[4]);
                    if(c.length>5){
                        System.out.print(" Facturas:");
                        for(int i=5;i<c.length;i++){
                            System.out.print(c[i]);
                            if((i+1)<c.length){
                                System.out.print(" ");
                            }
                            else{
                                System.out.println("");
                            }
                        }

                    }
                    else{
                        System.out.println("");
                    } 

                }
                else{
                    System.out.print("Tipo:P ID:"+c[1]+" Pais:"+c[2]+" Puntos:"+c[3]+" Antig.:"+c[4]+" Credito:"+c[5]);
                    if(c.length>6){
                        System.out.print(" Facturas:");
                        for(int i=6;i<c.length;i++){
                            System.out.print(c[i]);
                            if((i+1)<c.length){
                                System.out.print(" ");
                            }else{
                                System.out.println("");
                            }
                        }

                    }
                    else{
                        System.out.println("");
                    }
                }

                
            
            }
          
        }
        }catch(FileNotFoundException e){}
    }
}