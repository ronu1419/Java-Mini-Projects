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

    @Override
    public String toString() {
        return "Name : " + name + "\nRoll No : " + rollNo + "\nStandard : " + standard;
    }
}

class Marks extends Student {
    private int sst, maths, hindi, science, english, sanskrit;

    public Marks(String name, String standard, int rollNo, int english, int maths, int science, int sst, int sanskrit,
            int hindi) {
        super(name, standard, rollNo);
        this.sst = sst;
        this.maths = maths;
        this.hindi = hindi;
        this.english = english;
        this.science = science;
        this.sanskrit = sanskrit;
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

    @Override
    public String toString() {
        return super.toString() +
                "\nEnglish : " + english +
                "\nMaths : " + maths +
                "\nScience : " + science +
                "\nSST : " + sst +
                "\nSanskrit : " + sanskrit +
                "\nHindi : " + hindi;
    }

}

class StudentsList {
    private static List<Student> studentList = new ArrayList<>();

    public static void addStudent(Student student) {
        studentList.add(student);
    }

    public static void printStudentList() {
        for (Student student : studentList) {
            System.out.println(student.toString());
            System.out.println("--------------------");
        }
    }

}

public class Main {
    public static void main(String[] args) {
        StudentsList.addStudent(new Marks("Rahul", "10th", 1, 85, 90, 88, 80, 75, 89));
        StudentsList.addStudent(new Marks("Anjali", "10th", 2, 78, 85, 92, 76, 80, 81));

        StudentsList.printStudentList();
    }
}
