//package p6;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
public class Hotel{
    private int maxFloor;//1-25
    private int floorSize;
    private int lowerVipFloor;
    HashSet<Room> busyRooms;
    TreeSet<Room> freeRooms;

    public Hotel(){}
    /*public Hotel(int maxFloor,int floorSize,int lowerVipFloor,Room[][] habitaciones){
        this.maxFloor=maxFloor;
        this.floorSize=floorSize;
        this.lowerVipFloor=lowerVipFloor;
        for(int i=0;i<maxFloor;i++){
            if(i+1<lowerVipFloor){
                for(int j=0;j<floorSize;j++){//Normales
                    rooms[i][j]=habitaciones[i][j];
                }   
            }
            else{
                for(int j=0;j<floorSize;j++){//Premium y VIP
                    rooms[i][j]=new RoomPTV(habitaciones[i][j].getRoomRef(),habitaciones[i][j].getIdClient());
                }
            }
        }
    }*/
    public Hotel(String filename){
        try{
        busyRooms=new HashSet<Room>();
        freeRooms=new TreeSet<Room>();
        File fichero=new File(filename);
        Scanner scan=new Scanner(fichero);
        int i=0;
        
        while(scan.hasNext()){
            
            String cadena=scan.nextLine();
            if(cadena.charAt(0)!='#'){
                String[] c=cadena.split(";");
                if(i==0){
                    i++;
                    maxFloor=Integer.parseInt(c[0]);
                    floorSize=Integer.parseInt(c[1]);
                    lowerVipFloor=Integer.parseInt(c[2]);
                    
                    for(int j=1;j<maxFloor+1;j++){
                        for(int k=1;k<floorSize+1;k++){
                            if(j<lowerVipFloor){
                                freeRooms.add(new Room(new RoomRef(j, k),null));
                            }
                            else{
                                freeRooms.add(new RoomPTV(new RoomRef(j, k),null)); 
                            }
                        }
                    }
                    continue;

                }
                String[] dimension=c[0].split(":");
                int d1=Integer.parseInt(dimension[0]);
                int d2=Integer.parseInt(dimension[1]);
                RoomRef ref=new RoomRef(d1,d2);
                
                if(freeRooms.ceiling(new Room(ref,null)).equals(freeRooms.floor(new Room(ref,null)))){
                    Room x=freeRooms.ceiling(new Room(ref,null));
                    busyRooms.add(x);
                    x.setIdClient(c[1]);
                    x.setEntryDate(c[2]);
                    freeRooms.remove(x);
                    
                }
            }
        }
    }catch(FileNotFoundException e){}
    }
    public void checkIn(Client client,String date){
        
        if(client instanceof ClientNormal){//Normales
           
            Room x;
            RoomRef ref=new RoomRef(lowerVipFloor-1,floorSize);
            
            x=freeRooms.floor(new Room(ref,null));
            busyRooms.add(x);
            x.setIdClient(client.getId());
            x.setEntryDate(date);
            freeRooms.remove(x);
                           
        }    
            
        
        else if(client instanceof ClientVIP && !(client instanceof ClientPremium)){//Vip
            Room x;
            RoomRef ref=new RoomRef(maxFloor -1,floorSize);
            x=freeRooms.floor(new Room(ref,null));
            busyRooms.add(x);
            x.setIdClient(client.getId());
            x.setEntryDate(date);
            if(x.getRoomRef().getFloor()>lowerVipFloor){
                ((RoomPTV)x).getPTVService().activate();
            }
            freeRooms.remove(x);               
            }
        else{//Premium
            Room x;
            RoomRef ref=new RoomRef(maxFloor,floorSize);
            x=freeRooms.floor(new Room(ref,null));
            busyRooms.add(x);
            x.setIdClient(client.getId());
            x.setEntryDate(date);
            if(x.getRoomRef().getFloor()>lowerVipFloor){
                ((RoomPTV)x).getPTVService().activate();
            }
            freeRooms.remove(x); 
        }
    }
    public String checkOut(String idCliente){
        
        for(Room x:busyRooms){
            if(x.getIdClient().equals(idCliente)){
                String aux=x.getEntryDate();
                if(x.getRoomRef().getFloor() > lowerVipFloor){
                    ((RoomPTV)x).getPTVService().deactivate();
                }
                x.setIdClient(null);
                freeRooms.add(x);
                busyRooms.remove(x);
                return aux;
            }
        }
        return null;
    }
                
    public void saveHotelToFile(String filename){
        File fichero2=new File(filename);
        try{
            PrintWriter pw=new PrintWriter(fichero2);
            pw.println(maxFloor+";"+floorSize+";"+lowerVipFloor);
            TreeSet<Room> newSet=new TreeSet<Room>(busyRooms);
            while(!newSet.isEmpty()){
                pw.println(newSet.pollLast().toString());
            }
            pw.close();

        }catch(FileNotFoundException e){}

    }
    public int getMaxFloor(){
        return maxFloor;
    }
    public int getFloorSize(){
        return floorSize;
    }
    public int getLowerVipFloor(){
        return lowerVipFloor;
    }
    
    public void setMaxFloor(int maxFloor){
        this.maxFloor=maxFloor;
    }
    public void setFloorSize(int floorSize){
        this.floorSize=floorSize;
    }
    public void setLowerVipFloor(int lowerVipFloor){
        this.lowerVipFloor=lowerVipFloor;
    }
    

}
