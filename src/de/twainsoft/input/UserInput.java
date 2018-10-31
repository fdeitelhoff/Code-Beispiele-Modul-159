package de.twainsoft.input;

import java.util.Scanner;

public class UserInput {

    private Scanner scanner;

    public UserInput() {
        this.scanner = new Scanner(System.in);
    }

    public String readFromConsole() {
        return this.scanner.nextLine();
    }
}
