import java.util.Scanner;
public class ProcesaClasspath{
    public static void main(String[] args) {
        int usr=0;
        int jar=0;
      System.out.println("Formato Classpath");
      Scanner s=new Scanner(System.in);
      String cadena=s.nextLine();
      String[] v=cadena.split(":");
      System.out.println("Numero de rutas: "+v.length);
      for(int i=0;i<v.length;i++){
        System.out.println(""+v[i]);
      }
      for(int i=0;i<v.length;i++){
        if(v[i].startsWith("/usr")){
            usr=i+1;
        }
        if(v[i].endsWith(".jar")){
            jar++;
        }
      }
      int direct=(v.length) - jar;
      if(usr!=0){
      usr=(v.length) - usr;
      }
      System.out.println("Directorios:"+direct+" USR:"+usr+" JAR:"+jar);

    }
}