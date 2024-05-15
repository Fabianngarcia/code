package p6;
public class ClientPremium extends ClientVIP{
    
    private int credit;//0-5000
    final static int MIN_CREDIT=0;
    final static int MAX_CREDIT=5000;
    

    public ClientPremium(){}

    public ClientPremium(String id,String country,int pointsCard,float seniority,int credit){
        super(id,country,pointsCard,seniority);
        this.credit=credit;
    }
    
    
    //Metodos estaticos
   
    public static boolean isValidCredit(int Credit){
        if(Credit >=MIN_CREDIT && Credit <=MAX_CREDIT){//0-5000
            return true;
        }
        else{
            return false;
        }
    }
    
    //Metodos de instancia
   
    public int getCredit(){
        return credit;
    }
   
    public void setCredit(int credit){
        this.credit=credit;
    }
    public String toString(){
        String aux=super.toString();
        aux=aux.substring(2,aux.length());
        return "P;"+aux+";"+credit;
    }

}