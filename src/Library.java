 class Library {
private Book[] books = new Book[10];
     private int len;

     public Book getBooks(String name) {
         for (int i = 0; i < len; i++) {
             if (name == books[i].getName()){
                 if (books[i].isTaken()){
                     System.out.println("Книжка уже взята");
                     return null;
                 }
                 System.out.println("Книга: " + books[i].getName() + " была взята");
                 books[i].setTaken(true);
                 return   books[i];
             }
         }
         return null;
     }

     public void setBooks(Book book) {
         book.setTaken(false);
         books[len]= book;
         len++;
     }
 }
 class Book {
     private String name;
     private  String creatorName;
     private int creationYear;
     private  boolean isTaken;

     public String getName() {

         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     public String getCreatorName() {
         return creatorName;
     }

     public void setCreatorName(String creatorName) {
         this.creatorName = creatorName;
     }

     public int getCreationYear() {
         return creationYear;
     }

     public void setCreationYear(int creationYear) {
         this.creationYear = creationYear;
     }

     public boolean isTaken() {
         return isTaken;
     }

     public Book(String name, String creatorName, int creationYear) {
         this.name = name;
         this.creatorName = creatorName;
         this.creationYear = creationYear;
         this.isTaken = false;
     }

     public void setTaken(boolean isTaken) {
         this.isTaken = isTaken;
     }

     public boolean isAvailable() {
         return !isTaken;
     }
 }

 class User{
     private String name;
    private String adress;
     private Book[] takeBooks = new Book[10];
    private  int len;

     public User(String name) {
         this.name = name;
     }

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     public String getAdress() {
         return adress;
     }

     public void setAdress(String adress) {
         this.adress = adress;
     }


     public Book getTakeBooks(String name) {
         for (int i = 0; i < len; i++) {
             if (name == takeBooks[i].getName()){
                 return   takeBooks[i];
             }
         }
         return null;
     }

     public void setTakeBooks(Book takeBook) {
         if (takeBook == null){
             return;
         }
        takeBooks[len]= takeBook;
        len++;
     }
     public void print(){
         System.out.println("ученик взял книги: " + name );
         for (int i = 0; i < len; i++) {
             System.out.println(takeBooks[i].getName());
         }
     }
 }
