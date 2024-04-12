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
        //determine the input matches correct username and password
        if (username.equals(CORRECT_USERNAME) && password.equals(CORRECT_PW)){
            //exit the loop if the username and password are correct
           accessAllowed = true;
        }//end if
        return accessAllowed;
    }
    
    public static boolean displayMenu(String petName){
        if (petName.equals("")){
            //display the menu
            System.out.println("Menu:");
            System.out.println("1. Start");
            System.out.println("2. Instructions");
            System.out.println("3. Exit");
            return true;
        }
        else{
            //display the menu
            System.out.println("Menu:");
            System.out.println("1. Play/Interact");
            System.out.println("2. Instructions");
            System.out.println("3. Exit");
            return false;
        }
    }
    
    public static void checkExit(String menuChoice){
        //exit the program if the third menu option is chosen
        if (menuChoice.equals("3") || menuChoice.equals("Exit")){
            System.exit(0);
        }
    }
    
    public static String generateName(int nameLength, String vowels, String consonants, String petName){
        Random r = new Random ();
        //variables
        boolean isVowel = r.nextBoolean();
        boolean doubleLetter = r.nextBoolean();
        char v,c;
        
        //generate the pet name
        for (int i=0; i<nameLength; i=i+2){
            //generate random vowels and consonants
            v = vowels.charAt(r.nextInt(5));
            c = consonants.charAt(r.nextInt(21));
            
            //add one vowel and one consonant to the name each time
             if (isVowel){
                 petName += "" + v + c;
             }
             else{
                 petName += "" + c + v;
                 //double the vowel in the name
                 if (doubleLetter && petName.length() < 8){
                     petName += "" + v;
                 } 
             }
        }
        return petName; 
    }
    
    public static int numberGuessingGame(int money){
        Scanner kb = new Scanner (System.in);
        Random r = new Random ();
        
        //variables
        int numGuessingCorrect = r.nextInt(1, 101);
        int numGuessingPoint = 100;
        
        //output a welcome message
        System.out.println("Welcome to the number guessing game!");
 
        for (int i=0; i<10; i++){
            //read in the guess
            System.out.print("Guess a number (1-100): ");
            int numGuessing = kb.nextInt();
            
            //stop executing the loop if input is out of range
            if (numGuessing > 100 || numGuessing < 1){
                System.out.println("Invalid Input");
                continue;
            }
            
            //alter game score according to guesses
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

        //increase the money based on game score
        money += numGuessingPoint;

        //display the user's final score
        System.out.println("Your final score is " + numGuessingPoint);
        
        return money;
    }
    
    public static int matchingGame(int money){
        Random r = new Random();
        Scanner kb = new Scanner (System.in);
        //variables
        String matchingGameString = "AABBCCDDEE";
        String matchingGameShuffled = "";
        String hiddenString = "XXXXXXXXXX";
        int point = 100;
        
        //shuffle the original string
        for (int i=0; i<10; i++){
            int a = r.nextInt(matchingGameString.length());
            matchingGameShuffled += "" + matchingGameString.charAt(a);
            matchingGameString = matchingGameString.substring(a+1) + matchingGameString.substring(0, a);
        }

        while (!(hiddenString.equals(matchingGameShuffled))){
            //output the current status of the string
            System.out.println(hiddenString);
            
            //read in input of guesses
            System.out.print("Guess (index 1, index 2): ");
            int index1 = kb.nextInt();
            int index2 = kb.nextInt();
            
            //stop executing the loop if input is invalid
            if(index1 < 0 || index1 > 9 || index2 < 0 || index2 > 9){
                System.out.println("Invalid Input");
                continue;
            }
            
            //display the letters if the guess is correct
            if (matchingGameShuffled.charAt(index1) == matchingGameShuffled.charAt(index2)){
                point += 5;
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
            }
            //output a message if guess is incorrect
            else{
                point -= 2;
                System.out.println("Your guess was wrong.");
            }
        }
        
        //increase money accordingly
        money += point;
        return money;
    }
    
    //pet interaction
    public static int playWithPet(int energy, String petName){
        energy += 5;
        System.out.println("You bought a toy for " + petName + "! It's energy is increasing 10 points!!");
        return energy;
    }
    
    public static int feedPet(int food, String petName){
        food += 5;
        System.out.println("You fed " + petName + "! It's less hungry now!");
        return food;
    }
    
    public static int groomPet(int health, String petName){
        health += 5;
        System.out.println("You just groomed " + petName + "! It is healthier now!");
        return health;
    }
    
    //MAIN METHOD
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner kb = new Scanner (System.in);
        Random r = new Random ();
        
        //CONSTANTS
        final int NAME_LENGTH = r.nextInt(5)+4;
        final int MAX_HEALTH = r.nextInt(50, 100);
        final int MAX_FOOD = r.nextInt(50, 100);
        final int MAX_ENERGY = r.nextInt(50, 100);
        final String VOWELS = "aeiou";
        final String CONSONANTS = "bcdfghjklmnpqrstvwxyz";
        
        //VARIABLES
        String menuChoice, listChoice;
        String username, pw, petNameForm; 
        boolean allowAccess = false;
        String petName = "";
        int money = 50;
        int currentEnergy = 10;
        int currentHealth = 10;
        int currentFood = 10;
        String petInteraction = "";
        int petInteractionChoice;
        
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

            //determine if access to the program is allowed
            allowAccess = allowAccess(username, pw);
            
            //enter the program if access is permitted
            if (allowAccess){
                break;
            }
            else{
                //output a message to notify the user
                System.out.println("You input the wrong username or password.");
                
                //exit the program if the user failed to input the right username and password after three times
                if (i==2){
                    System.exit(0);
                }
            }
        }
        
        //loop the program infinitely
        while(allowAccess){
            //check if the user is new to the program
            boolean firstTime = displayMenu(petName);
            
            if (firstTime){
                //read in user's choice of next step
                System.out.print("Enter your choice (either a number or a word): ");
                menuChoice = kb.next();

                //check if the user wants to exit the program
                checkExit(menuChoice);
                
                switch(menuChoice){
                    case "Start", "1":
                        //display the list of animals
                        System.out.println("\nrabbit, hamster, dolphin, cat, unicorn, horse, dog\n");
                        System.out.print("Please choose an animal from the list above: ");

                        //read in user's choice of animal
                        kb.nextLine();
                        listChoice = kb.nextLine();

                        //display a message to confirm user's choice
                        System.out.println("You have chosen " + listChoice + " as your animal.");

                        //ask for a name for the chosen animal
                        System.out.println("\nIt's time to give your animal a name!");
                        System.out.print("Would you like the system to generate a name for your pet? y/n ");

                        //read in the user's choice of whether to generate a name or type in a name
                        petNameForm = kb.nextLine();

                        //determine if the generator is invoked based on user's choice
                        if (petNameForm.equals("y")){ 
                            //generate a pet name
                            petName = generateName(NAME_LENGTH,VOWELS,CONSONANTS,petName);
                        }
                        else if (petNameForm.equals("n")){
                            //ask for the pet name 
                            System.out.print("Enter the name: ");
                            petName = kb.nextLine();
                        }
                        else{
                            //exit the program if the input can't be read
                            System.out.println("Invalid Input");
                            System.exit(0);
                        }

                        //display a welcome message including the pet name
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

                //check if the user wants to exit the program
                checkExit(menuChoice);
                
                switch (menuChoice){
                    case "Play", "Interact", "1":
                        //read in user's choice of game
                        System.out.print("Select one game to play (1: number guessing game, 2: matching game, any other number to skip games): ");
                        int gameChoice = kb.nextInt();
                        
                        if (gameChoice == 1){
                            //game 1 - number guessing game
                            money = numberGuessingGame(money);
                        }
                        else if (gameChoice == 2){
                            //game 2 - matching game
                            money = matchingGame(money);
                        }
                        
                        System.out.println("Do you want to interact with your pet? (y/n) ");
                        petInteraction = kb.next();
                        if (petInteraction.equals("y")){
                            //out put pet interaction options
                            System.out.println("**PET INTERACTION**");
                            System.out.println("1: play with your pet");
                            System.out.println("2: feed your pet");
                            System.out.println("3: groom your pet");
                            
                            //read in user's choice
                            System.out.print("Enter your choice: ");
                            petInteractionChoice = kb.nextInt();
                            switch(petInteractionChoice){
                                case 1: 
                                    playWithPet(currentEnergy, petName);
                                    money -= 5;
                                    break;
                                case 2:
                                    feedPet(currentFood, petName);
                                    money -= 5;
                                    break;
                                case 3:
                                    groomPet(currentHealth, petName);
                                    money -= 5;
                                    break;
                                default:
                                    System.out.println("Invalid Input");
                                    break;
                            }
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
