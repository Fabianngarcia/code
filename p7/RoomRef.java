//package p6;
public class RoomRef implements Comparable<RoomRef>{
   private int floor;//1-25
   private int number;//1-99
   final static int MIN_FLOOR=1;
   final static int MAX_FLOOR=25;
   final static int MIN_NUMBER=1;
   final static int MAX_NUMBER=99;

   public RoomRef(){}

   public RoomRef(int floor,int number){
      this.floor=floor;
      this.number=number;
   }
   //Metodos estaticos
   public static boolean isValidFloor(int Floor){
      if(Floor >=MIN_FLOOR && Floor <=MAX_FLOOR){
         return true;
      }
      else{
         return false;
      }
   }
   public static boolean isValidNumber(int Number){
      if(Number >=MIN_NUMBER && Number<=MAX_NUMBER){
         return true;
      }
      else{
         return false;
      }
   }
   //Metodos de instancia
   public boolean equals(RoomRef anotherRoom){
      if(floor==anotherRoom.floor && number==anotherRoom.number){
         return true;
      }
      else{
         return false;
      }
   }
   public int getFloor(){
      return floor;
   }
   public int getNumber(){
      return number;
   }
   public void setFloor(int floor){
      this.floor=floor;
   }
   public void setNumber(int number){
      this.number=number;
   }
   public String toString(){
      return floor+":"+number;
   }
   public int compareTo(RoomRef rr){
      if(floor>rr.floor){
         return 1;
      }
      else if(floor < rr.floor){
         return -1;
         
      }
      else{
         if(number > rr.number){
            return 1;
         }
         else if(number < rr.number){
            return -1;
         }
         else return 0;

      }

   }

}
