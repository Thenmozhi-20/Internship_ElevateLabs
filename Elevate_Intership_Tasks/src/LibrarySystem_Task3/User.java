package LibrarySystem_Task3;

abstract class User // some same(student,teacher) + some different → separate clearly.
{
	int userId ;
	String name;
	String email ;
	String dept;
	
	abstract void addUser(int id,String name,String email,String dept);
}