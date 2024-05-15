package p9;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

public class ClientComparatorByDate implements Comparator<Room>{
    public int compare(Room m1,Room m2){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yy");
        LocalDate parsedDateIn1 = LocalDate.parse(m1.getEntryDate(), formatter);
        LocalDate parsedDateIn2 = LocalDate.parse(m2.getEntryDate(), formatter);
        if(parsedDateIn1.compareTo(parsedDateIn2)>0){
            return 1;
        }
        else if(parsedDateIn1.compareTo(parsedDateIn2)<0){
            return -1;
        }
        else{
            
            return -1*(m1.getRoomRef().compareTo(m2.getRoomRef()));
        }
    }
}
