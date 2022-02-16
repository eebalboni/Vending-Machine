/*
    Vending Machine
    By: Emily Balboni and Thomas Kwasnak
    February 16, 2021
    CSC 109
    Professor Alex
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class VendingMachine {

    private static final String NAME = "Captain Vending Services";
    private static Scanner scan = new Scanner(System.in);
    private static ArrayList<String> item = new ArrayList<String>();
    private static Integer cost = 0;
    private static String reply = "";

    private static final HashMap <String,Integer> options = new HashMap<String, Integer>(){{
        put("Apple",2);
        put("Doritos",3);
        put("Banana",1);
        put("Potato chips",3);
    }};

    public static void main(String[] args) {
        System.out.println("Welcome to the " + NAME);
        printInstructions();
        do{
            printMenu();
            System.out.println("Please enter the food item you would like: ");
            item.add(scan.next());
            System.out.println("Would you like another item? Yes|No");
            reply = scan.next();
        }while(reply.equals("Yes"));

        //prints out the total price of the items the user wants
        System.out.println("The cost of your request is: " + returnPrice(item));

    }

    //prints instructions for machine
    public static void printInstructions() {
        System.out.println("\tINSTRUCTIONS");
        System.out.println("First, please enter any amount of $1 bills you would like to purchase with");
        System.out.println("Then, pick from our amazing selection of delicious foods and drinks");
        System.out.println("Once you have selected your order, you can verify or cancel your order");
        System.out.println("Any leftover funds will be returned at the end of the transaction");
    }

    //returns price of items user selects
    public static int returnPrice(ArrayList <String> objects){
        int c = 0;
        for(int i = 0; i < objects.size(); i++){
            c = c + options.get(objects.get(i));
        }
        return c;
    }

    //make nicer later
    //returns printed menu
    public static void printMenu(){
       System.out.println(options.entrySet());
    }

}
