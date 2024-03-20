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
        
        //CONSTANTS
        
        //VARIABLES
        String menuChoice, listChoice;
        
        //CODE
        //Part 1
        //display the welcome screen
        System.out.println("  __      _");
        System.out.println("o'')}____//");
        System.out.println(" `_/      )");
        System.out.println(" (_(_/-(_/");
        System.out.println("Doggie Heaven\n");
        
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
                System.out.println("\nrabbit, hamster, dolphin, cat, unicorn, horse, dog");
                System.out.print("Please choose an animal from the list above: ");
                
                //read in user's choice of animal
                listChoice = kb.nextLine();
                
                //display a message to confirm user's choice
                System.out.println("You have chosen " + listChoice + " as your animal.");
                
                break;
            case "Instructions", "2":
                break;
            case "Exit", "3":
                //exit the program
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Input");
        }

    }
    
}
