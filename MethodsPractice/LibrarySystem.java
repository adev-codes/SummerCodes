import java.util.*;
public class LibrarySystem{
    static int totalBooks;
    static int totalLibraries;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library l1 = new Library("Ayesha", "Karachi");

        while (true) {
            System.out.println("\n===== Library Menu =====");
            System.out.println("1. Add Book");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Display Books");
            System.out.println("5. Show Stats");
            System.out.println("6. Remove Book");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter author: ");
                    String author = sc.nextLine();
                    System.out.print("Enter ISBN: ");
                    int isbn = sc.nextInt();
                    sc.nextLine();
                    l1.addBook(new Book(title, author, isbn));
                    break;

                case 2:
                    System.out.print("Enter ISBN to issue: ");
                    int issueIsbn = sc.nextInt();
                    sc.nextLine();
                    l1.issueBook(issueIsbn);
                    break;

                case 3:
                    System.out.print("Enter ISBN to return: ");
                    int returnIsbn = sc.nextInt();
                    sc.nextLine();
                    l1.returnBook(returnIsbn);
                    break;

                case 4:
                    l1.displayBooks();
                    break;

                case 5:
                    System.out.println("Total Books in System: " + totalBooks);
                    System.out.println("Total Libraries: " + totalLibraries);
                    break;
                
                case 6:
                     System.out.print("Enter ISBN to remove: ");
                     int removeIsbn = sc.nextInt();
                     sc.nextLine();
                     l1.removeBook(removeIsbn);
                     break;
                case 7:
                    System.out.println("Exiting Library System...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option! Try again.");
            }
        }
    }
}


class Book{
      private String title;
      private String author;
      private int ISBN;
      private boolean isAvailable;

      public Book(String t,String a , int ISBN){
           this.title = t;
           this.author = a;
           this.ISBN = ISBN;
           this.isAvailable = true;
           
      }

      public String getTitle(){
        return title;
      }
      public String getAuthor(){
        return author;
      }
      public int getISBN(){
        return ISBN;
      }
      public boolean getStatus(){
        return isAvailable;
      }

      public void setTitle(String t){
        this.title = t;
      }
      public void setAuthor(String a){
        this.author = a;
      }
      public void setISBN(int isbn){
        this.ISBN = isbn;
      }
      public void setStatus(boolean s){
        this.isAvailable = s;
      }
      
      

}

class Library{
    String librarian;
    String location;
    ArrayList<Book> books = new ArrayList<>();

    public Library(String l,String loc){
        this.librarian = l;
        this.location = loc;
        LibrarySystem.totalLibraries++;
        
    }

    public String getLibrarian(){
        return librarian;
    }
    public String getLocation(){
        return location;
    }

    public void setLibrarian(String l){
        this.librarian = l;
    }
    public void setLocation(String loc){
        this.location = loc;
    }

    public void addBook(Book b){
        books.add(b);
        System.out.println("Book \""+b.getTitle()+"\" by "+b.getAuthor()+" added to the library.");
        LibrarySystem.totalBooks++;
    }

    public void removeBook(int isbn) {
    for (Book b : books) {
        if (b.getISBN() == isbn) {
            books.remove(b);
            LibrarySystem.totalBooks--; // decrease totalBooks
            System.out.println("Book \"" + b.getTitle() + "\" removed from the library.");
            return;
        }
    }
    System.out.println("Book with ISBN " + isbn + " not found in this library.");
}


    public void issueBook(int isbn){
       for(Book b:books){
        if(b.getISBN() == isbn){
            if(b.getStatus()){
            System.out.println("Book \""+b.getTitle()+"\" issued!");
            b.setStatus(false);}
            else{
                System.out.println("Book already issued.");
            }
            return;
        }
       }
       System.out.println("Book not found!");
    }

    public void returnBook(int isbn){
        for(Book b:books){
            if(b.getISBN() == isbn){
                if(!b.getStatus()){
                    b.setStatus(true);
                    System.out.println("Book returned successfully.");
                }
                else{
                    System.out.println("This book was not issued.");
                }
                return;
            } 
        }
         System.out.println("Book not found in this library.");
    }


    public void displayBooks(){
    if(books.isEmpty()){
        System.out.println("No books in the library yet.");
        return;
    }
    System.out.println("\nBooks in Library ("+location+"):");
    for(Book b : books){
        System.out.println("- " + b.getTitle() + " by " + b.getAuthor() 
                           + " | ISBN: " + b.getISBN() 
                           + " | Available: " + (b.getStatus() ? "Yes" : "No"));
    }
}


}