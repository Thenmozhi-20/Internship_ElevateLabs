package LibrarySystem_Task3;

public class IssuedBookDetails 
{
	int userId ;
	int bookId ;
	String bookName ;
	
	public IssuedBookDetails(int userId,int bookId,String bookName)
	{
		this.userId = userId;
		this.bookId = bookId;
		this.bookName = bookName;
	}
	
	public void IsAndBkDetails()
	{
		System.out.println("User Id: "+userId +" ,Book Id: "+bookId+" ,Book Name: "+bookName);
	}
	
	public void IssuedDetails()
	{
		System.out.println("Book Id: "+bookId+" ,Book Name: "+bookName);
	}
}
