package p9;
public abstract class Client implements Comparable<Client>{  
    protected String id;//LLNNNNNNNNL;3 letras 8 numeros
    protected String country;
    protected int pointsCard;//0-10000;
    final static String ID_FORMAT="LLDDDDDDDDL";
    final static int MAX_POINTS=10000;
    final static int MIN_POINTS=0;
    

    public Client(){}
    public Client(String id,String country,int pointsCard){
        this.id=id;
        this.country=country;
        this.pointsCard=pointsCard;
    }
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
    public abstract int getTotalPoints();
    public void addPoints(int points){
        pointsCard=pointsCard + points;
        if(pointsCard>10000){
            pointsCard=10000;
        }
    }
    public String getId(){
        return id;
    }
    public String getCountry(){
        return country;
    }
    public int getPoints(){
        return pointsCard;
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

    public String toString(){
        return id+';'+country+';'+pointsCard;
    }
    public int compareTo(Client c){
        
            if(id.compareTo(c.id) > 0){
                return 1;
            }
            else if(id.compareTo(c.id) < 0){
                return -1;

            }
            else{
                return 0;
            }
        
    }

}
