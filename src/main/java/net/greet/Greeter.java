package net.greet;
import java.util.Scanner;
import static net.greet.Greet.name;

public class Greeter {
    public static void main(String[] args) {


        System.out.println("Welcome to the Greetings App :\n" );
        System.out.println( "follow the instructions to greet a person : " + "\n"+" ");

        name =" enter the name of the person :";
        System.out.print( name);
        Scanner scanner = new Scanner(System. in);
        String name = scanner. nextLine();

        Greet.language =" enter language :";
        System.out.print( Greet.language);
        Scanner scanner2 = new Scanner(System. in);
        String lang = scanner2. nextLine();
        System.out.println("message: \n" + lang+ name );
    }
}