import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Student> studentList = new ArrayList<>();
    private static List<Teacher> teacherList = new ArrayList<>();
    private static List<Course>  courseList  = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println("**Student and Teacher Management:**");
        System.out.println();
        //List<Student> studentList = new ArrayList<>();
        //BaseClass- Student
        Student student = new Student("Prashant", "A01", 22, "Aligarh UP");
        studentList.add(student);
        student.displayInformation();
        student.displayInformation(22);
        student.displayAddressAndId("A01", "Aligarh UP");
        student.studentStudy();

        System.out.println("-".repeat(25));

        Student student1 = new UnderGraduate("Anmol", "A02", 25, "Meerut UP");
        studentList.add(student1);
        student1.displayInformation();
        student1.displayInformation(25);
        student1.displayAddressAndId("A02", "Meerut UP");
        student1.studentStudy();

        System.out.println("-".repeat(25));

        Student student2 = new PostGraduate("Alok", "A03", 26, "Bengaluru");
        studentList.add(student2);
        student2.displayInformation();
        student2.displayInformation(26);
        student2.displayAddressAndId("A03", "Bengaluru");
        student2.studentStudy();
        System.out.println("-".repeat(25));

        //List<Teacher> teacherList = new ArrayList<>();
        Teacher teacher = new Teacher("Anup Tiwari", "T01", 44, "Jaipur Rajasthan");
        teacherList.add(teacher);
        teacher.displayInformation();
        teacher.displayInformation(44);
        teacher.displayAddressAndId("T01", "Jaipur Rajasthan");
        teacher.teacherTeach();
        System.out.println();
        System.out.println("-".repeat(25));

        Teacher teacher1 = new Professor("Vishwajeet", "T02", 55, "Patna Bihar");
        teacherList.add(teacher1);
        teacher1.displayInformation();
        teacher1.displayInformation(55);
        teacher1.displayAddressAndId("T02", "Patna Bihar");
        teacher1.teacherTeach();
        System.out.println();
        System.out.println("-".repeat(25));

        Teacher teacher2 = new Assistant("Pankaj Tripathi", "T03", 38, "Bhopal MP");
        teacherList.add(teacher2);
        teacher2.displayInformation();
        teacher2.displayInformation(38);
        teacher2.displayAddressAndId("T03", "Bhopal MP");
        teacher2.teacherTeach();
        System.out.println();
        System.out.println("-".repeat(25));

        System.out.println("**Course Management**");

