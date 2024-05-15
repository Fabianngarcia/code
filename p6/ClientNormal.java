package p6;
public class ClientNormal extends Client{
    
    private int deposit;//0-1000;
    final static int MAX_DEPOSIT=1000;
    final static int MIN_DEPOSIT=0;
    

    public ClientNormal(){}

    public ClientNormal(String id,String country,int pointsCard,int deposit){
        super(id,country,pointsCard);
        this.deposit=deposit;
    }
    //Metodos
    
    //Metodos estaticos
    public static boolean isValidDeposit(int Deposit){
        if(Deposit<= MAX_DEPOSIT && Deposit>=MIN_DEPOSIT){ //0-1000
            return true;
        }
        else{
            return false;
        }
    }
    
    //Metodos de instancia
    public int getTotalPoints(){
        return pointsCard;
    }
    public int getDeposit(){
        return deposit;
    }
    public void setDeposit(int deposit){
        this.deposit=deposit;
    }
    public String toString(){
        return "N;"+super.toString()+";"+deposit;
    }

}




        
    
