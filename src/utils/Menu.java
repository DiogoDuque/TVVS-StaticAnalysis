package utils;

import java.util.List;
import java.util.Scanner;

import static utils.Misc.printSeparator;
import static utils.Misc.waitForKeypress;

public class Menu {
    private String title;
    private List<MenuItem> options;

    public Menu(String title, List<MenuItem> options) {
        this.title = title;
        this.options = options;
    }

    @SuppressWarnings("squid:S106")
    void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int index = -1;

        while(index != options.size()) {
            printSeparator();
            printTitle();
            for(int i=0; i<options.size(); i++) {
                System.out.println(i+" -> "+options.get(i).toString());
            }
            System.out.println(options.size()+" -> Sair");
            System.out.println();
            System.out.print("Escolha uma opção: ");
            index = scanner.nextInt();
            if(index >=0 && index < options.size()) {
                options.get(index).execute();
            }
        }
    }

    @SuppressWarnings("squid:S106")
    private void printTitle() {
        int size = title.length();
        StringBuilder sb = new StringBuilder("####");
        for(int i=0; i<size; i++) {
            sb.append("#");
        }
        String margin = sb.toString();
        System.out.println(margin);
        System.out.println("# "+title+" #");
        System.out.println(margin);
    }

    @SuppressWarnings("squid:S106")
    static void showList(List<String> options) {
        printSeparator();
        if(options.isEmpty()) {
            System.out.println("This list is empty");
        } else for(String option: options) {
            System.out.println(option);
        }
        waitForKeypress();
    }
}
