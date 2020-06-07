import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
 
 
 class library {

	public static void main(String[] args) {
		 Date today=dateInsertion();
		 Scanner sc=new Scanner(System.in);
		 System.out.println("Welcome to the Library");
		 System.out.println("insert library capacity ");
		 System.out.println("max number of books =  ");
	     Books [] booksInLibrary = new Books[sc.nextInt()];  int bookInd=0;
	     System.out.println("max number of users =  ");
	     User [] UsersInLibrary = new User[sc.nextInt()];	int userInd=0; 	
		 User admin=new User();
		 UsersInLibrary[0]=admin;userInd++;
			System.out.println(" insert your name : ");
	        admin.name=sc.nextLine();		
			System.out.println("Welcome  " +admin.name);
			int operation=0;
			while(operation!=-1) {      
			LibraryOpens();
             operation =sc.nextInt();
switch (operation) {
		case 1 : bookInd=admin.insertBook(booksInLibrary,bookInd); break;
		case 2 : admin.borrow(booksInLibrary,today); admin.showBorrowed();break;
		case 3 : admin.returnBook( booksInLibrary);break;
		case 4 : SearchForBook(booksInLibrary);break;
		case 5 : getBook(booksInLibrary).printBook();break;
		case 6 : deleteBookCopy(booksInLibrary);break;
		case 7 : userInd=newUser(UsersInLibrary,userInd);showUsers(UsersInLibrary);break;
		case 8 : showUsers(UsersInLibrary);break;
		case 9 : admin=switchUserTo(admin,UsersInLibrary);break;
		case 10: admin.showBorrowed();break;
		case 11 : admin.ShowCurrentUserName();break;
		case 12 : deleteUser(UsersInLibrary);break;
		case-1 : System.out.println("exit...");System.exit(0);    
}
LibraryAsksToContinueOrNot ();
operation =sc.nextInt();// if operation=-1 it closes /if operation=1 in continues
    }
			
}
	
    public static void LibraryOpens () {
		System.out.println("Which of the following operations would you like to do, press");
		System.out.println("1 for book insertion ");
		System.out.println("2 to borrow a book");
		System.out.println("3 to return a book");
		System.out.println("4 for searching for a particular book");
		System.out.println("5 to display certain book details like "+ "Title,Author,Number of copies ....etc");
		System.out.println("6 to delete a copy of a book");
		System.out.println("7 to insert new user");
		System.out.println("8 to show the users");
		System.out.println("9 to switch user");
		System.out.println("10 to show borrowed books of tha user");
		System.out.println("11 to show current user");
		System.out.println("12 to delete user");
		System.out.println("-1 to exit the program");
	}
    public static void LibraryAsksToContinueOrNot () {

	System.out.println("if you want to close the program press -1");
	System.out.println("if you want to continue press 1");
}
	public static void showLibrary(Books[]booksInLibrary) {
		 for (int i =0;i<booksInLibrary.length&&booksInLibrary[i]!=null;i++)
			 System.out.println(booksInLibrary[i].title);
		
		
	}
	public static void SearchForBook(Books [] booksInLibrary) {
		 Scanner sc=new Scanner(System.in);
	   	 System.out.println("for searching by book title ,press 1");
	   	 System.out.println("for searching by book author ,press 2");
	   	 int key=sc.nextInt();
	   	 switch (key) {
	   	 case 1 : SearchBookByTitle( booksInLibrary);break;
	   	 case 2 : SearchBookByAuthor( booksInLibrary);break; 
	   	 
	   	 }
		
		
	}
    public static void SearchBookByTitle(Books [] booksInLibrary) {
    	Scanner sc=new Scanner(System.in);
    	System.out.println("Enter the title you want to search for");
    	String titleToSearch=sc.nextLine();
    	for(int i =0;i<booksInLibrary.length&&booksInLibrary[i]!=null;i++) {
    		if (booksInLibrary[i].title.equals(titleToSearch)) {
    			System.out.println("The books is available");
    			booksInLibrary[i].printBook();
    			return;	
    	     	}
    	    }
    	System.out.println("The book does not exist");
    	return;
    }
    public static void SearchBookByAuthor(Books [] booksInLibrary) {
    	Scanner sc=new Scanner(System.in);
    	System.out.println("Enter the author'name you want to search for");
    	String authorToSearch=sc.nextLine();
    	boolean found=false;
    	for(int i =0;i<booksInLibrary.length&&booksInLibrary[i]!=null;i++) {
    		if (booksInLibrary[i].author.equals(authorToSearch)) {
    			System.out.println("The books are :");
    			booksInLibrary[i].printBook();
    			System.out.println();
    			System.out.println();
    			found=true;	
    			continue;
    	     	}
    		
    	    }
    	if(found)return;
    	System.out.println("The book of  does not exist");
    	return;
    }
    public static void deleteBookCopy(Books [] booksInLibrary) {
		 Scanner sc=new Scanner(System.in);
		 System.out.println("To get book by title ,press 1");
		 System.out.println("To get book by author ,press 2");
         int key=sc.nextInt();
    	switch (key) {
    	case 1:{
    		
    		int index= getBookByTitle(booksInLibrary).LibraryInd;
    		if(booksInLibrary[index].numOfCopies==0) {
        		System.out.println("No copies to delete");
        		return;
        	}
    		booksInLibrary[index].numOfCopies--;
        	System.out.println("The copy is deleted successfully");
        	System.out.print("the current number of copies is :  ");
        	System.out.println(booksInLibrary[index].numOfCopies);
        	return;
        	
    		
}
    	case 2 :{
    		int index=getBookByAuthor(booksInLibrary).LibraryInd;
    		if(booksInLibrary[index].numOfCopies==0) {
        		System.out.println("No copies to delete");
        		return;
        	}
    		booksInLibrary[index].numOfCopies--;
        	System.out.println("The copy is deleted successfully");
        	System.out.print("the current number of is :  ");
        	System.out.println(booksInLibrary[index].numOfCopies);
        	return;
    	   }
    	}
    }
    public static  Books getBookByTitle(Books [] booksInLibrary) {
		 Scanner sc=new Scanner(System.in);
		 System.out.println("Enter the title of the book");
    	String titleToSearch=sc.nextLine();
    
    	for( int i=0;i<booksInLibrary.length&&booksInLibrary[i]!=null;i++) {
    		if (booksInLibrary[i].title.equals(titleToSearch)) {
    			return booksInLibrary[i];
    	    }
    		
    	 }
    	
    	return null;
     }  
    public static Books getBookByAuthor(Books [] booksInLibrary ) {
    	Scanner sc=new Scanner(System.in);
    	System.out.println("Enter the author's name ");
    	String authorToSearch=sc.nextLine();
    	for(int i =0;i<booksInLibrary.length&&booksInLibrary[i]!=null;i++) {
    		if (booksInLibrary[i].author.equals(authorToSearch)) {
    			return booksInLibrary[i];	
    	    }
    	 }
    	return null;
     }  
    public static Books getBook(Books [] booksInLibrary) {
		 Scanner sc=new Scanner(System.in);
	   	 System.out.println("for searching by book title ,press 1");
	   	 System.out.println("for searching by book author ,press 2");
	   	 int key=sc.nextInt();
	   	 switch (key) {
	   	 case 1 :return getBookByTitle( booksInLibrary);
	   	 case 2 :return getBookByAuthor( booksInLibrary); 
	   	 
	   	 }
		
		return null;
	}
    public static int newUser(User[] UsersInLibrary,int userInd) {
    	Scanner sc=new Scanner (System.in);
    	User user=new User();
    	System.out.println("Enter UserName : ");             user.name=sc.nextLine();
    	UsersInLibrary[userInd]=user;
    	user.userInd=userInd;
    	return ++userInd;
    	
    	
    }
    public static void showUsers(User[] UsersInLibrary) {
    	System.out.println("The users are : ");
    	for(int i =0;i<UsersInLibrary.length;i++) {
    		if(UsersInLibrary[i]==null)continue;
    		else System.out.print(UsersInLibrary[i].name+"      ");
    	}
    	    System.out.println();
    	
    }
    public static User switchUserTo(User admin,User[] UsersInLibrary) {
    	
    	admin=getUser(UsersInLibrary);
    	return admin;
    }
    public static User getUser(User[] UsersInLibrary) {
    	Scanner sc=new Scanner (System.in);
    	showUsers(UsersInLibrary);
    	System.out.println("write the userName you want to get");
    	String givenName=sc.nextLine();
    	for(int i =0 ;i<UsersInLibrary.length&&UsersInLibrary[i]!=null;i++) {
    		if(UsersInLibrary[i].name.equals(givenName))return UsersInLibrary[i]; 
    		
    	}
    	return null;
    }
    public static void deleteUser(User[] UsersInLibrary) {
    	Scanner sc=new Scanner (System.in);
    	showUsers(UsersInLibrary);
    	System.out.println("write the userName you want to delete");
    	String givenName=sc.nextLine();
    	for(int i =0 ;i<UsersInLibrary.length&&UsersInLibrary[i]!=null;i++) {
    		if(UsersInLibrary[i].name.equals(givenName)) {
    			UsersInLibrary[i]=null;
    			System.out.println("deletion succeed");
    			showUsers(UsersInLibrary);
    			break;
    		}
    	}
    
    }
    public static Date dateInsertion() {
		 Scanner sc=new Scanner(System.in);

    	System.out.println(" insert today's date : ");
		Date today=new Date(1,1,2000);
		System.out.println("insert date in this format");
		System.out.println("Day Month Year");
		System.out.println("example :1 1 2000");
		today.Day=sc.nextInt();
		today.Month=sc.nextInt();
		today.Year=sc.nextInt();
		return today;
    	
    }
 
 }

 