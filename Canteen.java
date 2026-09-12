import java.util.Scanner;

public class Canteen {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String[] menu = {"Burger", "Pizza", "Pasta", "Sandwich", "Milktea"};
        double[] price = {80.00, 120.00, 100.00, 70.00, 90.00};

        char again = 'Y';
        int totalItems = 0;
        double totalBeforeDiscount = 0;
        double totalDiscount = 0;
        double finalAmount = 0;

        while (again == 'Y' || again == 'y'){
            System.out.println("==== CANTEEN MENU ====");// i2 lng puh available xa menu namin maem..
            for(int i = 0; i < menu.length; i++){
                System.out.println((i + 1) + ". " + menu[i] + " - $" + String.format("%.2f", price[i]));
            }

            int itemNumber = 0;
            int quantity = 0;
            boolean validInput = false;

            do{ // 1 2 3 go kaniya kaniya na hahahhaha
                System.out.print("\nEnter the item number: ");
                itemNumber = scanner.nextInt();
                System.out.print("Enter the quantity: ");
                quantity = scanner.nextInt();

                if(itemNumber >= 1 && itemNumber <= menu.length && quantity > 0){
                    validInput = true;
                }
                else{
                    System.out.println("\nInvalid order! Please enter a valid item and quantity.\n");
                    System.out.print("Do you want to order again? (Y/N): ");
                    again = scanner.next().charAt(0);

                if(again == 'N' || again == 'n'){
                    break;
                }
                }
            } while(!validInput);

        
        if(again == 'N' || again == 'n'){
            continue;
        }

        System.out.print("Are you a student? (Y/N): ");
        char isStudent = scanner.next().charAt(0);
        scanner.nextLine();

        double subTotal = price[itemNumber - 1] * quantity;

        double discount = 0;
        double totalPrice = 0;

            
            if(isStudent == 'Y' || isStudent == 'y' && subTotal >= 500){ // first cond 
                discount = subTotal * 0.15; 
                totalPrice = subTotal - discount;
            }
            else if (isStudent == 'Y' || isStudent == 'y' && subTotal < 500){ // 2nd
                discount = subTotal * 0.10; 
                totalPrice = subTotal - discount;
            }
            else if (isStudent == 'N' || isStudent == 'n' && subTotal >= 500){ // 3rd
                discount = subTotal * 0.10; 
                totalPrice = subTotal - discount;
            }
            else { // 4th
                totalPrice = subTotal;

            }

            if (isStudent == 'Y' || isStudent == 'y'){
                System.out.println("\nSubtotal: $" + String.format("%.2f", subTotal));
                System.out.println("Discount: $" + String.format("%.2f", discount));
                System.out.println("Order total: $" + String.format("%.2f", totalPrice) + "\n");
            }
            else {
                System.out.println("\nSubtotal: $" + String.format("%.2f", subTotal));
                System.out.println("Order total: $" + String.format("%.2f", totalPrice) + "\n");
            }

            totalItems += quantity;
            totalBeforeDiscount += subTotal;
            totalDiscount += discount;
            finalAmount += totalPrice;

            System.out.print("Do you want to order again? (Y/N): ");
            again = scanner.next().charAt(0);
            

        }

        System.out.println("\n===== ORDER SUMMARY =====");
        System.out.println("Total Item: " + totalItems);
        System.out.println("Total before discount: $" + String.format("%.2f", totalBeforeDiscount));
        System.out.println("Total discount: $" + String.format("%.2f", totalDiscount));
        System.out.println("Final amount: $" + String.format("%.2f", finalAmount));
        System.out.println("Thank you for ordering!");

        scanner.close();

    }
}