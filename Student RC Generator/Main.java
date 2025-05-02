import java.util.ArrayList;
import java.util.List;

class Student {
    private String name;
    private String standard;
    private int rollNo;

    Student(String name, String standard, int rollNo) {
        this.name = name;
        this.standard = standard;
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public String getStandard() {
        return standard;
    }

    public int getRollNo() {
        return rollNo;
    }
}

class Marks extends Student {
    private int sst;
    private int maths;
    private int hindi;
    private int science;
    private int english;
    private int sanskrit;

    public Marks(String name, String standard, int rollNo, int english, int maths, int science, int sst, int sanskrit,
            int hindi) {
        super(name, standard, rollNo);
        this.sst = sst;
        this.maths = maths;
        this.hindi = hindi;
        this.english = english;
        this.science = science;
        this.sanskrit = sanskrit;
        StudentsList.addStudent(this);
    }

    public int getEnglish() {
        return english;
    }

    public int getMaths() {
        return maths;
    }

    public int getScience() {
        return science;
    }

    public int getSst() {
        return sst;
    }

    public int getSanskrit() {
        return sanskrit;
    }

    public int getHindi() {
        return hindi;
    }

}

class StudentsList {
    private static List<Student> studentList = new ArrayList<>();

    public static void addStudent(Student student) {
        studentList.add(student);
    }

    public static void printStudentList() {
        for (Student stud : studentList) {
            System.out.println("Name : " + stud.getName());
            System.out.println("Roll No : " + stud.getRollNo());
            System.out.println("Standard : " + stud.getStandard());
            // DownCasting
            if (stud instanceof Marks) {
                Marks m = (Marks) stud;
                System.out.println("English : " + m.getEnglish());
                System.out.println("Maths : " + m.getMaths());
                System.out.println("Science : " + m.getScience());
                System.out.println("SST : " + m.getSst());
                System.out.println("Sanskrit : " + m.getSanskrit());
                System.out.println("Hindi : " + m.getHindi());
            }

        }
    }
}

public class Main {
    public static void main(String[] args) {
        new Marks("Rahul", "10th", 1, 85, 90, 88, 80, 75, 89);
        new Marks("Anjali", "10th", 2, 78, 85, 92, 76, 80, 81);

        StudentsList.printStudentList();
    }
}
