package SummerCodes;
import java.util.Scanner;

public class NumberGuessing{
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int guess;
        String userInput,response;
        do{System.out.println("======Number Guessing Game======");
        System.out.println("Enter \'q\' at any point to quit the game...");
        System.out.println("Enter your guess(between 1 and 100):");
        int numOfAttempts = 0;
        int num = (int)(Math.random()*100)+1;
        while(true){
        System.out.println("-------------------------------");
        System.out.println("Think well and enter the number: ");
        userInput = input.next();
        numOfAttempts++;
        if(userInput.equals("q")){
            System.out.println("Game Exited");
            return;
        }
        guess = Integer.parseInt(userInput);
        if(guess == num){
            System.out.println("Congratulations! You guessed the number right in "+numOfAttempts+" attempts");break;
        }
        else if (Math.abs(guess - num) <= 10 && guess != num){
               System.out.println("You are close!");
        }
        else if(guess < num){
            System.out.println("low");
        }
        else{
            System.out.println("High");
        }
    }
        System.out.println("Do you want to play again?[y/n]");
        response = input.next();
        if(response.equals("y")){
            continue;
        }
    }while(!response.equals("n"));
     input.close();
     System.out.println("Program Terminated Successfully");
        
    }
    
}
