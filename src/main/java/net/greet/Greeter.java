package net.greet;
import java.util.Scanner;

public class Greeter {
    public static void main(String args[]){

        System.out.println("--------Welcome to the Greetings App--------\n ");
        Scanner in = new Scanner(System.in);
        System.out.print("Enter name : ");
        String name = in.next();
        Greet.nameS(name);

        //String language = in.next();
        System.out.println(  name);

    }
}