package utils;

import java.util.Scanner;

@SuppressWarnings("squid:S106")
public abstract class Misc {

    public static String readInput(String text) {
        System.out.println(text);
        return new Scanner(System.in).next();
    }

    public static void waitForKeypress() {
        waitForKeypress("Prima ENTER para continuar...");
    }

    public static void waitForKeypress(String text) {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println(text);
        scanner.nextLine();
    }

    static void printSeparator() {
        System.out.println("\n\n\n\n\n\n\n\n");
    }
}
