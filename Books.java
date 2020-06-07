
public class Books {
 String title;
 String author;
 Date publishDate;
 int numOfCopies;
 int LibraryInd; //each book has an index in the array of books of the library

 public void printBook() {
	 
	 System.out.println("Title : "+this.title);
	 System.out.println("Author : "+this.author);
	 System.out.print("PublishDate : ");	this.publishDate.printDate(); 
	 System.out.println("Number of copies available : "+ this.numOfCopies);
	
	 
 }
 
 
 
}