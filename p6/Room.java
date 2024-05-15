package p6;
public class Room{
    private RoomRef roomRef;
    private String entryDate;
    private String idClient=null;//tamaño 11 y si está vacío null
    
    public Room(){
        entryDate=null;
    }
    public Room(RoomRef roomRef,String idClient){
        this.roomRef=roomRef;
        this.idClient=idClient;
        entryDate=null;
    }
    //Metodos de instancia
    public RoomRef getRoomRef(){
        return roomRef;
    }
    public String getIdClient(){
        return idClient;
    }
    public String getEntryDate(){
        return entryDate;
    }
    public void setRoomRef(RoomRef roomRef){
        this.roomRef=roomRef;
    }
    public void setIdClient(String idClient){
        this.idClient=idClient;
    }
    public void setEntryDate(String entryDate){
        this.entryDate=entryDate;
    }
    public String toString(){
        if(idClient!=null){
            return roomRef.toString()+";"+idClient+';'+entryDate;
        }
        else{
            return roomRef.toString();
        }
    }
}
