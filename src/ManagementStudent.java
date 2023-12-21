public class ManagementStudent {
    private Course[] courses;
    private int courseCount;

    public Course[] getCourses() {
        return courses;
    }

    public void setCourses(Course[] courses) {
        this.courses = courses;
    }

    public int getCourseCount() {
        return courseCount;
    }

    public void setCourseCount(int courseCount) {
        this.courseCount = courseCount;
    }

    public ManagementStudent(int maxCourses) {
        this.courses = new Course[maxCourses];
        this.courseCount = 0;
    }

    public void addStudentToCourse(String courseName, Student student) {
        for (int i = 0; i < courseCount; i++) {
            if (courses[i].getUsers_name().equals(courseName)) {
                String students = courses[i].getListStudent();
                students += (students.isEmpty() ? "" : ", ") + student.getName() + " " + student.getSurname();
                courses[i].setListStudent(students);
                return;
            }
        }

        Course newCourse = new Course(courseName, student.getName() + " " + student.getSurname());
        courses[courseCount] = newCourse;
        courseCount++;
    }

    public void removeStudentFromCourse(String courseName, Student student) {
        for (int i = 0; i < courseCount; i++) {
            if (courses[i].getUsers_name().equals(courseName)) {
                String students = courses[i].getListStudent();
                students = students.replace(student.getName() + " " + student.getSurname(), "").replaceFirst(", $", "");
                courses[i].setListStudent(students);
                return;
            }
        }

        System.out.println("Курс не знайдено.");
    }

    public void printStudentsOnCourse(String courseName) {
        for (int i = 0; i < courseCount; i++) {
            if (courses[i].getUsers_name().equals(courseName)) {
                System.out.println("Студенти на курсі " + courseName + ": " + courses[i].getListStudent());
                return;
            }
        }

        System.out.println("Курс не знайдено.");
    }
}

class Student {
    private String name;
    private String surname;
    private int numberGroup;
    private String listCourses;

    public Student(String name, String surname, int numberGroup, String listCourses) {
        this.name = name;
        this.surname = surname;
        this.numberGroup = numberGroup;
        this.listCourses = listCourses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getNumberGroup() {
        return numberGroup;
    }

    public void setNumberGroup(int numberGroup) {
        this.numberGroup = numberGroup;
    }

    public String getListCourses() {
        return listCourses;
    }

    public void setListCourses(String listCourses) {
        this.listCourses = listCourses;
    }
}

class Course {
    private String users_name;
    private String listStudent;

    public Course(String users_name, String listStudent) {
        this.users_name = users_name;
        this.listStudent = listStudent;
    }

    public String getUsers_name() {
        return users_name;
    }

    public void setUsers_name(String users_name) {
        this.users_name = users_name;
    }

    public String getListStudent() {
        return listStudent;
    }

    public void setListStudent(String listStudent) {
        this.listStudent = listStudent;
    }

    public String getCourseName() {
        return users_name;
    }
}
