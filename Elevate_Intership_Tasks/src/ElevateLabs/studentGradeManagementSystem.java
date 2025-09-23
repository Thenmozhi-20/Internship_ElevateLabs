package ElevateLabs;
import java.util.*;

class Student
{
	int id ;
	String name;
	String dept ;
	int marks[];
	
	Student(int id,String name,String dept,int marks[])
	{
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.marks = marks;
	}
	
	public void viewDetails()
	{
		System.out.println("Id: "+ id);
		System.out.println("Name: "+name);
		System.out.println("Department: "+dept);
		System.out.print("Marks are: ");
		for(int i : marks)
			System.out.print(i+" ");
	}
	
}
public class studentGradeManagementSystem 
{
	public static void main(String[] args) 
	{
		ArrayList<Student> studentDetails = new ArrayList<>();
		Scanner in = new Scanner(System.in);
		int marks[] = new int[5];
		
		while(true)
		{
			System.out.println("1.Add\n2.View\n3.Update\n4.Delete\n5.Exit");
			System.out.print("Enter any one operation:");
			int opt = in.nextInt();
			System.out.println();
			
			switch(opt)
			{
			case 1:
				System.out.println("Enter the below Details:");
				
				System.out.print("Id: ");
				int id = in.nextInt();
				in.nextLine();
				
				System.out.print("Name: ");
				String name = in.nextLine();
				
				System.out.print("Department: ");
				String dept = in.nextLine();
				
				System.out.print("Subjects Marks: ");
				for(int i=0 ; i<5 ; i++)
					marks[i] = in.nextInt();
				
				Student std = new Student(id,name,dept,marks);
				studentDetails.add(std);
				System.out.println("Successfully Added!!");
				break;
				
			case 2 : 
				System.out.println("Students Details are: ");
				for(Student details : studentDetails)
				{
					details.viewDetails();
					System.out.println();
					System.out.println("--------------------------------------------------------------------");
				}
				break;
			
			case 3 :
				System.out.print("Enter the Student Id to Update:");
				int sid = in.nextInt();
				System.out.println();
				
				System.out.println("Which part do you want update?");
				System.out.print("1.Name 2.Dept 3.Marks");
				int change = in.nextInt();
				boolean occur = false;
				
				switch(change)
				{
				case 1 :
					 System.out.print("Enter New Name:");
					 in.nextLine();
					 String newName = in.nextLine();
					 System.out.println();
					 
					 for(Student details : studentDetails)
					 {
						 if(details.id == sid)
						 {
							 details.name = newName;
							 occur = true;
						 }
					 }
					 
					 if(!occur)
						System.out.println("The Student Id is Wrong. Please Enter a valid Id.");
					 else 
					    System.out.println("Updated Successfully!!");
					 break;
					 
				case 2 :
					System.out.print("Enter New Department Name:");
					String newDept = in.next();
					System.out.println();
					
					for(Student details : studentDetails)
					{
						if(details.id == sid)
						{
							details.dept = newDept;
							occur = true;
						}
					}
					
					if(!occur)
						System.out.println("The Student Id is Wrong. Please Enter a valid Id.");
					else 
					    System.out.println("Updated Successfully!!");
					break;
					
				case 3 :
					System.out.print("Enter New Marks:");
					for(Student details : studentDetails)
					{
						if(details.id == sid)
						{
							occur= true;
							for(int i=0 ;i<5 ; i++)
							{
								details.marks[i] = in.nextInt();
							}
						}
					}
					System.out.println();
					if(!occur)
						System.out.println("The Student Id is Wrong. Please Enter a valid Id.");
					else 
					    System.out.println("Updated Successfully!!");
					break;
				
				default :
					System.out.println("Enter valid parts(1.name, 2.dept, 3.marks) to update");
				}
				break;
			
			case 4 :
				System.out.print("Enter the Student Id to Delete: ");
				int sId = in.nextInt();
				boolean removed = false;
				
				System.out.println();
				Iterator<Student> itr = studentDetails.iterator();
				
				while(itr.hasNext())
				{
					Student s = itr.next();
					if(s.id == sId)
					{
						itr.remove();
						removed = true;
						break;
					}
				}
				if(removed)
					System.out.println("The Student details are Successfully Deleted!!");
				else 
					System.out.println("The Student Id is Wrong. Please Enter a valid Id.");
				
			case 5 :
				System.out.println("You are Now Exiting!!!");
				System.exit(0);
				break;
			
			default :
				System.out.println("Invalid Operator");
			}
			
			System.out.println("-------------------------------------------------------");
		}
	}
}
