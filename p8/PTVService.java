//package p6;
public class PTVService{
    private boolean activated;

    public PTVService(){
        activated=false;
    }
    public void activate(){
        activated=true;
    }
    public void deactivate(){
        activated=false;
    }
}