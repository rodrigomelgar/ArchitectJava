package com.randomk;

import java.util.regex.Pattern;

public class Main {

    public static final String regex = "([aeiou][bcdfghjklmnpqrstvwxz][aeiou])";


    public static void main(String[] args) {

        String stream = "aAbBABacafe";

        if (checkString(stream)){
            System.out.println("encontrou");

        } else {

            System.out.println("nao encontrou");
        }



    }

    public static boolean checkString(String arg) {
        return Pattern.compile(regex).matcher(arg).find();
    }
}
