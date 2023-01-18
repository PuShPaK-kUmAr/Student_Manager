import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class StudentManager implements StudentManagerInterface {

    private static final List<Student> students = new ArrayList<>();
    private static final Scanner inputStudentData = new Scanner(System.in);

    @Override
    public void addStudent() {
        System.out.println("Enter student name: ");
        String name = inputStudentData.nextLine();
        System.out.println("Enter student email: ");
        String email = inputStudentData.nextLine();
        System.out.println("Enter student age: ");
        int age = inputStudentData.nextInt();
        inputStudentData.nextLine();                                      // to clear the buffer
        System.out.println("Enter student phone number: ");
        String phoneNumber = inputStudentData.nextLine();
        students.add(new Student(name, email, age, phoneNumber));
    }

    @Override
    public void deleteStudent() {
        System.out.println("Enter student email to delete: ");
        String email = inputStudentData.nextLine();
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getEmail().equals(email)) {
                iterator.remove();
                System.out.println("Student with email " + email + " has been deleted.");
                return;
            }
        }
        System.out.println("Student with email " + email + " not found.");
    }

    @Override
    public void updateStudent() {
        System.out.println("Enter student email to update: ");
        String email = inputStudentData.nextLine();
        for (Student student : students) {
            if (student.getEmail().equals(email)) {
                System.out.println("Enter new name: ");
                String name = inputStudentData.nextLine();
                student.setName(name);
                System.out.println("Enter new age: ");
                int age = inputStudentData.nextInt();
                student.setAge(age);
                System.out.println("Enter new phone number: ");
                String phoneNumber = inputStudentData.nextLine();
                student.setPhoneNumber(phoneNumber);
                System.out.println("Student with email " + email + " has been updated.");
                return;
            }
        }
        System.out.println("Student with email " + email + " not found.");
    }

    @Override
    public void printStudents() {

        System.out.println("\nStudent List:");
        if (students.isEmpty()) {
            System.out.println("No students in the list");
        }else {
            for (Student student : students) {
                System.out.println(
                                "Name : " + student.getName() + " , " +
                                "Email : " + student.getEmail() + " , " +
                                "Age : " + student.getAge() + " , " +
                                "Phone No. : " + student.getPhoneNumber()
                );
            }
        }
    }
}
