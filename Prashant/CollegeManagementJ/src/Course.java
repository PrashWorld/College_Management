import java.util.ArrayList;
import java.util.List;

public class Course {
    //private modifiers to implement encapsulation
   private String courseCode;
   private String name;
   private int maximumCapacity;
   private int initialEnrollment;
   private String courseType;   //advanced or introductory
   private List<Student> studentEnrolled=new ArrayList<>();  //list of students enrolled in course
   private List<Teacher> teacherAssigned=new ArrayList<>();  //list of teachers assigned to a particular course

    public Course(String courseCode, String name, int maximumCapacity,String courseType) {
        this.courseCode = courseCode;
        this.name = name;
        this.maximumCapacity = maximumCapacity;
        this.courseType=courseType;
        this.initialEnrollment=0;
    }

    //getter and setter methods
    public String getCourseCode() {
        return courseCode;
    }
    public String getName() {
        return name;
    }

    public int getMaximumCapacity() {
        return maximumCapacity;
    }
    public String getCourseType() {
        return courseType;
    }
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setMaximumCapacity(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
    }
    public List<Student> getStudentEnrolled() {
        return studentEnrolled;
    }
    public List<Teacher> getTeacherAssigned() {
        return teacherAssigned;
    }

    //method- enrollStudent()- for enrolling students in courses
    public void enrollStudent(Student student){
         System.out.println(initialEnrollment);

        try {  // Checking course capacity using if-else and Error handling using try and catch block
            if (initialEnrollment < maximumCapacity) {
                studentEnrolled.add(student);
                System.out.println("The student "+student.getName()+ " enrolled in course: "+name);
                initialEnrollment++;
            } else {
                throw new Exception("No more enrollments...");
            }
        }
        catch(Exception e){
                System.out.println("The course "+this.name+" is full."+e.getMessage());
        }
    }

    //Teacher Assignment
    public void assignTeacher(Teacher teacher){
              if(teacher.qualifiedToTeach(courseType)){
                  teacherAssigned.add(teacher);
                  System.out.println("The teacher "+teacher.getName()+" is assigned to teach the course "+name);
              }else{
                  System.out.println("The teacher "+teacher.getName()+" is not qualified to teach the course "+name);
              }
    }

    public void displayStudentEnrolled(){
        System.out.println("Students enrolled in "+this.name+" course");
                  //If no student enrolled
                 if (studentEnrolled.isEmpty()) {
                     System.out.println("No student enrolled yet");
                 }else{
                     for(Student student: studentEnrolled) {
                         System.out.println(student.getName() + " " + student.getStudentId());
                     }
                 }


    }

    public void displayTeacherAssigned(){
        System.out.println("Teachers assigned to teach "+this.name+" course");
        if (teacherAssigned.isEmpty()) {
            System.out.println("No teacher assigned yet");
        }else{
            for(Teacher teacher: teacherAssigned) {
                System.out.println(teacher.getName() + " " + teacher.getTeacherId());
            }
        }
    }
}
