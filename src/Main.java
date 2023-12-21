public class Main {


    public static void main(String[] args) {
        Book book1 = new Book("Программирование для новичков Java", "Вася Пупкин", 2019);
        Book book2 = new Book("Программирование Java", "Вася Пупкин", 2019);
        Library library = new Library();
        library.setBooks(book1);
        library.setBooks(book2);
    User user = new User("darth");
    user.setTakeBooks(library.getBooks("Программирование Java"));
    user.setTakeBooks(library.getBooks("Программирование Java"));
        user.print();


    Bank bank = new Bank(10);

    Client client1 = new Client("John", "Address 1", 2);
    Client client2 = new Client("Alice", "Address 2", 1);

    Score score1Client1 = new Score(1, 500, "Initial balance: 500");
    Score score2Client1 = new Score(2, 1000, "Initial balance: 1000");
    Score score1Client2 = new Score(3, 300, "Initial balance: 300");

   client1.setScores(0, score1Client1);
        client2.setScores(0, score1Client2);
        bank.addClient(client1);
        bank.addClient(client2);


    ManagementTask taskManager = new ManagementTask();

        taskManager.createTask("Task 1", "Description for Task 1", false);
        taskManager.createTask("Task 2", "Description for Task 2", true);
         taskManager.createTask("Task 3", "Description for Task 3", false);

        taskManager.getTasks()[0].setAssignedUser("User1");
        taskManager.getTasks()[1].setAssignedUser("User2");
        taskManager.getTasks()[2].setAssignedUser("User1");

       taskManager.printUserTasks("User1");


    Inventory inventory = new Inventory();


    Item item1 = new Item("Товар 1", 5, 100, "Склад A");
    Item item2 = new Item("Товар 2", 10, 200, "Склад B");
          inventory.addItem(item1);
        inventory.addItem(item2);

    Storage storageA = new Storage("Склад A", 50);
    Storage storageB = new Storage("Склад B", 30);
        inventory.addStorage(storageA);
         inventory.addStorage(storageB);


         for (Storage storage : inventory.getStorages()) {
         if (storage != null) {
             inventory.printItemsInStorage(storage);
         }
       }

    ManagementStudent management = new ManagementStudent(10); // Создание экземпляра класса

    Student student1 = new Student("Иван", "Петров", 101, "Math");
    Student student2 = new Student("Мария", "Иванова", 102, "Biology");
    Student student3 = new Student("Петр", "Сидоров", 101, "Math");

         management.addStudentToCourse("Math", student1);
        management.addStudentToCourse("Biology", student2);
        management.addStudentToCourse("Math", student3);

         management.printStudentsOnCourse("Math");
         management.printStudentsOnCourse("Biology");

         management.removeStudentFromCourse("Math", student1);

         management.printStudentsOnCourse("Math");
}
}
