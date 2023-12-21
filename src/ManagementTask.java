public class ManagementTask {
    private Task[] tasks;
    private int size;

    public Task[] getTasks() {
        return tasks;
    }



    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    private static final int DEFAULT_CAPACITY = 10;

    public ManagementTask() {
        this.tasks = new Task[DEFAULT_CAPACITY];
        this.size = 0;
    }

    private void increaseCapacity() {
        Task[] newTasks = new Task[tasks.length * 2];
        System.arraycopy(tasks, 0, newTasks, 0, tasks.length);
        tasks = newTasks;
    }
    public void createTask(String name, String description, boolean status) {
        if (size >= tasks.length) {
            increaseCapacity();
        }
        Task newTask = new Task(name, description, status);
        tasks[size] = newTask;
        size++;
    }
    public void printUserTasks(String userName) {
        for (Task task : tasks) {
            if (task != null && task.getAssignedUser() != null && task.getAssignedUser().equals(userName)) {
                System.out.println("Task Name: " + task.getName());
                System.out.println("Description: " + task.getDescription());
                System.out.println("Status: " + (task.isStatus() ? "Completed" : "Incomplete"));
                System.out.println();
            }
        }
    }



    public void editTask(int index, String name, String description, boolean status) {
        if (index >= 0 && index < size) {
            Task taskToEdit = tasks[index];
            taskToEdit.setName(name);
            taskToEdit.setDescription(description);
            taskToEdit.setStatus(status);
        } else {
            System.out.println("Недопустимий індекс для редагування завдання.");
        }
    }

    public void deleteTask(int index) {
        if (index >= 0 && index < size) {
            for (int i = index; i < size - 1; i++) {
                tasks[i] = tasks[i + 1];
            }
            tasks[size - 1] = null;
            size--;
        } else {
            System.out.println("Недопустимий індекс для видалення завдання.");
        }

    }
}
class Task{
    private String name;
    private String description;
    private boolean status;
    private String assignedUser;
    public Task(String name, String description, boolean status) {
        this.name = name;
        this.description = description;
        this.status = status;
    }
    public String getAssignedUser() {
        return assignedUser;
    }

    public void setAssignedUser(String assignedUser) {
        this.assignedUser = assignedUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
class UserTask {
   private String name;
   private int listTask;

    public UserTask(String name, int listTask) {
        this.name = name;
        this.listTask = listTask;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getListTask() {
        return listTask;
    }

    public void setListTask(int listTask) {
        this.listTask = listTask;
    }
}