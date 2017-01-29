package com.cristina;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Contacts contacts = new Contacts();
        boolean end = false;

        try {
            File file = new File(Constants.FILE_PATH);

            if (file.createNewFile()){
                System.out.println("Creating " + Constants.FILE_NAME + " in " + Constants.CURRENT_DIRECTORY);
            }else{
                contacts.loadContacts();
                System.out.println("Loaded data from " + Constants.FILE_NAME);
            }
        } catch (Exception e) {
            System.out.println("Error creating new file");
            System.out.println(e);
        }

        System.out.println("Welcome to Contacts!");
        do {
            System.out.print("(" + contacts.size() + ") > ");
            String text = keyboard.nextLine();
            OptionMenu option = OptionsParse.parse(text);
            switch (option) {
                case ADD:
                    contacts.addContact();
                    break;

                case DELETE:
                    contacts.deleteContact();
                    break;

                case LIST:
                    contacts.loadContacts();
                    contacts.printContacts();
                    break;

                case HELP:
                    displayHelp();
                    break;

                case QUIT:
                    end = true;
                    System.out.println("Bye!");
            }
        } while (!end);
    }

    private static void displayHelp() {
        System.out.println("·········································");
        System.out.println("·\tA - Add a new contact               ·");
        System.out.println("·\tD - Delete a contact by position    ·");
        System.out.println("·\tL - Load a phonebook                ·");
        System.out.println("·\tH - Display help                    ·");
        System.out.println("·\tQ - Quit program                    ·");
        System.out.println("·········································");
    }
}