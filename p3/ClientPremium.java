package P3;
public class ClientPremium{
    private String id;//LLNNNNNNNNL;3 letras 8 numeros
    private String country;
    private int pointsCard;//0-10000;
    private float seniority;//Num.reales
    private int credit;//0-5000
    final static String ID_FORMAT="LLDDDDDDDDL";
    final static int MAX_POINTS=10000;
    final static int MIN_POINTS=0;
    final static int MIN_SENIORITY=0;
    final static int MIN_CREDIT=0;
    final static int MAX_CREDIT=5000;
    

    public ClientPremium(){}

    public ClientPremium(String id,String country,int pointsCard,float seniority,int credit){
        this.id=id;
        this.country=country;
        this.pointsCard=pointsCard;
        this.seniority=seniority;
        this.credit=credit;
    }
    //Metodos
    public void addPoints(int points){
        pointsCard=pointsCard + points;
        if(pointsCard>10000){
            pointsCard=10000;
        }
    }
    
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
    public static boolean isValidSeniority(float Seniority){
        if(Seniority >=MIN_SENIORITY){ //Num.real
            return true;
        }
        else{
            return false;
        }
    }
    public static boolean isValidCredit(int Credit){
        if(Credit >=MIN_CREDIT && Credit <=MAX_CREDIT){//0-5000
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
    public float getSeniority(){
        return seniority;
    }
    public int getCredit(){
        return credit;
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
    public void setSeniority(int seniority){
        this.seniority=seniority;
    }
    public void setCredit(int credit){
        this.credit=credit;
    }
    public String toString(){
        return "P;"+id+";"+country+";"+pointsCard+";"+seniority+";"+credit;
    }

}