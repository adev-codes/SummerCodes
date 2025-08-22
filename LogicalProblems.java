import java.util.Scanner;
/**
 * LogicalProblems.java
 * A simple Java console program with a menu-driven interface
 * to solve logical problems: Prime Check, Factorial, Fibonacci, Armstrong.
 * 
 * Author: Ayesha
 * Date: August 2025
 */
public class LogicalProblems {
    // Single Scanner instance for the whole program
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        
        int choice;
        // Do-While loop so that menu runs at least once until user chooses Exit
        do{
        
        //Display Menu
        System.out.println("=======================================");
        System.out.println("   WELCOME TO LOGICAL PROBLEM SOLVER");
        System.out.println("=======================================");
        System.out.println("Choose an option below:");
        System.out.println("1. Prime Number Check");
        System.out.println("2. Factorial Finder");
        System.out.println("3. Fibonacci Series Generator");
        System.out.println("4. Armstrong Number Check");
        System.out.println("5. Exit");
        System.out.println("=======================================");

        //Taking user input
        System.out.println("Enter your choice:");
        choice = input.nextInt();

        //Handling user's choice
        switch (choice) {
            case 1:
                isPrime();break;
            case 2:
                factorial();break;
            case 3:
                fibonacci();break;
            case 4:
                isArmstrong();break;
            case 5: 
                System.out.println("Exiting... Goodbye!"); break;
            default:
                System.out.println("Invalid Choice.");break;
        }
        System.out.println();

    }while (choice != 5);
        
    }
    //Method to check Prime Numbers
    public static void isPrime(){
        System.out.println("===== Prime Number Check =====");
        System.out.println("Enter a number:");
        int n = input.nextInt();
        if(n <= 1){
            System.out.println("Prime numbers start from 2. So " + n + " is not prime.");
            return;
        }
        else{
            for(int i = 2;i<=Math.sqrt(n);i++){
                if(n%i == 0){
                    System.out.println(n+" is not prime.");return;
                }
            }
        }
        System.out.println(n+" is prime.");
    }

    //Method to find factorial
    public static void factorial(){
        System.out.println("\n===== Factorial Finder =====");
        System.out.println("Enter a number:");
        int n = input.nextInt();
        
        
        long factorial = 1;
        if(n == 0 || n == 1){
         factorial = 1;
        }
        else if(n < 0){
            System.out.println("Factorial of Negative Numbers doesn\'t exist");
            return;
        }
        else{
        for(int i=n;i>=1;i--){
          factorial *= i;
        }
    }
    System.out.println("The factorial of "+n+" is "+factorial);
    }
    
    //Method to calculate Fibonnaci Series
    public static void fibonacci() {
        System.out.println("\n===== Fibonacci Series =====");
        System.out.println("Enter the numbers of terms you want in your fibonnaci series:");
        int n = input.nextInt();

        StringBuilder series = new StringBuilder();
        int firstNum = 0;
        int secondNum = 1;
        System.out.println("Fibonaci series(first "+n+" terms): ");
        for(int i=0;i<n;i++){
            series.append(firstNum);
            if (i < n - 1) {              // check if it's not the last number
            series.append(", ");   // print comma after number
        }
        int nextNum = firstNum+secondNum;
        firstNum = secondNum;
        secondNum = nextNum;  
     }
        System.out.println(series.toString());
    }

    //Method to Count Digits of a Number
    public static int countDigits(int n){
        int count = 0;
        while(n != 0){
            n = n / 10;
            count++;
        }
        return count;
    }

    //Method to find out whether a number is Armstrong or not
    public static void isArmstrong(){
        System.out.println("\n===== Armstrong Number Check =====");
        System.out.println("Enter a number:");
        int n = input.nextInt();
        int numOfDigits = countDigits(n);
        int original = n;
        int sum = 0;
        int digit;
        while(n>0){
        digit = n % 10;
        n = n/10;
        sum+= Math.pow(digit, numOfDigits);
        }
        if(original == sum){
            System.out.println(original+" is an Armstrong number.");
        }
        else{
            System.out.println(original+" is NOT an Armstrong number.");
        }
    }
}