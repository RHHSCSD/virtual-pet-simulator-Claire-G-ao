/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package virtualpet;
import java.util.*;
/**
 * @program pet simulator
 * @author Claire Gao
 * @version Mar. 2024
 */
public class VirtualPet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner kb = new Scanner (System.in);
        Random r = new Random ();
        
        //CONSTANTS
        final String CORRECT_USERNAME = "snoopy";
        final String CORRECT_PW = "toto";
        final int NAME_LENGTH = r.nextInt(5)+4;
        final int MAX_HEALTH = r.nextInt(100);
        final int MAX_FOOD = r.nextInt(100 - MAX_HEALTH);
        final int MAX_ENERGY = 100 - MAX_HEALTH - MAX_FOOD;
        
        //VARIABLES
        String menuChoice, listChoice;
        String username, pw, petNameForm; 
        String petName = "";
        String vowels = "aeiou";
        String consonants = "bcdfghjklmnpqrstvwxyz";
        
        //CODE
        //Part 1
        //display the welcome screen
        System.out.println("  __      _");
        System.out.println("o'')}____//");
        System.out.println(" `_/      )");
        System.out.println(" (_(_/-(_/");
        System.out.println("Doggie Heaven\n");
        
        //read in username and password
        System.out.print("Enter your username: ");
        username = kb.nextLine();
        System.out.print("Enter your password: ");
        pw = kb.nextLine();
        
        //Part 3
        //determine if the user is allowed to log in to the system
        if (!(username.equals(CORRECT_USERNAME)) && !(pw.equals(CORRECT_PW))){
            //exit the program if the username ot password is wrong
            System.exit(0);
        }//end if
            
        //display the menu
        System.out.println("Menu:");
        System.out.println("1. Start");
        System.out.println("2. Instructions");
        System.out.println("3. Exit");

        //read in user's choice of next step
        System.out.print("Enter your choice (either a number or a word): ");
        menuChoice = kb.nextLine();

        //Part 2
        switch(menuChoice){
            case "Start", "1":
                    
                //display the list of animals
                System.out.println("\nrabbit, hamster, dolphin, cat, unicorn, horse, dog\n");
                System.out.print("Please choose an animal from the list above: ");

                //read in user's choice of animal
                listChoice = kb.nextLine();

                //display a message to confirm user's choice
                System.out.println("You have chosen " + listChoice + " as your animal.");
                    
                //ask for a name for the chosen animal
                System.out.println("\nIt's time to give your animal a name!");
                System.out.print("Would you like the system to generate a name? y/n ");
                    
                //read in the user's choice of whether to generate a name or type in a name
                petNameForm = kb.nextLine();
                    
                //determine if the generator is invoked based on user's choice
                if (petNameForm.equals("y")){ //generate a pet name
                    //randomly determine the pattern used in the name
                    boolean isVowel = r.nextBoolean();
                    boolean doubleLetter = r.nextBoolean();
                    //store the name based on patterns
                    for (int i=0; i<NAME_LENGTH; i=i+2){
                        char v = vowels.charAt(r.nextInt(5));
                        char c = consonants.charAt(r.nextInt(21));
                         if (isVowel){
                             petName += "" + v + c;
                         }
                         else{
                             petName += "" + c + v;
                             if (doubleLetter && petName.length() < 8){
                                 petName += "" + v;
                             } 
                         }
                    }
                        
                }
                else if (petNameForm.equals("n")){
                    //prompt the user to type the name 
                    System.out.print("Enter the name: ");
                    petName = kb.nextLine();
                }
                else{
                    //exit the program if the input can't be read
                    System.out.println("Invalid input :(");
                    System.exit(0);
                }
                    
                //display the welcome message including the pet name
                System.out.println("Your pet, named " + petName + ", has been born!");
                    
                System.out.println(MAX_HEALTH + " " + MAX_FOOD + " " + MAX_ENERGY);
                        
                break;
                    
            case "Instructions", "2":
                break;
                    
            case "Exit", "3":
                    
                //exit the program
                System.exit(0);
                break;
                    
            default:
                System.out.println("Invalid Input");
        }//end switch
            


    }
    
}