//        List<Course> courseList = new ArrayList<>();
        Course course1 = new Course("C51", "NeuralNetwork", 2, "advancedCourse");
        courseList.add(course1);
        Course course2 = new Course("C61", "DSA", 40, "introductoryCourse");
        courseList.add(course2);
        Course course3 = new Course("C71", "OperatingSystems", 35, "advancedCourse");
        courseList.add(course3);
        Course course4 = new Course("C71", "Network Security", 35, "introductoryCourse");
        courseList.add(course4);
        System.out.println(course1.getCourseCode());
        System.out.println(course1.getName());
        System.out.println(course1.getMaximumCapacity());
        course2.setMaximumCapacity(35);
        System.out.println(course2.getMaximumCapacity());

        System.out.println("*Student Enrollment:");

        course1.enrollStudent(student);
        course2.enrollStudent(student1);
        course1.enrollStudent(student2);
        course1.enrollStudent(student1);//error-capacity full
        course2.enrollStudent(student);

        System.out.println("**Teacher Assignment:**");

        course1.assignTeacher(teacher1);
        course1.assignTeacher(teacher2);  //Teacher not qualified to teach
        course4.assignTeacher(teacher2);
        course4.assignTeacher(teacher1);  ///Teacher not qualified to teach - IntroCourse-Professor

        //**Information Display:**;
        informationDisplay();
        Scanner s = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            switch (s.nextInt()) {
                case 1:
                    displayStudentList(studentList);
                    break;
                case 2:
                    displayTeacherList(teacherList);
                    break;
                case 3:
                    displayCourseList(courseList);
                    break;
                default:
                    System.out.println("Not a valid command");
                    flag = false;
                    break;
            }
        }

        //**Menu System:**";
        printActions();
        Scanner scanner = new Scanner(System.in);
        boolean temp = true;
        while (temp) {
            switch (scanner.nextInt()) {
                case 1:
                    studentEnrollment();
                    break;
                case 2:
                    teacherAssignment();
                    break;
                case 3:
                    displayInformation();
                    break;
                default:
                    System.out.println("Not a valid input");
                    temp = false;
            }
        }

    }
    private static void informationDisplay() {

        String textBlock = """
                **Information Display:**
                                
                1 - Display StudentList
                                
                2 - Display TeacherList
                                
                3 - Display CourseList
                                
                Enter a number for which action you want to do:""";
        System.out.print(textBlock + " ");
    }
    public static void displayStudentList(List<Student> studentList) {
        for (Student student :
                studentList) {
            System.out.println(student.getName() + " " + student.getStudentId());

        }
    }

    public static void displayTeacherList(List<Teacher> teacherList) {
        for (Teacher teacher :
                teacherList) {
            System.out.println(teacher.getName() + " " + teacher.getTeacherId());
        }
    }

    public static void displayCourseList(List<Course> courseList) {
        for (Course course :
                courseList) {
            System.out.println(course.getName() + " " + course.getCourseType());
        }
    }
    private static void printActions() {

        String textBlock = """
                **Menu System:**
                            
                1 - to enroll Student
                                
                2 - to assign Teacher
                                
                3 - to display information
                                
                Enter a number for which action you want to do:""";
        System.out.print(textBlock + " ");
    }

    public static void studentEnrollment() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the Name of the Student");
            String name = scanner.nextLine();
            System.out.println("Enter the StudentId of the Student");
            String studentId = scanner.nextLine();
            System.out.println("Enter the Address of the Student");
            String address = scanner.nextLine();
            System.out.println("Enter the Age of the Student");
            int age = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Is Student UnderGraduate or PostGraduate?");
            String studentType = scanner.nextLine();
            System.out.println(studentType);
            Student student;
            if (studentType.equals("UnderGraduate")) {
                student = new UnderGraduate(name, studentId, age, address);
                studentList.add(student);
            } else if (studentType.equals("PostGraduate")) {
                student = new PostGraduate(name, studentId, age, address);
                studentList.add(student);
            } else {
                throw new Exception("Student can't be enrolled!!!  ");
            }
            System.out.println("Select the course for Enrollment: 1. Course1 , 2. Course2 ,3. Course3 ,4. Course4 ,5. Exit");
            boolean temp = true;
            Course course = null;
            while (temp) {
                switch (scanner.nextInt()) {
                    case 1:
                        course = courseList.get(0);
                        course.enrollStudent(student);
                        break;
                    case 2:
                        course = courseList.get(1);
                        course.enrollStudent(student);
                        break;
                    case 3:
                        course = courseList.get(2);
                        course.enrollStudent(student);
                        break;
                    default:
                        System.out.println("Enrolled successfully");
                        temp = false;
                }
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void teacherAssignment() {
       try {
           Scanner t = new Scanner(System.in);
           System.out.println("Enter the Name of the Teacher");
           String name = t.nextLine();
           System.out.println("Enter the teacherId of the Teacher");
           String teacherId = t.nextLine();
           System.out.println("Enter the Address of the Teacher");
           String address = t.nextLine();
           System.out.println("Enter the Age of the Teacher");
           int age = t.nextInt();
           t.nextLine();
           System.out.println("Is Teacher Professor or Assistant?");
           String teacherType = t.nextLine();
           Teacher teacher = null;
           if (teacherType.equals("Professor")) {
               teacher = new Professor(name, teacherId, age, address);
               teacherList.add(teacher);
           } else if (teacherType.equals("Assistant")) {
               teacher = new Assistant(name, teacherId, age, address);
               teacherList.add(teacher);
           } else {
               throw new Exception("Teacher is neither Assistant nor Professor");
           }
           System.out.println("Select the course for Assignment to Teacher: 1. Course1 , 2. Course2 ,3. Course3 ,4. Course4 ,5. Exit");
           boolean temp = true;
           Course course = null;
           while (temp) {
               switch (t.nextInt()) {
                   case 1:
                       course = courseList.get(0);
                       course.assignTeacher(teacher);
                       break;
                   case 2:
                       course = courseList.get(1);
                       course.assignTeacher(teacher);
                       break;
                   case 3:
                       course = courseList.get(2);
                       course.assignTeacher(teacher);
                       break;
                   case 4:
                       course = courseList.get(3);
                       course.assignTeacher(teacher);
                       break;
                   default:
                       System.out.println("Teacher assigned successfully");
                       temp = false;
               }
           }
       }catch (Exception e){
           System.out.println(e.getMessage());
       }
    }

    public static void displayInformation() {
        System.out.println("Enter 1 for StudentEnrolledInfo, 2 for TeacherAssignedInfo, 3 for CourseInfo, 4 for exit");
        Scanner i = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            switch (i.nextInt()) {
                case 1:
                    for (Course course:
                         courseList) {
                        course.displayStudentEnrolled();
                    }
                    break;
                case 2:
                    for (Course course:
                            courseList) {
                        course.displayTeacherAssigned();
                    }
                    break;
                case 3:
                    displayCourseList(courseList);
                    break;
                default:
                    System.out.println("Not a valid command for Course Info,Press 1 - to enroll Student, 2 - to assign Teacher");
                    flag = false;
                    break;
            }
        }
    }
}