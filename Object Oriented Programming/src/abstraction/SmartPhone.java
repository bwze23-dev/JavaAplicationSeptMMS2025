
package abstraction;

public class SmartPhone implements Callable,Camera,Movie,Music,Wifi,Game{
    
    @Override
    public void makeCall(){
        System.out.println("John is calling...");
    }
     
    @Override
    public void takePicture(){
        System.out.println("Picture has been taken");
    }
    
    
    @Override
    public void playMovie(){
        System.out.println("Movie is playing");
    }
    
    
    @Override
    public void playMusic(){
        System.out.println("Music is playing..");
    }
    
    
    @Override
    public void connectToWifi(){
        System.out.println("Connect to wifi...");
    }
    
    
    @Override
    public void PlayGame(){
        System.out.println("The game is playing...");
    }
}
