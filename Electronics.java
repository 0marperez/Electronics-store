/* CS1301 Intro to Computer Science
 *Instructor: Aguirre 
 *Lab 1
 *Submitted by: Omar Fernando Perez
*/

import java.util.Scanner;
import java.io.File;

public class Electronics {
    
    //This is the mainMenu method
    
    public static int mainMenu (String name, double subtotalAmount, int numItemsCart) {

        Scanner scan = new Scanner(System.in);
        int menuOption;
        
        System.out.print("\nMain Menu\nWelcome " + name + "!\nSubtotal amount: $ ");
        System.out.printf("%.2f", subtotalAmount);
        System.out.print("\nCart: " + numItemsCart + "\n\t1. Search item\n\t2.Check out\nAnswer: "); 
             
            menuOption = scan.nextInt();
            
            return menuOption;
        }
    
     public static void main(String []args) throws Exception {
 
    File data = new File("student.txt");
    Scanner scnr = new Scanner(data); 
    Scanner scan = new Scanner(System.in);
    
         
    //These are all the variables I extracted from the student.txt file.
         
    String name = scnr.nextLine();
    String username = scnr.nextLine();   
    String password = scnr.nextLine();     
    String accountNumber = scnr.nextLine();
    String routingNumber = scnr.nextLine();
    String address = scnr.nextLine();
    String promoCode = scnr.nextLine();
    
    //These are all the variables I created for the program to run.
         
    String userUsername;
    String userPassword;
    Boolean blocked = false;
    String userName;
    String userAccountNumber;
    String userRoutingNumber;
    String userAddress;
    double deposit;
    double subtotalAmount = 0;
    int numItemsCart = 0;
    int menuOption;
    int catalogOption;
    int productOption =0;
    int quantityItem = 0;
    int searchItemOptions;
    double intendedPurchase =0.0;
    double priceItem = 0.0;
    String checkoutOption;
    String promoOption ="0";
    String userPromoCode;
         
   
   //This section of code is for the login.      
         
    System.out.println("\nWelcome to UTEP electronics!");
    System.out.print("Username: ");
    
    userUsername = scan.nextLine();
    
    System.out.print("Password: ");
    
    userPassword = scan.nextLine();
    
    int i = 0; 
    
    while (!userUsername.equals(username) || !userPassword.equals(password)){
        
        i++;
            
        if (i == 3){
            System.out.println("\nSorry, you are temporarily blocked from the platform. Please try again in a couple of hours.");
            
            blocked = true;
            break;
            }
        
        System.out.println("\nWelcome to UTEP electronics!\nSorry, you entered invalid credentials. Try again.");
        System.out.print("Username: ");
                           
        userUsername = scan.nextLine();
        System.out.print("Password: ");
                           
        userPassword = scan.nextLine();
    
        }

    //If the user is not blocked this next section of code is executed.
         
         
         if (blocked != true){
             
             //This section of code is to get the users debit card information.
             
             System.out.println("\nWelcome " + name + "\nBefore you make any purchase, we need some info from your Debit Card to perform a deposit.\nPlease enter: \n");
             
             System.out.print("CARDHOLDER NAME: ");
             userName = scan.nextLine();
             
             System.out.print("ACCOUNT NUMBER: ");
             userAccountNumber = scan.nextLine();
             
             System.out.print("ROUTING NUMBER: ");
             userRoutingNumber = scan.nextLine();
             
             System.out.print("ADDRESS: ");
             userAddress = scan.nextLine();
             
             //This while loop is here to verify the user enters the correct debit card information
             
             while (!userName.equals(name) || !userAccountNumber.equals(accountNumber) || !userRoutingNumber.equals(routingNumber) || !userAddress.equals(address)){
                
                 System.out.print("Sorry, we do not recognize your Card Information. Please try again.\n\n");
                 
             System.out.print("CARDHOLDER NAME: ");
             userName = scan.nextLine();
             
             System.out.print("ACCOUNT NUMBER: ");
             userAccountNumber = scan.nextLine();
             
             System.out.print("ROUTING NUMBER: ");
             userRoutingNumber = scan.nextLine();
             
             System.out.print("ADDRESS: ");
             userAddress = scan.nextLine();
             }
             
             
        //This section of code is for the user to enter how much he wants to deposit.
             
             
             System.out.print("\nExcellent! You are now ready to make a deposit.\nEnter deposit amount: $ ");
             
             deposit = scan.nextDouble();
             
             while (deposit > 5000){
                 
                 System.out.print("\nSorry, you can only deposit up to $5,000.00 into the account. Try entering a lower amount.\nEnter deposit amount: $ ");
                 
                 deposit = scan.nextDouble();
                 
             }
             
        //The function mainMenu is excecuted and it returns the users input and assigns it to the menuOption string.
             
             menuOption =  mainMenu(name, subtotalAmount, numItemsCart);
             
             //This while loop is to keep coming back to the main menu while the user doesn't want to check out.
             
             while (menuOption != 2){
                 
                 //This is the catalog options
                 
                 System.out.print("\nCatalogs:\n\t1.TVs\n\t2.Laptops\n\t3.Cell phones\n\t4.Accessories\n\t0.Go back\nWhich catalog would you like to see: ");
                 
                catalogOption = scan.nextInt();
                 
                 //This switch statement contains what to do for the different catalogs
                 
                 switch (catalogOption){
                        
                    case 1:
                        
                        System.out.print("\n\tTVs:\n1.Vizio 32\"\t$139.56\n2.LG 50\"\t$384.12\n3.Samsung 55\"\t$564.98\n4.SONY 70\"\t$819.47\n\n0.Main Menu\n\nPlease select an option: ");
                        
                        productOption = scan.nextInt();
                            
                        //Each catalog contains a switch statement for the different product options
                         
                         switch (productOption){
                                
                            case 1:
                                
                                priceItem = 139.56;
                                break;
                        
                            case 2:
                                
                                priceItem = 384.12;
                                break;
                                
                            case 3:
                                
                                priceItem = 564.98;
                                break;
                                
                            case 4:
                                
                                priceItem = 819.47;
                                break;
                                
                            case 0:
                             
                                priceItem = 0.0;
                                break;
                        }
                        break;
                          
                    case 2:
                        
                        System.out.print("\n\tLaptops:\n1.Surface GO!\t\t$549.99\n2.Apple MacBook Air\t$1299.99\n3.Lenovo\t\t$539.53\n4.HP Laptop\t\t$699.99\n\n0.Main Menu\n\nPlease select an option: ");
                        
                        productOption = scan.nextInt();
                     
                        switch (productOption){
                                
                            case 1:
                                
                                 priceItem = 549.99;
                                break;
                                
                            case 2:
                                
                                 priceItem = 1299.99;
                                break;
                        
                            case 3:
                                
                                priceItem = 539.53;
                                break;
                         
                            case 4:
                                
                                 priceItem = 699.99;
                                break;
                                
                            case 0:
                               
                                priceItem = 0.0;
                                break;
                        }
                        break;
                
                    case 3:
                        
                        System.out.print("\n\tCell Phones:\n1.iPhone 11\t$749.84\n2.Galaxy Fold\t$1980.00\n3.Galaxy S10\t$998.97\n4.Google Pixel\t$378.78\n\n0.Main Menu\n\nPlease select an option: ");
                        
                        productOption = scan.nextInt();
                        
                        switch (productOption){
                                
                            case 1:
                                
                                 priceItem = 749.84;
                                break;
                        
                            case 2:
                                
                                 priceItem = 1980.00;
                                break;
                        
                            case 3:
                                
                                 priceItem = 998.97;
                                break;
                        
                            case 4:
                                
                                 priceItem = 378.78;
                                break;
                        
                            case 0:    
                        
                                priceItem = 0.0;
                                break;
                        }
                        break;
                        
                    case 4:
                        
                        System.out.print("\n\tAccessories:\n1.Apple Watch\t\t\t$214.08\n2.Keurig Coffee Maker\t\t$89.00\n3.Amazon Echo\t\t\t$72.51\n4.Nintendo Switch Controller\t$61.19\n\n0.Main Menu\n\nPlease select an option: ");
                        
                        productOption = scan.nextInt();
                        
                        switch (productOption){
                                
                            case 1:
                               
                                 priceItem = 214.08;
                                break;
                        
                            case 2:
                                
                                priceItem = 89.00;
                                break;
                        
                            case 3:
                                
                                 priceItem = 72.51;
                                break;
                        
                            case 4:
                                
                                 priceItem = 61.19;
                                break;
                        
                            case 0:   
                                
                                priceItem = 0.0;
                                break;
                        }
                        break;
                        
                    case 0:
                        break;
                        
             }
                 
                 //This if statement will only execute if the user actually added something to his cart, and it asks for the quantity and calculates if it goes over his available funds
                         
                 if (priceItem != 0.0 && catalogOption != 0){
                     
                 System.out.print("\nEnter quantity of item ");
                 
                        quantityItem = scan.nextInt();
                        
                        intendedPurchase = priceItem * quantityItem;
                 
                                subtotalAmount = subtotalAmount + intendedPurchase;
            
                                numItemsCart = numItemsCart + quantityItem;
                 
                }
                       
                 //This will execute if the user's subtotal amount is more than his available funds
                 
                if (subtotalAmount > deposit){
                            
                    System.out.print("\nNot enough funds to add this item to the cart.\n");
                                    
                    subtotalAmount = subtotalAmount - intendedPurchase;
                    numItemsCart = numItemsCart - quantityItem;
                } 

                 
                 menuOption =  mainMenu(name, subtotalAmount, numItemsCart);
                 
                 
             }
             
             //When the big while loop is escaped the user wants to chekout, and this code will be executed
             
             System.out.print("Are you sure you want to proceed with payment?  [Yes/No]\n");
             
             scan.nextLine();
             checkoutOption = scan.nextLine();
             
             
             if (checkoutOption.equals("Yes") || checkoutOption.equals("yes")){
                 
                 //This piece of code will ask if the use wants to use a promo code
                 
                 System.out.print("\nDo you want to use a promo code?   [Yes/No]\n");
                 
                 promoOption = scan.nextLine();
                 
                 
                 
                 if (promoOption.equals("yes") || promoOption.equals("Yes")){
                     
                     System.out.print("\nPlease enter promo code: ");
                     
                     userPromoCode = scan.nextLine();
                     
                        //If the user doesn't enter the right promo code this piece of code will ask again
                     
                        while (!userPromoCode.equals(promoCode)){

                            System.out.print("\nSorry you entered an invalid code. Try again");
                         
                            userPromoCode = scan.nextLine();
                     
                     }
                     
                     //If the right promo code is entered this message will appear and the discount will be applied to the subtotal
                     
                     System.out.print("\nYou now have a 20% discount");
                     
                     subtotalAmount = subtotalAmount * 0.8;
                     
                 }
                 
                //If the user didn't want to use a promo code the checkout message is printed
                 
                if (promoOption.equals("no") || promoOption.equals("No")){
                     
                }
                 
                 
                 System.out.print("\n\nThank you for your purchase!\nYour items will be shipped to your address: " + address + "\nTotal amount: $" );
                 System.out.printf("%.2f", subtotalAmount);
                 System.out.print("\nRemaining Miner bucks is: $");
                 System.out.printf("%.2f", deposit - subtotalAmount);
                 System.out.print("\n");
             }
             
             //If the user doesn't want to check out this piece of code will execute and the program ends.
             
             if (checkoutOption.equals("No") || checkoutOption.equals("no")){
                 
                 System.out.print("\nNo worries, we hope to hear from you soon!\nYour budget is: $" + deposit + "\n");
                 
             }
         }
             
     }
}

 
            
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
        