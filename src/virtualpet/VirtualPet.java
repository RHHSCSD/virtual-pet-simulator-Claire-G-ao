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
    public static void displayWelcomeScreen(){
        //display the welcome screen
        System.out.println("  __      _");
        System.out.println("o'')}____//");
        System.out.println(" `_/      )");
        System.out.println(" (_(_/-(_/");
        System.out.println("Doggie Heaven\n");
    }
    
    public static boolean allowAccess(String username, String password){
        final String CORRECT_USERNAME = "snoopy";
        final String CORRECT_PW = "toto";
        boolean accessAllowed = false;
        //determine if the user is allowed to log in to the system
        if (username.equals(CORRECT_USERNAME) && password.equals(CORRECT_PW)){
            //exit the loop if the username and password are correct
           accessAllowed = true;
        }//end if
        return accessAllowed;
    }
    
    public static int displayMainMenu(String petName){
        if (petName.equals("")){
            //display the menu
            System.out.println("Menu:");
            System.out.println("1. Start");
            System.out.println("2. Instructions");
            System.out.println("3. Exit");
            return 1;
        }
        else{
            //display the menu
            System.out.println("Menu:");
            System.out.println("1. Play/Interact");
            System.out.println("2. Instructions");
            System.out.println("3. Exit");
            return 2;
        }
    }
    
    public static void checkExit(String menuChoice){
        if (menuChoice.equals("3") || menuChoice.equals("Exit")){
                    System.exit(0);
                }
    }
    
    public static void displayAnimals(){
        //display the list of animals
        System.out.println("\nrabbit, hamster, dolphin, cat, unicorn, horse, dog\n");
        System.out.print("Please choose an animal from the list above: ");
    }
    
    public static int numberGuessingGame(int money){
        Scanner kb = new Scanner (System.in);
        Random r = new Random ();
        
        int numGuessingCorrect;
        int numGuessingPoint;
        
        System.out.println("Welcome to the number guessing game!");
        numGuessingCorrect = r.nextInt(1, 101);
        numGuessingPoint = 100;
        for (int i=0; i<10; i++){
            System.out.print("Guess a number: ");
            int numGuessing = kb.nextInt();
            if (numGuessing < numGuessingCorrect){
                System.out.println("Too low");
                numGuessingPoint -= 5;
            }
            else if (numGuessing > numGuessingCorrect){
                System.out.println("Too high");
                numGuessingPoint -= 5;
            }
            else{
                numGuessingPoint += 2;
                System.out.println("Correct!");
                break;
            }
        }

        money += numGuessingPoint;

        //display the user's final score
        System.out.println("Your final score is " + numGuessingPoint);
        
        return money;
    }
            
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner kb = new Scanner (System.in);
        Random r = new Random ();
        
        //CONSTANTS
        final int NAME_LENGTH = r.nextInt(5)+4;
        final int MAX_HEALTH = r.nextInt(100);
        final int MAX_FOOD = r.nextInt(100 - MAX_HEALTH);
        final int MAX_ENERGY = 100 - MAX_HEALTH - MAX_FOOD;
        final String VOWELS = "aeiou";
        final String CONSONANTS = "bcdfghjklmnpqrstvwxyz";
        final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
        
        //VARIABLES
        String menuChoice, listChoice;
        String username, pw, petNameForm; 
        boolean allowAccess = false;
        String petName = "";
        boolean isVowel, doubleLetter;
        char v,c;
        int numGuessingCorrect, numGuessing, numGuessingPoint;
        String matchingGameString = "AABBCCDDEE";
        String matchingGameShuffled = "";
        int money = 50;
        
        //CODE
        //Part 1
        //display the welcome screen
        displayWelcomeScreen();
        
        
        for (int i=0; i<3; i++){
            //read in username and password
            System.out.print("Enter your username: ");
            username = kb.nextLine();
            System.out.print("Enter your password: ");
            pw = kb.nextLine();

            allowAccess = allowAccess(username, pw);
            
            if (allowAccess){
                break;
            }
            else{
                //output a message to notify the user
                System.out.println("You input the wrong username or password.");
                
                //exit the program if the user failed to input the right username and password three times
                if (i==2){
                    System.exit(0);
                }
            }
        }
            

        
        while(allowAccess){
            int check = displayMainMenu(petName);
            
            if (check==1){
                //read in user's choice of next step
                System.out.print("Enter your choice (either a number or a word): ");
                menuChoice = kb.next();

                checkExit(menuChoice);
                
            //Part 2
                switch(menuChoice){
                    case "Start", "1":

                        displayAnimals();

                        //read in user's choice of animal
                        kb.nextLine();
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
                            isVowel = r.nextBoolean();
                            doubleLetter = r.nextBoolean();
                            //store the name based on patterns
                            for (int i=0; i<NAME_LENGTH; i=i+2){
                                v = VOWELS.charAt(r.nextInt(5));
                                c = CONSONANTS.charAt(r.nextInt(21));
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

                        break;

                    case "Instructions", "2":
                        break;
                        
                    default:
                        System.out.println("Invalid Input");
                        break;
                }//end switch
            }//end if
            else{
                //read in user's choice of next step
                System.out.print("Enter your choice (either a number or a word): ");
                menuChoice = kb.next();

                checkExit(menuChoice);
                
                switch (menuChoice){
                    case "Play", "Interact", "1":
                        numberGuessingGame(money);

                        //game 2 - matching game
                        for (int i=0; i<10; i++){
                            int a = r.nextInt(matchingGameString.length());
                            matchingGameShuffled += "" + matchingGameString.charAt(a);
                            matchingGameString = matchingGameString.substring(a+1) + matchingGameString.substring(0, a);
                        }
                        
                        //display the hidden string
                        String hiddenString = "XXXXXXXXXX";
                        System.out.println("XXXXXXXXXX");
                        int trials = 10;
                        while (!(hiddenString.equals(matchingGameShuffled)) && trials >= 0){
                            System.out.print("Guess: ");
                            int index1 = kb.nextInt();
                            int index2 = kb.nextInt();
                            if (matchingGameShuffled.charAt(index1) == matchingGameShuffled.charAt(index2)){
                                if (index1 < index2){
                                    hiddenString = hiddenString.substring(0, index1) 
                                            + matchingGameShuffled.charAt(index1) 
                                            + hiddenString.substring(index1+1, index2) 
                                            + matchingGameShuffled.charAt(index2) 
                                            + hiddenString.substring(index2+1);
                                }
                                else{
                                    hiddenString = hiddenString.substring(0, index1) 
                                            + matchingGameShuffled.charAt(index1) 
                                            + hiddenString.substring(index1+1, index2) 
                                            + matchingGameShuffled.charAt(index2) 
                                            + hiddenString.substring(index2+1);
                                }
                                System.out.println(hiddenString);
                            }
                            else{
                                System.out.println("Your guess was wrong.");
                            }
                            trials--;
                        }
                      
                        break;
                    case "Instructions", "2":
                        break;
                    default:
                        System.out.println("Invalid Input");
                        break;
                }//end switch
            }//end else
        }//end while
        


    }
    
}
