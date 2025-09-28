package LibrarySystem_Task3;

import java.util.*;

public class library_management_system 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		LibrarySystem library = new LibrarySystem();
		
		while(true)
		{
			System.out.println("Operations:");
			System.out.println("1.Add Book\n2.Add User\n3.Issue Book\n4.Return Book\n5.Search Book\n6.View Profile\n7.Delete User\n8.Exit");
			System.out.print("Enter any One Operation: ");
			int n = in.nextInt();
			in.nextLine();
			
			switch(n)
			{
			case 1:
				System.out.print("Are you Admin? (yes/no): ");
				String person = in.nextLine().toLowerCase();
				
				if(person.equals("yes"))
				{
					System.out.print("Enter Password: ");
					int password = in.nextInt();
					in.nextLine();
					
					if(password==120201)
					{
						System.out.println("Enter Below Details: ");
						System.out.print("Book Id: ");
						int bId = in.nextInt();
						in.nextLine();
						
						System.out.print("Book Name: ");
						String bName = in.nextLine();
						
						System.out.print("Author Name: ");
						String bAuthor = in.nextLine();
						
						Book book = new Book(bId,bName,bAuthor);
						library.addBook(book);
						System.out.println("Book Successfully Stored.");
					}
					else
						System.out.println("Wrong Password");
				}
				break;
				
			case 2:
				System.out.println("Enter Below Details: ");
				System.out.print("Id: ");
				int uId = in.nextInt();
				in.nextLine();
				
				System.out.print("Name: ");
				String uName = in.nextLine();
				
				System.out.print("Email Id: ");
				String uEmail = in.nextLine();
				
				System.out.print("Department: ");
				String uDept = in.nextLine();
				
				System.out.print("Are you Student or Tutor: ");
				String person1 = in.nextLine().toLowerCase();
				
				if(person1.equals("student"))
				{
					Student std = new Student();
					std.addUser(uId, uName, uEmail, uDept);
					
					library.addUser(std);
					System.out.println("Success! You've successfully created your account");
				}
				else if(person1.equals("tutor"))
				{
					Tutor tutor = new Tutor();
					tutor.addUser(uId, uName, uEmail, uDept);
					
					library.addUser(tutor);
					System.out.println("Success! You've successfully created your account");
				}
				else
					System.out.println("Give in correct form (student or tutor).");
				break;
				
			case 3 :
				System.out.print("Enter your Id: ");
				int id = in.nextInt();
				in.nextLine();
				
				if(!library.user.containsKey(id))
				{
					System.out.println("User Not found!!");
				}
				else
				{
					System.out.print("Enter Book Id: ");
					int bkId = in.nextInt();
					in.nextLine();
					
					System.out.print("Enter Book Name: ");
					String bkName = in.nextLine();
					
					if(library.checkBook(bkId))
					{
						IssuedBookDetails issue = new IssuedBookDetails(id,bkId,bkName);
						library.issueBook(issue);
						System.out.println("Book issued Successfully!");
					}
					else
					{
						System.out.println("Enter correct Book Id.");
					}
				}
				break;
				
			case 4 :
				System.out.print("Enter Your Id: ");
				int uid = in.nextInt();
				System.out.print("Enter Book Id: ");
				int bid = in.nextInt();
				in.nextLine();
				
				if(library.issuedDetails.containsKey(uid))
				{
					ArrayList<IssuedBookDetails> issue = library.issuedDetails.get(uid);
					// for value based deletion for return book(remove that book from that user)
					Iterator<IssuedBookDetails> it = issue.iterator();
					// if i removed from it, then that elements also removed from the issue.
					while(it.hasNext())
					{
						IssuedBookDetails is = it.next();
						if(is.bookId == bid)
						{
							it.remove();
							System.out.println("Successfully Book Returned.");
						}
					}
				}
				break;
				
			case 5 :
				System.out.println("Enter Book Id: ");
				int bkId = in.nextInt();
				in.nextLine();
				
				if(library.checkBook(bkId))
					System.out.println("This Book is Available!");
				else
					System.out.println("This Book is not Available!");
				break;
			
			case 6 :
				System.out.print("Enter your User Id: ");
				int checkId = in.nextInt();
				in.nextLine();
				/*
				 instanceof is a keyword in Java that checks whether an object is an instance of a particular class 
				 (or subclass, or that implements an interface).It returns a boolean value (true or false).
				 */
				if(library.user.containsKey(checkId))
				{
					User u = library.user.get(checkId);
					if(u instanceof Student)
					{
						((Student)u).viewProfile(in, library);
					}
					else if(u instanceof Tutor)
					{
						((Tutor)u).viewProfile(in, library);
					}
				}
				else
				{
					System.out.println("User not found!");
				}
				break;
			
			case 7 : 
				System.out.println("Enter Your Id: ");
				int urId = in.nextInt();
				in.nextLine();
				
				library.returnBook(library,urId);
				break;
			
			case 8 :
				System.out.println("You are Exiting!");
				System.exit(0);
			
			default :
				System.out.println("Invalid Operator");
			}
			
			System.out.println("----------------------------------------------------------------");
		}
	}
}
