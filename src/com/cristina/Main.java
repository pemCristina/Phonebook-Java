package com.cristina;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Contacts contacts = new Contacts();
        boolean end = false;

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
        System.out.println("·\tL - List a phonebook                ·");
        System.out.println("·\tH - Display help                    ·");
        System.out.println("·\tQ - Quit program                    ·");
        System.out.println("·········································");
    }
}