package p6;
public class ClientVIP extends Client{
 
    private float seniority;//Num.reales
    final static int MIN_SENIORITY=0;
    final static int POINTS_YEAR_SENIORITY=1000;
    

    public ClientVIP(){}

    public ClientVIP(String id,String country,int pointsCard,float seniority){
        super(id,country,pointsCard);
        this.seniority=seniority;
    }
    //Metodos
    
    //Metodos estaticos
    
    public static boolean isValidSeniority(float Seniority){
        if(Seniority >MIN_SENIORITY){ //Num.real
            return true;
        }
        else{
            return false;
        }
    }
    
    //Metodos de instancia
    
    
    public int getTotalPoints(){
        return pointsCard + (int)(POINTS_YEAR_SENIORITY * seniority);
    }
    public float getSeniority(){
        return seniority;
    }
    
    public void setSeniority(int seniority){
        this.seniority=seniority;
    }
    public String toString(){
        return "V;"+super.toString()+";"+seniority;
    }

}
        
    
