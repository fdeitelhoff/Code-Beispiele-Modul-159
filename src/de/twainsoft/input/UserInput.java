package de.twainsoft.input;

import java.io.Console;

public class UserInput {

    public void readFromConsole() {
        Console console = System.console();
        if (console == null) {
            System.out.println("No console: non-interactive mode!");
            System.exit(0);
        }
    }
}
