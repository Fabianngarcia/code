package p9;
import java.util.Comparator;

public class ClientComparatorByPointsAndId implements Comparator<Client>{    
    public int compare(Client c1,Client c2){
        if(c1.getPoints() > c2.getPoints()){
            return -1;
        }
        else if(c1.getPoints() < c2.getPoints()){
            return 1;
        }
        else{
            if(c1.getId().compareTo(c2.getId()) == 1){
                return -1;
            }
            else if(c1.getId().compareTo(c2.getId()) == -1){
                return 1;
            }
            else{
                return 0;
            }
        }
    }
}
