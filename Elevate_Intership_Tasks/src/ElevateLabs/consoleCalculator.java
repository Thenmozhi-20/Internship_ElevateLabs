package ElevateLabs;
import java.util.*;

public class consoleCalculator 
{
	private static int add(int a, int b)
	{
		return a+b; 
	}
	private static int sub(int a,int b)
	{
		return a-b;
	}
	private static int mul(int a,int b)
	{
		return a*b ;
	}
	private static int div(int a,int b)
	{
		return a/b; 
	}
	
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		while(true)
		{
			System.out.print("Enter 1st number: ");
			int a = in.nextInt();
			System.out.print("Enter 2nd number:");
			int b = in.nextInt();
			System.out.println();
			
			System.out.println("1.Addition\n2.Subtraction\n3.Multiplication\n4.Division\n5.Exit");
			System.out.print("Choose any one operation:");
			int option = in.nextInt();
			
			switch(option)
			{
			case 1 :
				System.out.println("You chose Addition!");
				System.out.println("Addition of "+ a+ " and " + b + " is "+ add(a,b));
				break;
				
			case 2 :
				System.out.println("You chose Subtraction!");
				System.out.println("Subtraction of "+a+" and "+b+" is "+sub(a,b));
				break;
			
			case 3 :
				System.out.println("You chose Multiplication!");
				System.out.println("Multiplication of "+a+" and "+ b + " is "+ mul(a,b));
				break;
			
			case 4 :
				System.out.println("You chose Division!");
				if(b==0)
				{
					System.out.println("Enter valid number from 1 :");
					b = in.nextInt();
				}
				System.out.println("Divisin of "+a+" and "+b+" is "+div(a,b));
				break;
			
			case 5 :
				System.out.println("You chosen Exit!");
				System.exit(0);
				
			default :
				System.out.println("Invalid Operation");
			}
			
			System.out.println("------------------------------------------------------------------");
		}
	}
}

