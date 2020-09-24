import java.util.*;

public class ToolKit {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(true){
            try{
                runMenu(sc);
                return;
            }catch (Exception ex){
                sc.nextLine();
            }
        }

    }

    public static void runMenu(Scanner sc){
        printMenu();
        int userSelection = sc.nextInt();
        sc.nextLine();
        menu(userSelection,sc);
    }

    public static void menu(int userSelection, Scanner scanner){
        switch (userSelection){
            case 0:
                System.exit(0);
            case 1:
                encryptString(scanner);
                runMenu(scanner);
                break;
            case 2:
                decryptString(scanner);
                runMenu(scanner);
                break;
            case 3:
                findSum(scanner);
                runMenu(scanner);
                break;
            case 4:
                findValue(scanner);
                runMenu(scanner);
                break;
        }
    }

    public static void printMenu(){
        System.out.println("=========================== Toolkit ===========================");
        System.out.println("Enter 1 to Encrypt Message");
        System.out.println("Enter 2 to Decrypt Message");
        System.out.println("Enter 3 to find sum of numbers");
        System.out.println("Enter 4 to check if number exists in array");
        System.out.println("Enter 0 to quit");
        System.out.println("=========================== Toolkit ===========================");
        System.out.println("Select : ");
    }


    public static void encryptString(Scanner scanner){
        System.out.println("Please enter the string to encrypt: ");
        String userInput = scanner.nextLine();


        while(true){
            String encyptedString = "";
            System.out.println("Please enter the value to encrypt string with: ");
            int encryptValue = scanner.nextInt();

            for (int i = 0; i <userInput.length(); i++) {
                char c = userInput.charAt(i);
                encyptedString += (char)((int)c + encryptValue);
            }

            if(!(encyptedString.matches("\\A\\p{ASCII}*\\z"))){
                System.out.println("The encypted value contains unprintable characters! Please choose a lower encrypt value!");
                scanner.nextLine();
            }else{
                System.out.println(String.format("Encrypted value is : %s \n",encyptedString));
                return;
            }
        }
    }

    public static void decryptString(Scanner scanner){
        System.out.println("Please enter the string to decrypt: ");
        String userInput = scanner.nextLine();



        while(true){
            String decyptedString = "";

            System.out.println("Please enter the value to decrypt string with: ");
            int decryptValue = scanner.nextInt();

            for (int i = 0; i <userInput.length(); i++) {
                char c = userInput.charAt(i);
                decyptedString += (char)((int)c - decryptValue);
            }

            if(!(decyptedString.matches("\\A\\p{ASCII}*\\z"))){
                System.out.println("The encypted value contains unprintable characters! Please choose a lower encrypt value!");
                scanner.nextLine();
            }else{
                System.out.println(String.format("Decrypted value is : %s \n",decyptedString));
                return;
            }
        }
    }

    public static void findSum(Scanner scanner){
        System.out.println("Enter values to sum: please use a space to seprate values");

        String userInput = scanner.nextLine();
        String[] userInputArray = userInput.split(" ");

        double[] doubleValues = Arrays.stream(userInputArray).mapToDouble(Double::parseDouble).toArray();


        //  Method one using loops
        double loopSum = 0;
        for(int i = 0; i < doubleValues.length; i++){
            loopSum += doubleValues[i];
        }

        //  Method 2 using streams
        double sum = Arrays.stream(doubleValues).sum();
        System.out.println(String.format("Sum of the values are : %s \n", sum));
    }

    public static void findValue(Scanner scanner){
        System.out.println("Enter values to search: ");
        double searchValue = scanner.nextDouble();
        double[] array =  {10.0, 9.9, 59.8, 29.0, 34.8, 60.7, 57.5, 69.9, 20.0, 36.0, 32.2, 99.9};
        String keyword = "does not";


        //  Method one using loops
        for(int i = 0; i < array.length; i++){
            if(array[i] == searchValue){
                keyword = "does";
                break;
            }
        }

        //  Method one using anymatch in DoubleStream
        if(Arrays.stream(array).anyMatch(num -> num == searchValue)){
            keyword = "does";
        }

        System.out.println(String.format("Array %s contains value %s \n", keyword, searchValue));
    }
}
