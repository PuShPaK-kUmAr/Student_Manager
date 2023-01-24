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
            try{
                int task = userOption.nextInt();
                switch (task) {                             // implemented pattern match switch or enhanced switch introduced in java 14
                    case 1 -> studentManager.add();
                    case 2 -> studentManager.delete();
                    case 3 -> studentManager.update();
                    case 4 -> studentManager.print();
                    case 5 -> System.exit(0);
                    default -> System.out.println("Invalid option. Please try again.");
                }
            }catch (Exception error) {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                userOption.nextLine();                    // Clear the input buffer to prevent infinite loop
            }
        }
    }
}
