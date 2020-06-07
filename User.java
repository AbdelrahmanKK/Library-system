import java.util.Scanner;

class User {
	 String name;  
	 Books []borrowed=new Books [100];
     int borrowInd;
     int userInd;
	 
	 int insertBook(Books [] booksInLibrary,int index) {
		 Scanner sc=new Scanner (System.in);
		 Books book=new Books();
		 
		 System.out.println("The book's title : ");             book.title=sc.nextLine();
		 System.out.println("The book's author : ");            book.author=sc.nextLine();
		 System.out.println("Date of publish : ");              PublishDateInsertion(book);
		 System.out.println("number of copies available : ");   book.numOfCopies=sc.nextInt();
		 book.LibraryInd=index;
	     booksInLibrary[index]=book;	 
	     System.out.println("'"+book.title+"'"+"  successfully inserted to the library");
	     return ++index;
	}	 
	 void borrow(Books[] booksInLibrary,Date today){
		 Scanner sc=new Scanner(System.in);
		 System.out.println("which of the following books do you want to borrow...");
		
		 for (int i =0;i<booksInLibrary.length&&booksInLibrary[i]!=null;i++) {   //printing the books
	         System.out.println(booksInLibrary[i].title);
	      }
     
		 String wantToBorrow = sc.nextLine();
		
		 for (int i =0;i<booksInLibrary.length&&booksInLibrary[i]!=null;i++) {   
	       if(booksInLibrary[i].title.equals(wantToBorrow)&&booksInLibrary[i].numOfCopies>0) {
	    	   this.borrowed[this.borrowInd]=booksInLibrary[i];
	    	   this.borrowInd++;
	    	   booksInLibrary[i].numOfCopies--;
	    	   System.out.println("'"+this.borrowed[borrowInd-1].title + "'"+"  is successfully borrowed to "+this.name);
	    	   System.out.println("You're suppose to return the book before  ");
	    	   today.dateAfterDays(15).printDate();
	           return;
	      }
	   }
		 System.out.println("the book is not available");
	 }
	 void showBorrowed() {
		System.out.println("Your borrowed books are :");
		 for (int i =0;i<this.borrowed.length&&this.borrowed[i]!=null;i++) {  
	         System.out.println(this.borrowed[i].title);
  }
}
	 public void returnBook(Books [] booksInLibrary) {
		 Scanner sc=new Scanner(System.in);
		 System.out.println("which of the following books do you want to return...");
		 this.showBorrowed();
		 String wantToRetrun=sc.nextLine();
		 for (int i =0;i<this.borrowed.length&&this.borrowed[i]!=null;i++)
	     if(this.borrowed[i].title.equals(wantToRetrun)) {
	    	 booksInLibrary[this.borrowed[i].LibraryInd].numOfCopies++;
		     this.borrowed[i]=null;
		     return;
	     }
	}
	 public static void PublishDateInsertion(Books book) {
			Date date=new Date();
			Scanner sc=new Scanner(System.in);
			System.out.println("insert date in this format");
			System.out.println("Day Month Year");
			System.out.println("example :1 1 2000");
			date.Day=sc.nextInt();
			date.Month=sc.nextInt();
			date.Year=sc.nextInt();
			book.publishDate=date;
			
			
		}
     public void ShowCurrentUserName() {
    	 
    	 System.out.println(this.name);
     }
}


