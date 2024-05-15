
public class ImprimeNumeros9{
    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            System.out.print(""+i);
            if(i%2==0){
                System.out.print("(Es par)");
            }
            System.out.println("");
        }
    }
}