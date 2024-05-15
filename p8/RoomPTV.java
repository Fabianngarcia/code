//package p6;
public class RoomPTV extends Room{
    private PTVService ptvService=new PTVService(); 
    public RoomPTV(){}
    public RoomPTV(RoomRef roomRef,String idClient){
     super(roomRef,idClient);  
    }
    public PTVService getPTVService(){
        return ptvService;
    }
}
