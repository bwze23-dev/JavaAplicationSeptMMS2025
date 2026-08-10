
package abstraction;
 
 
public class MainInterface {
    public static void main(String[] args){
        SmartPhone smartphone = new SmartPhone();
        
    Nokia3310 nokia = new Nokia3310();
    System.out.println("\nSmartPhone interface");
        
        smartphone.makeCall();
        smartphone.playMusic();
        smartphone.playMovie();
        smartphone.playMusic();
        smartphone.connectToWifi();
        smartphone.takePicture();
        
        System.out.println("\nNokia3310 interface");
        nokia.makeCall();
        nokia.playGame();
        nokia.playMusic();
        
                
    }
}
