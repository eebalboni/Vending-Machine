/*
    Vending Machine
    By: Emily Balboni and Thomas Kwashnak
    February 16, 2021
    CSC 109
    Professor Alex Thimineur
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class VendingMachine {

    private static final String NAME = "Captain Vending Services";
    private static Scanner scan = new Scanner(System.in);
    private static ArrayList<String> item = new ArrayList<String>();
    private static Integer cost = 0;
    private static int balance;
    private static String reply = "";

    //items in the vending machine
    private static final HashMap <String,Integer> options = new HashMap<String, Integer>(){{
        put("Apple",2);
        put("Doritos",3);
        put("Banana",1);
        put("Potato chips",3);
    }};

    public static void main(String[] args) {
        System.out.println("Welcome to the " + NAME);
        printInstructions();
        enterMoney();

        //start of machine
        do{
            printMenu();
            System.out.println("Your current balance is:$" + (balance - returnPrice(item)));
            System.out.println("Please enter the food item you would like: ");
            String choice = scan.nextLine();
            item.add(choice);
            if(returnPrice(item) > balance) {
                System.out.println("You can't afford that!");
                item.remove(choice);
            }
            System.out.println("Would you like another item? Yes|No");
            reply = scan.nextLine();
        }while(reply.equals("Yes"));

        //prints out the total price of the items the user wants
        System.out.println("The cost of your request is:$" + returnPrice(item));
        System.out.println("Would you like to cancel your order? Yes|No");
        reply = scan.nextLine();
        if(reply.equals("Yes")){
            System.out.println("Here is your $" + balance + " returned. Have a great day!");
        }else{
            System.out.println("Your change will be $" + (balance - returnPrice(item)));
            System.out.println("Enjoy the rest of your day and thank you for stopping by " + NAME + "!");
        }


    }
    //sets balance for user
    public static void enterMoney() {
        System.out.println("Please type the number of dollars you would like to enter");
        balance = Integer.parseInt(scan.nextLine());
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
            c = c + options.getOrDefault(objects.get(i),0);
        }
        return c;
    }

    //returns printed menu
    public static void printMenu(){
       System.out.println(options.entrySet());
    }

}
