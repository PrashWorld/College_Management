
//Interface for common behavior - study for student
interface study{
    void studentStudy();
}

public class Student implements study{   //implements study interface
    private String name;
    private String studentId;
    private int age;
    private String address;

    public Student(String name, String studentId, int age, String address) {
        this.name = name;
        this.studentId = studentId;
        this.age = age;
        this.address = address;

    }
    //MethodOverloading- CompileTime Polymorphism in Student Class
    public void displayInformation(){
        System.out.println("Student name is:"+this.name);
    }
    public void displayInformation(int age){
        if (age == this.age) {
            System.out.println("Student age is:"+ age);
        }else{
            System.out.println("Age is invalid as per records for The Student");
    }
    }
    //MethodOverriding - RunTime polymorphism
    public void displayAddressAndId(String studentId,String address){
        System.out.println( this.name+" having ID:"+studentId+" lives at Address: "+address);
    }

    public void studentStudy(){  //interface method
        System.out.println("Student of BaseClass "+this.name+" is studying");
    }

    public String getName() {
        return name;
    }

    public String getStudentId() {
        return studentId;
    }
}

class UnderGraduate extends Student{

    public UnderGraduate(String name, String studentId, int age, String address) {
        super(name, studentId, age, address);
    }

   //Method overriding- RunTime polymorphism
    public void displayAddressAndId(String studentId,String address){
        System.out.println("UnderGrad Student "+this.getName()+" having ID:"+studentId+" lives at Address: "+address);
    }
    @Override
    public void studentStudy(){
        System.out.println("Student->UnderGrad(subclass) "+this.getName()+" is studying");
    }
}

class PostGraduate extends Student{

    public PostGraduate(String name, String studentId, int age, String address) {
        super(name, studentId, age, address);
    }
//Method overriding
    @Override
    public void studentStudy(){
        System.out.println("Student->PostGrad(subclass) "+this.getName()+" is studying\"");
    }
}
