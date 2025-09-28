package LibrarySystem_Task3;
import java.util.*;

class Student extends User
{
	public void addUser(int id,String name,String email,String dept)
	{
		this.userId = id;
		this.name = name; 
		this.email = email;
		this.dept = dept;
	}
	
	void viewProfile(Scanner in,LibrarySystem library)
	{
		System.out.println("Name: "+name +", ID: "+userId+" ,Email: "+email+" ,Department: "+dept);
		System.out.print("Do you want to see issued book details? (yes/no): ");
		String choice = in.nextLine().toLowerCase();
		
		if(choice.equals("yes"))
		{
			if(library.issuedDetails.containsKey(userId))
			{
				ArrayList<IssuedBookDetails> details = library.issuedDetails.get(userId);
				if(details.isEmpty())
				{
					System.out.println("All books are returned..");
				}
				for(IssuedBookDetails ds : details)
				{
					ds.IssuedDetails();
				}
			}
			else
				System.out.println("No Books Issued Yet!!");
		}
	}
}