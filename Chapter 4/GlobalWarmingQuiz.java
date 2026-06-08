import java.util.Scanner;

public class GlobalWarmingQuiz {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int score = 0;

        System.out.println("Welcome to the Global Warming Quiz!\n");

      
        System.out.println("1. Which gas is most widely attributed to human-caused greenhouse effects?");
        System.out.println("1) Oxygen\n2) Carbon Dioxide (CO2)\n3) Nitrogen\n4) Helium");
        System.out.print("Your answer: ");
        if (input.nextInt() == 2) score++;

        
        System.out.println("\n2. According to climate skeptics, what natural factor plays a major role in global temperature shifts?");
        System.out.println("1) Solar activity & orbital cycles\n2) Deep sea creature migrations\n3) Earthquakes\n4) Volcanic ash patterns alone");
        System.out.print("Your answer: ");
        if (input.nextInt() == 1) score++;

     
        System.out.println("\n3. What is the core goal of the Paris Climate Agreement?");
        System.out.println("1) Stopping all industrial manufacturing\n2) Limiting global warming to well below 2 degrees Celsius\n3) Creating artificial glaciers\n4) Colonizing Mars");
        System.out.print("Your answer: ");
        if (input.nextInt() == 2) score++;

      
        System.out.println("\n4. Skeptics often point to historical data showing climate variations during which period?");
        System.out.println("1) The Industrial Age\n2) The Jurassic Period\n3) The Medieval Warm Period\n4) The Modern Era");
        System.out.print("Your answer: ");
        if (input.nextInt() == 3) score++;

       
        System.out.println("\n5. What consensus range does the IPCC claim regarding human responsibility for modern warming trends?");
        System.out.println("1) Extremely likely due to human activity\n2) Entirely unverified\n3) Decreasing steadily\n4) Purely accidental");
        System.out.print("Your answer: ");
        if (input.nextInt() == 1) score++;

    
        System.out.println("\n--- Results ---");
        if (score == 5) {
            System.out.println("Excellent!");
        } else if (score == 4) {
            System.out.println("Very good!");
        } else {
            System.out.println("Time to brush up on your knowledge of global warming.");
            System.out.println("Check out these balanced resources to learn more:");
            System.out.println("- NASA Global Climate Change: climate.nasa.gov");
            System.out.println("- IPCC Reports: www.ipcc.ch");
            System.out.println("- Climate Skeptic perspectives: www.climate-skeptic.com");
        }
    }
}