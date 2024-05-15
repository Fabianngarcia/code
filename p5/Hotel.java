package p5;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
public class Hotel{
    private int maxFloor;//1-25
    private int floorSize;
    private int lowerVipFloor;
    private Room[][] rooms;

    public Hotel(){}
    public Hotel(int maxFloor,int floorSize,int lowerVipFloor,Room[][] habitaciones){
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
    }
    public Hotel(String filename){
        try{
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
                    rooms=new Room[maxFloor][floorSize];
                    for(int j=1;j<maxFloor+1;j++){
                        for(int k=1;k<floorSize+1;k++){
                            if(j<lowerVipFloor){
                                rooms[j-1][k-1]=new Room(new RoomRef(j, k),null);
                            }
                            else{
                                rooms[j-1][k-1]=new RoomPTV(new RoomRef(j, k),null); 
                            }
                        }
                    }
                    continue;

                }
                String[] dimension=c[0].split(":");
                int d1=Integer.parseInt(dimension[0]);
                int d2=Integer.parseInt(dimension[1]);
                RoomRef ref=new RoomRef(d1,d2);
                for(int j=1;j<maxFloor+1;j++){
                    for(int k=1;k<floorSize+1;k++){
                        if(rooms[j-1][k-1].getRoomRef().equals(ref)){
                            rooms[j-1][k-1].setIdClient(c[1]);
                            
                        }
                    }
                }
                



            }
        }
    }catch(FileNotFoundException e){}
    }
    public void checkIn(Client client){
        
        if(client instanceof ClientNormal){//Normales
            int n=0;
            for(int j=lowerVipFloor-1;j>0 && n==0;j--){
                for(int k=floorSize;k>0 && n==0;k--){
                    if(rooms[j-1][k-1].getIdClient()==null){
                        rooms[j-1][k-1].setIdClient(client.getId());
                        
                        n++;
                        
                    }
                }
                
            }

        }
        else if(client instanceof ClientVIP && !(client instanceof ClientPremium)){//Vip
            int v=0;
            for(int j=maxFloor-1;j>lowerVipFloor-1 && v==0;j--){
                for(int k=floorSize;k>0 && v==0;k--){
                    if(rooms[j-1][k-1].getIdClient()==null){
                        rooms[j-1][k-1].setIdClient(client.getId());
                        ((RoomPTV)rooms[j-1][k-1]).getPTVService().activate();
                        
                        v++;
                        
                    }
                }
                
            }
            
            for(int j=lowerVipFloor-1;j>0 && v==0;j--){
                for(int k=floorSize;k>0 && v==0;k--){
                    if(rooms[j-1][k-1].getIdClient()==null){
                        rooms[j-1][k-1].setIdClient(client.getId());
                      
                        v++;
                        
                    }
                }
                
            }
        }
        else{//Premium
            int p=0;
            for(int k=floorSize;k>0 && p==0;k--){
                if(rooms[maxFloor-1][k-1].getIdClient()==null){
                    p++;
                    rooms[maxFloor-1][k-1].setIdClient(client.getId());
                    ((RoomPTV)rooms[maxFloor-1][k-1]).getPTVService().activate();
                
                }
            }
            
            
            for(int j=maxFloor-1;j>lowerVipFloor-1 && p==0;j--){
                for(int k=floorSize;k>0 && p==0;k--){
                    if(rooms[j-1][k-1].getIdClient()==null){
                        rooms[j-1][k-1].setIdClient(client.getId());
                        ((RoomPTV)rooms[j-1][k-1]).getPTVService().activate();
                    
                        p++;
                        
                    }
                }
                
            }
            
            for(int j=lowerVipFloor-1;j>0 && p==0;j--){
                for(int k=floorSize;k>0 && p==0;k--){
                    if(rooms[j-1][k-1].getIdClient()==null){
                        rooms[j-1][k-1].setIdClient(client.getId());
                    
                        p++;
                        
                    }
                }
                
            }
        }

    }
        
    
    public void checkOut(String idCliente){
        
        for(int j=maxFloor;j>0;j--){
            for(int k=floorSize;k>0;k--){
                if(rooms[j-1][k-1].getIdClient()!=null){
                    if(rooms[j-1][k-1].getIdClient().equals(idCliente)){
                    rooms[j-1][k-1].setIdClient(null);
                        if(j>=lowerVipFloor){
                            ((RoomPTV)rooms[j-1][k-1]).getPTVService().deactivate();
                        }
                    }

                }
            }
        }
       
    }
    public void saveHotelToFile(String filename){
        File fichero2=new File(filename);
        try{
            PrintWriter pw=new PrintWriter(fichero2);
            pw.println(maxFloor+";"+floorSize+";"+lowerVipFloor);
            for(int j=maxFloor;j>0;j--){
                for(int k=floorSize;k>0;k--){
                    if(rooms[j-1][k-1].getIdClient()!=null){
                        pw.println(rooms[j-1][k-1].toString());
                    }
                }
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
