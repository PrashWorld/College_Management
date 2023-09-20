
//Interface for common behavior - teach for teacher
interface teach{
    void teacherTeach();
}
public class Teacher implements teach {    //implements teach interface
    private String name;
    private String teacherId;
    private int age;
    private String address;

    public Teacher(String name, String teacherId, int age, String address) {
        this.name = name;
        this.teacherId= teacherId;
        this.age = age;
        this.address = address;
    }

    //Method Overloading - compiletime polymorphism
    public void displayInformation(){
        System.out.println("Teacher name is:"+this.name);
    }
    public void displayInformation(int age) {
        if (age == this.age) {
            System.out.println("Teacher age is:" + age);
        }else{
            System.out.println("Age is invalid as per records for the Teacher");
        }
    }
    //Method Overriding - runtime polymorphism
    public void displayAddressAndId(String teacherId,String address){
        System.out.println("Teacher "+this.name+" with ID:"+teacherId+" lives at Address: "+address);
    }

    public void teacherTeach(){   //interfaceMethod
        System.out.printf("%s %s-> is teaching",this.getClass().getSimpleName(),this.name);  //using this.getClass().getSimpleName()- to know which class is executing
    }

    public String getName() {    //getterMethod
        return name;
    }

    //Checking if teacher is qualified to teach a course
    //Assumption-Only Professor can teach Advanced Courses, and only assistant can teach introductoryCourses
    public boolean qualifiedToTeach(String courseType){
        String teacherType= this.getClass().getSimpleName();
        if(courseType.equals("advancedCourse") && teacherType.equals("Professor")){
            return true;
        }else if(courseType.equals("introductoryCourse") && teacherType.equals("Assistant")){
            return true;
        }
        return false;
    }
    public String getTeacherId() {
        return teacherId;
    }
}

class Professor extends Teacher{

    public Professor(String name, String teacherId, int age, String address) {
        super(name, teacherId, age, address);
    }

    @Override
    public void displayAddressAndId(String teacherId, String address) {
        //System.out.println("Teacher with ID:"+teacherId+" lives at Address: "+address); //we can also print here but will use super
        super.displayAddressAndId(teacherId, address);  //using super for calling method of super class
    }

    @Override
    public void teacherTeach() {
        super.teacherTeach();
    }
}

class Assistant extends Teacher{

    public Assistant(String name, String teacherId, int age, String address) {
        super(name, teacherId, age, address);
    }
    @Override
    public void teacherTeach() {
        super.teacherTeach();
    }
}
