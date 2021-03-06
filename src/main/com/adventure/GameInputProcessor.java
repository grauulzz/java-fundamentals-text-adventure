package main.com.adventure;

import main.com.adventure.exceptions.InvalidVerbException;
import main.com.adventure.settings.Command;
import main.com.adventure.settings.CommandVerb;

import java.util.Scanner;

public class GameInputProcessor {
    Scanner sc = new Scanner(System.in);
    /**
     * Starts the prompt process to the user.
     * @return the response from the user.
     */
    public String prompt() {
        System.out.println("Enter your next command:");
        return sc.nextLine();
    }

    /**
     * Inputs that come into this method represent single action with no object. When building the command, you'll want
     * to supply the first word as the verb and leave the objectName blank
     * @param input - the input from the user
     * @return - the Command object with the proper verb and blank object
     */
    private Command buildSimpleCommand(String input) {
        String[] split = input.split(" ");
        try {
            return new Command(CommandVerb.getVerb(split[0].trim()));
        } catch (InvalidVerbException e) {
            e.printStackTrace();
            return new Command(CommandVerb.INVALID);
        }

    }

    /**
     * Inputs that come into this method will have an object or objects that the action is acting on. You'll need to
     * include the object as part of the Command object.
     * @param input - the input from the user
     * @return - the Command object with the proper verb and object
     */
    private Command buildCommandWithObject(String input) {
        String[] split = input.split(" ");
        CommandVerb cmdVerb = CommandVerb.INVALID;
        try {
            cmdVerb = CommandVerb.getVerb(split[0]);
        } catch (InvalidVerbException e) {
            e.printStackTrace();
        }
        return new Command(cmdVerb, split[1]);
    }


    /** DO NOT CHANGE ANYTHING BELOW THIS LINE. **/

    /**
     * Gets the next command from the user.
     * @return a command object
     */
    public Command getNextCommand() {
        String input = prompt();
        return processCommand(input);
    }

    private Command processCommand(String input) {
        if (input.contains(Command.MOVE) ||
                input.contains(Command.USE) ||
                input.contains(Command.TAKE) ||
                input.contains(Command.EXAMINE)
        ) {
            return buildCommandWithObject(input);
        } else {
            return buildSimpleCommand(input);
        }
    }

}
