package net.greet;

public class Greeter {

     String name;

    public Greeter(String aName)
    {
        name = aName;
    }
    public String greetMessage()
    {
        String message = "Hello, " + name + "!";
        return message;
    }
}