package de.twainsoft;

import de.twainsoft.input.UserInput;
import de.twainsoft.storage.InputStorage;

public class Main {

    private static InputStorage inputStorage;

    public static void main(String[] args) {
        UserInput userInput = new UserInput();
        inputStorage = new InputStorage();
        String input;

        do {
            input = userInput.readFromConsole();
            String[] parts = input.split(" ");

            if (parts[0].equalsIgnoreCase("help")) {
                System.out.println("Available commands: \n");
                System.out.println("1. add <element> - Add the element to the list.");
                System.out.println("2. remove <element> - Remove the element from the list.");
                System.out.println("3. find <element> - Checks, if the given element already exists in the list.");
                System.out.println("4. list - Displays the complete list.");
                System.out.println("5. help - Displays this help.");

            } else if (!parts[0].equalsIgnoreCase("list") && parts.length != 2) {
                System.out.println("The add, remove, and find commands need two parameters!");
            } else if (parts[0].equalsIgnoreCase("add")) {
                addElement(parts[1]);
            } else if (parts[0].equalsIgnoreCase("remove")) {
                removeElement(parts[1]);
            } else if (parts[0].equalsIgnoreCase("find")) {
                findElement(parts[1]);
            } else if (parts[0].equalsIgnoreCase("list")) {
                listElements();
            }

        } while (!input.equalsIgnoreCase("exit"));
    }

    private static void addElement(String element) {
        if (!inputStorage.containsItem(element)) {
            inputStorage.addItem(element);
            System.out.println(String.format("The element '%s' was added to the list. Current list size is %d.",
                    element,
                    inputStorage.getStorageSize()));
        } else {
            System.out.println(String.format("The element '%s' is already present in the list and was not added.",
                    element));
        }
    }

    private static void removeElement(String element) {
        if (inputStorage.containsItem(element)) {
            inputStorage.removeItem(element);
            System.out.println(String.format("The element '%s' was removed from the list. Current list size is %d.",
                    element,
                    inputStorage.getStorageSize()));
        } else {
            System.out.println(String.format("The element '%s' is not present in the list and was not removed.",
                    element));
        }
    }

    private static void findElement(String element) {
        if (inputStorage.containsItem(element)) {
            System.out.println(String.format("The element '%s' is present in the list.", element));
        } else {
            System.out.println(String.format("The element '%s' is not present in the list.", element));
        }
    }

    private static void listElements() {
        String[] items = inputStorage.getAllItems();

        System.out.println(String.format("There are %d elements in the list:\n", inputStorage.getStorageSize()));

        int index = 1;
        for (String item: items) {
            System.out.println(String.format("%d. %s", index++, item));
        }
    }
}
