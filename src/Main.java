import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean quit = false;
        String action;
        ArrayList <String> list = new ArrayList<String>();
        list.addAll(Arrays.asList("Demandred", "Ishamael", "Lanfear", "Mesaana", "Semirhage", "Balthamel", "Aginor",
                                   "Asmodean", "Rahvin", "Sammael", "Be'lal", "Graendal", "Moghedien"));

        do {
            Print(list);
            action = InputHelper.getRegExString(scan, "A - Add an item to the list \n" + "D – Delete an item from the list \n" +
                                                            "P – Print the list\n" + "Q – Quit the program\n", "[AaDdPpQq]");
            if (action.equalsIgnoreCase("A")) {
                Add(scan, list);
            } else if (action.equalsIgnoreCase("D")) {
                Delete(scan, list);
            } else if (action.equalsIgnoreCase("P")) {
                Print(list);
            } else if (action.equalsIgnoreCase("Q")) {
                Quit(scan, quit);
            }
        } while (!quit);
    }

    public static void Add(Scanner scan, ArrayList<String> list){
        System.out.println("What do you want to add to the list?");
        String newItem = scan.nextLine();
        int indexNum = InputHelper.getRangedInt(scan,"Where do you want to add this to the list?", 0, list.size()); //wanted to do a little extra here
        list.add(indexNum, newItem);
    }

    public static void Delete(Scanner scan, ArrayList<String> list){
        list.remove(InputHelper.getRangedInt(scan, "What is the index of the list item would you like to delete? (0 - " + (list.size() - 1) + ")", 0, list.size() - 1));
    }

    public static void Print(ArrayList<String> list){
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + " - " + list.get(i));
        }
        System.out.println();
    }

    public static void Quit(Scanner scan, boolean quit){
        quit = InputHelper.getYNConfirm(scan, "Are you sure you want to quit? [Y/N]");

        if (quit) {
            System.exit(0);
        }
    }
}