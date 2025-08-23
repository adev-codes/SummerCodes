import java.util.Scanner;

public class Calculator{
    public static void main(String[] args) {
        double a,b,c;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter first number:");
        a = input.nextDouble();
        System.out.println("Enter second number:");
        b = input.nextDouble();
        System.out.println("Enter third number:");
        c = input.nextDouble();

        //Calling overloaded Methods
        add((int)a,(int)b);
        add(a, b);
        add((int)a,(int)b,(int)c);

        input.close();
    }
    //Adds two integers
    public static void add(int a, int b){
            System.out.println("Sum for two ints is: "+(a+b));
        }
    
    public static void add(double a , double b){
        System.out.println("Sum for two doubles is: "+(a+b));
    }

    public static void add(int a , int b, int c){
        System.out.println("Sum for three ints is: "+(a+b+c));

    }
}