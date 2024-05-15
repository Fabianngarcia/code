
import java.io.IOException;
public class LeeYOpera{
    public static void main(String[] args) throws IOException{
        String operando=args[1];
        int n1=Integer.parseInt(args[0]);
        int n2=Integer.parseInt(args[2]);
        switch(operando){
            case "+":
            System.out.println("Suma");
            System.out.println(""+(n1+n2));
            break;
            case "-":
            System.out.println("Resta");
            System.out.println(""+(n1-n2));
            break;
            case "x":
            System.out.println("Producto");
            System.out.println(""+(n1*n2));
            break;
            case "/":
            System.out.println("Division");
            System.out.println("Division entera: "+n1/n2);
            System.out.println("Division decimal: "+((float)n1/(float)n2));

            break;
            default:
            System.out.println("Operation error");
            break;

        }

    }
}