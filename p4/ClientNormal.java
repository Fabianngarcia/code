package p4;
public class ClientNormal{
    
    private String id;//LLNNNNNNNNL;3 letras 8 numeros
    private String country;
    private int pointsCard;//0-10000;
    private int deposit;//0-1000;
    final static String ID_FORMAT="LLDDDDDDDDL";
    final static int MAX_POINTS=10000;
    final static int MIN_POINTS=0;
    final static int MAX_DEPOSIT=1000;
    final static int MIN_DEPOSIT=0;
    

    public ClientNormal(){}

    public ClientNormal(String id,String country,int pointsCard,int deposit){
        this.id=id;
        this.country=country;
        this.pointsCard=pointsCard;
        this.deposit=deposit;
    }
    //Metodos
    
    //Metodos estaticos
    public static boolean isValidId(String I){
        int x=0;
        if(I.length()==11){
        for(int i=0;i<11;i++){
            if(ID_FORMAT.charAt(i)=='L'){
                if((I.charAt(i)>='0') && (I.charAt(i)<='9')){ //Si es true,es un numero
                    }
                else{
                    //Que sea letra
                    x++;
                }

            }
            else{
                if((I.charAt(i)>='0') && (I.charAt(i)<='9')){ //Si es true,es un numero
                    x++;
                }
                else{//Que sea letra    
                }
                
            }
        }
        if(x==11){
            return true;
        }
        else{
            return false;
        }
    }
        else{
            return false;
        }
        
    }
    public static boolean isValidCountry(String Country){
        int x=0;
        for(int i=0;i<Country.length();i++){
            if((Country.charAt(i)>='a'&&Country.charAt(i)<='z')||(Country.charAt(i)>='A'&&Country.charAt(i)<='Z')){
                x++;
            }
        }
        if(x==Country.length()){
            return true;
        }
        else{
            return false;
        }
        
    }
    public static boolean isValidPoints(int Points){
        if(Points <=MAX_POINTS && Points >=MIN_POINTS){ //0-10000
            return true;
        }
        else{
            return false;
        }
    }
    public static boolean isValidDeposit(int Deposit){
        if(Deposit<= MAX_DEPOSIT && Deposit>=MIN_DEPOSIT){ //0-1000
            return true;
        }
        else{
            return false;
        }
    }
    
    //Metodos de instancia
    public String getId(){
        return id;
    }
    public String getCountry(){
        return country;
    }
    public int getPoints(){
        return pointsCard;
    }
    public int getDeposit(){
        return deposit;
    }
    public void setId(String id){
        this.id=id;
    }
    public void setCountry(String country){
        this.country=country;
    }
    public void setPoints(int pointsCard){
        this.pointsCard=pointsCard;
    }
    public void setDeposit(int deposit){
        this.deposit=deposit;
    }
    public String toString(){
        return "N;"+id+";"+country+";"+pointsCard+";"+deposit;
    }

}




        
    
