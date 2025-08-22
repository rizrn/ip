import java.util.Scanner;
public class WoopLogic {
    private final Scanner sc;
    private static final String exit = "bye";
    public WoopLogic() {
        this.sc = new Scanner(System.in);
    }

    public void run() {
        String userInput = this.sc.nextLine();
        while (!checkExit(userInput)) {
            System.out.println(userInput);
            userInput = this.sc.nextLine();
        }
    }
    private boolean checkExit(String userInput) {
        return userInput.equals(exit);
    }

}
