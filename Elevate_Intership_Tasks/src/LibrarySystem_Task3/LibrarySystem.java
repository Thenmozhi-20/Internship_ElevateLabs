package LibrarySystem_Task3;

import java.util.HashMap;
import java.util.ArrayList;

interface bookOperations
{
	void issueBook(IssuedBookDetails is);
	//void issuedBooksDetails();
	void returnBook(LibrarySystem lib,int id);
	boolean checkBook(int bId);
}

class LibrarySystem implements bookOperations
{
	HashMap<Integer,User> user = new HashMap<>();
	HashMap<Integer,Book> book = new HashMap<>();
	HashMap<Integer,ArrayList<IssuedBookDetails>> issuedDetails = new HashMap<>();
	
	public void addUser(User u)
	{
		user.put(u.userId,u);
	}
	
	public void addBook(Book b)
	{
		book.put(b.bookId, b);
	}
	
	@Override
	public void issueBook(IssuedBookDetails issue) 
	{
		// here for the each user helps to store the issued book details. if there's id not already issued then create the 
		// arraylist.otherwise not created.. already available updated only.
		
		issuedDetails.putIfAbsent(issue.userId,new ArrayList<>());
		issuedDetails.get(issue.userId).add(issue);
	}

	@Override
	public void returnBook(LibrarySystem lib,int id) 
	{
		if(lib.issuedDetails.containsKey(id))
		{
			// check all books are returned or not.
			if(lib.issuedDetails.get(id).isEmpty())
			{
				lib.user.remove(id);
				lib.issuedDetails.remove(id);
				System.out.println("User: "+id+" Successfully Deleted!!");
			}
			else
			{
				 System.out.println("User has issued books. Return all books before deletion.");
			}
		}
		else
		{
			System.out.println("User not Found!");
		}
	}

	@Override
	public boolean checkBook(int bId) {
		if(book.containsKey(bId))
		{
			return true;
		}
		return false;
	}
	
	/*@Override
	public void issuedBooksDetails()
	{
		
	}*/
	
}