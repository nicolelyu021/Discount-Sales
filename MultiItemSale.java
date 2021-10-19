//CS 280 Assignment 2
//Creator: Nicole Lyu

import java.util.Scanner;

/*Your program has to prompt the user for multiple items, each containing a name, 
price, and discount. If the item is named “end”, that denotes the end of the list. 
If the discount is 0, the item is of type Sale; otherwise, it is of type DiscountSale.
Print the total price with discounts applied to 2 places of accuracy. */


public class MultiItemSale extends DiscountSale{
	private static int count;
	//this number keeps track of how many times the array is used
	Sale [] Multi;
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		//Create an array that holds all sale objects 
		//make this array 100 spots so it can be partially filled
		
		Sale [] Multi = new Sale[100];
		
		System.out.println("Welcome to the shop!");
		System.out.println("Enter sale detail below. Type 'end' to quit.");
		
		//create individual sale item
		for (int i=0;i< 100; i++) {
			
			String itemName;
			while(true) {
				System.out.println("Enter the item name:");
				itemName=kb.nextLine();
				if (itemName!=null) 
					break;
				System.out.println("Invalid. Enter the item name: ");	
				
				}
				//If the item is named “end”, that denotes the end of the list
				if (itemName.equals("end"))
					break;	
			
			
			double itemPrice;
			while(true) {
				System.out.println("Enter the item price:");
				itemPrice=kb.nextDouble();
				kb.nextLine();
				if (itemPrice!=0)
					break;
				System.out.println("Invalid. Enter the item price: ");
				
			}
			
			
			double itemDiscount;
			while(true) {
				System.out.println("Enter the discount for the item if any: ");
				itemDiscount=kb.nextDouble();
				kb.nextLine();
		
				
				//If the discount is 0, the item is of type Sale; 
				//otherwise, it is of type DiscountSale.
				
				if (itemDiscount ==0) {
					Multi[i] = new Sale(itemName,itemPrice);
				}
				
				else {
					Multi[i] = new DiscountSale(itemName,itemPrice,itemDiscount); 
					}	
				
				
				
				break;
			   }
			
		   }
		
		//fill in the array
		double totalPrice=0;
		for (int a=0; a<Multi.length; a++) {
			if(Multi[a]!=null) {
				totalPrice = totalPrice+ Multi[a].bill();
				count++;
			}
		}
		
		
		
		String list=""; //all the items bought in a list
		for(int b=0; b<count; b++) {
			list = list + Multi[b] +"\n";
		}
		
		
		String finale = "The list of items purchased:\n" + list + "\n" + "Total Price =" + String.format("$%,.2f", totalPrice);
		
		System.out.println(finale);
		
		
		kb.close();
		
		
		
	}
	
	
}
		
		
	

	

