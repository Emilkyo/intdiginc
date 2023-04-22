package org.example;

import java.util.Scanner;
import java.util.ArrayList; // import the ArrayList class


public class Main {
    private static final ArrayList<String> codeList = new ArrayList<>(); // Create an ArrayList object

    public static void main(String[] args) {
        inputCodeList();
        incrementNumbers();
        printList();
    }

    public static void inputCodeList() {
        System.out.println("Type numbers and press Enter.");
        Scanner scanner = new Scanner(System.in);
        String code = scanner.nextLine();
        while (code.trim().length() != 0) {
            codeList.add(code);
            code = scanner.nextLine();
        }
    }

    public static void incrementNumbers() {
        String code;
        for (int i = 0; i < codeList.size(); i++) {
            code = codeList.get(i).replaceAll("\\s", "");
            int incCode;
            StringBuilder res = new StringBuilder();
            for (int k = 0; k < code.length(); k++) {
                incCode = code.charAt(k) - 48;
                incCode = (incCode < 9) ? incCode + 1 : 0;
                if (res.length() == 4) res.append(' ');
                res.append(incCode);
            }
            codeList.set(i, res.toString());
        }
        System.out.println("Digits incremented.");
    }

    public static void printList() {
        for (String elem : codeList) {
            System.out.println("\t" + elem + "  ");
        }
    }
}