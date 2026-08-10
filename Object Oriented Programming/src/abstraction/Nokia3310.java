
package abstraction;

public class Nokia3310 implements Callable,Music,Game {
    @Override
    public void makeCall(){
        System.out.println("John is calling...");
    }
     
  
   
    
    
    @Override
    public void playMusic(){
        System.out.println("Music is playing..");
    }
    
    
   
    
    
    @Override
    public void PlayGame(){
        System.out.println("The game is playing...");
    }
}


