package p4;
public class Room{
    private RoomRef roomRef;
    private String idClient=null;//tamaño 11 y si está vacío null
    
    public Room(){}
    public Room(RoomRef roomRef,String idClient){
        this.roomRef=roomRef;
        this.idClient=idClient;
    }
    //Metodos de instancia
    public RoomRef getRoomRef(){
        return roomRef;
    }
    public String getIdClient(){
        return idClient;
    }
    public void setRoomRef(RoomRef roomRef){
        this.roomRef=roomRef;
    }
    public void setIdClient(String idClient){
        this.idClient=idClient;
    }
    public String toString(){
        if(idClient!=null){
            return roomRef.toString()+";"+idClient;
        }
        else{
            return roomRef.toString();
        }
    }
}