
public class ImprimeNumerosMax{
    public static void main(String[] args){
        String cadena=args[0];
        int max=0;
        switch (cadena.toUpperCase()) {
            case "UNO":
               max=1; 
            break;
            case "DOS":
            max=2;
            break;
            case "TRES":
            max=3;
            break;
            case "CUATRO":
            max=4;
            break;
            case "CINCO":
            max=5;
            break;
            case "SEIS":
            max=6;
            break;
            case "SIETE":
            max=7;
            break;
            case "OCHO":
            max=8;
            break;
            case "NUEVE":
            max=9;
            break;
            default:
            System.out.print("Numero mayor que 9");
                break;
        }
        for(int i=0;i<max;i++){
            System.out.print(""+i);
            if(i%2==0){
                System.out.print("(Es par)");
            }
            System.out.println("");
        }
    }
}
    
    
 
