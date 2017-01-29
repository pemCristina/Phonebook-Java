package com.cristina;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Contacts {
    private LinkedList<Contact> contacts = new LinkedList<>();
    private FileManager fileManager = new FileManager();

    public LinkedList<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(LinkedList<Contact> contacts) {
        this.contacts = contacts;
    }

    public int size() {
        return contacts.size();
    }

    public void addContact() {
        LinkedList<String> stringLinkedList = new LinkedList<>();
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Name: ");
        String name = keyboard.nextLine();

        System.out.print("Phone: ");
        String phone = keyboard.nextLine();

        Contact contact = new Contact(name, phone);
        contacts.add(contact);

        for (Contact c: contacts) {
            stringLinkedList.add(c.getName() + "-" + c.getPhone() + "-");
        }

        try {
            fileManager.createFile(Constants.FILE_PATH, stringLinkedList);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Saved new contact!");
    }

    public void loadContacts() {
        contacts.clear();

        List<String> fileContacts = fileManager.readFile(Constants.FILE_PATH);
        for (String line: fileContacts) {   // Each line: name-phone-
            int dashPosition = line.indexOf('-');

            String name = line.substring(0, dashPosition);
            String phone = line.substring(dashPosition + 1, line.length() - 1);

            Contact contact = new Contact(name, phone);
            contacts.add(contact);
        }
    }

    public void deleteContact() {
        Scanner keyboard = new Scanner(System.in);
        LinkedList<String> stringLinkedList = new LinkedList<>();

        System.out.println("Position to delete? ");
        try {
            int position = keyboard.nextInt();
            if (position < 0 || position >= contacts.size()) {
                System.out.println("Error!");
            } else {
                contacts.remove(position);

                for (Contact c: contacts) {
                    stringLinkedList.add(c.getName() + "-" + c.getPhone() + "-");
                }

                fileManager.createFile(Constants.FILE_PATH, stringLinkedList);
                System.out.println("Deleted contact!");
            }
        } catch (Exception e) {
            System.out.println("Error!");
        }
    }

    public void printContacts () {
        int i = 0;
        for (Contact contact: contacts) {
            System.out.println(i + " - " + contact.getName() + " - " + contact.getPhone());
            ++i;
        }
        if(contacts.size() == 0) {
            System.out.println("No contacts");
        }
    }
}

