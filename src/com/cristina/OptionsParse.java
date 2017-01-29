package com.cristina;

public class OptionsParse {
    public static OptionMenu parse(String text) {
        OptionMenu option;
        if(text.equalsIgnoreCase("a")) {
            option = OptionMenu.ADD;
        } else if(text.equalsIgnoreCase("d")) {
            option = OptionMenu.DELETE;
        } else if(text.equalsIgnoreCase("l")) {
            option = OptionMenu.LIST;
        } else if(text.equalsIgnoreCase("h")) {
            option = OptionMenu.HELP;
        } else if(text.equalsIgnoreCase("q")) {
            option = OptionMenu.QUIT;
        } else {
            option = OptionMenu.UNKNOWN;
        }
        return option;
    }
}
