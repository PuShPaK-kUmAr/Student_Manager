import java.util.Scanner;

public class Main {

    private static final Scanner userOption = new Scanner(System.in);

    public static void main(String[] args) {
        StudentManager studentManager = new StudentManager();
        while (true) {
            System.out.println(
                    """
                            What task would you like to perform?
                            1. Add student
                            2. Delete student
                            3. Update student
                            4. Print students
                            5. Exit
                    """
            );
            int task = userOption.nextInt();
            switch (task) {                             // implemented pattern match switch or enhanced switch introduced in java 14
                case 1 -> studentManager.addStudent();
                case 2 -> studentManager.deleteStudent();
                case 3 -> studentManager.updateStudent();
                case 4 -> studentManager.printStudents();
                case 5 -> System.exit(0);
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
