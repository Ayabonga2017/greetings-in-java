package net.greet;

import java.sql.SQLException;
import java.util.Map;
import java.util.Set;

public class CommandExecutor {

    Greet greeter;

    public CommandExecutor (Greet greet) {
        this.greeter = greet;
    }

    public String execute (CommandExtractor extractor) throws SQLException {

        if ("greet".equalsIgnoreCase(extractor.getCommand())) {

            greeter.names(extractor.getUser());
            return extractor.getGreet();

        } else if ("clear".equalsIgnoreCase(extractor.getCommand())) {

            return ( "\n" + extractor.getUser() + " was removed successfully!" );

        } else if ("clearall".equalsIgnoreCase(extractor.getCommand())) {

            return greeter.clearNames();

        } else if ("greeted".equalsIgnoreCase(extractor.getCommand())) {

            StringBuilder greeted = new StringBuilder("These users have been greeted: \n");

            Map < String,Integer > usersGreetedMap = greeter.namesGreeted();
            Set < String > userNamesGreeted = usersGreetedMap.keySet();

            for ( String username : userNamesGreeted ) {
                // use your builder.append in here
                greeted.append("\t");
                greeted.append(username);
                greeted.append(" ");
                greeted.append("has been greeted ");
                greeted.append(usersGreetedMap.get(username));
                greeted.append(" time(s)");
                greeted.append("\n");

            }

            return greeted.toString();

        } else if ("count".equalsIgnoreCase(extractor.getCommand())) {
                if (extractor.getUser().isEmpty()){
                    return "enter user name";
                }else {
                    return "\n" + extractor.getUser() + " was greeted " + greeter.countName(extractor.getUser()) + " time(s)";
                }
        } else if ("counter".equalsIgnoreCase(extractor.getCommand())) {

            return String.valueOf(greeter.count());

        } else if ("help".equalsIgnoreCase(extractor.getCommand())) {

            StringBuilder help = new StringBuilder();

            help.append("\nValid Commands are as follow :\n" + "\n- greet + name + language : will greet a person with a language of your choice.");
            help.append("- greet + name : will greet a person with the default language.\n" + "- greeted : will display a list of greeted names. ");
            help.append("- count + name : will display how many times a person has been greeted.\n" + "- counter : will display the number of greeted names. ");
            help.append("- clear + name : will remove a persons name from the list and decrement the counter.\n" + "- clearall : will delete all the names on the list set the counter to 0.");
            help.append("- exit : will exit the greeting application.\n" + "- help : will display all the possible commands to use when using this application.");
            return String.valueOf(help);

        } else if ("exit".equalsIgnoreCase(extractor.getCommand())) {

            return "exit";

        } else {

            return "\nInvalid command." + "\ntype 'help' to get the list of valid commands.";
        }
    }
}

