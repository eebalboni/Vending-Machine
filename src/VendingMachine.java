public class VendingMachine {

    private static final String NAME = "Captain Vending Services";

    public static void main(String[] args) {
        System.out.println("Welcome to the " + NAME);
        printInstructions();
    }

    public static void printInstructions() {
        System.out.println("\tINSTRUCTIONS");
        System.out.println("First, please enter any amount of $1 bills you would like to purchase with");
        System.out.println("Then, pick from our amazing selection of delicious foods and drinks");
        System.out.println("Once you have selected your order, you can verify or cancel your order");
        System.out.println("Any leftover funds will be returned at the end of the transaction");
    }
}
