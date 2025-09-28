package LibrarySystem_Task3;


class Book
{
	int bookId;
	String title ;
	String author ;
	
	public Book(int id,String title,String author)
	{
		this.bookId = id;
		this.title = title;
		this.author = author;
	}
	
	void displayBookInfo()
	{
		System.out.println("ID: "+bookId + ", Title: "+title + ", Author: "+author);
	}
}