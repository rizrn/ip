import java.util.Scanner;
public class WoopLogic {
    private final Scanner sc;
    private static final String EXIT = "bye";
    private TaskList taskList;

    public WoopLogic() {
        this.sc = new Scanner(System.in);
        this.taskList = new TaskList();
    }

    public void run() {
        String userInput = this.sc.nextLine();

        while (!checkExit(userInput)) {
            switch (userInput) {
                case "list":
                    System.out.println(this.taskList);
                    break;
                default:
                    this.taskList.addTask(userInput);
                    System.out.println("added " + userInput);
            }

            userInput = this.sc.nextLine();
        }
    }
    private boolean checkExit(String userInput) {
        return userInput.equals(EXIT);
    }

}
