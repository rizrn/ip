import java.util.Arrays;
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
        int listIndex; //for marking and unmarking tasks

        String userInput = this.sc.nextLine();
        String command = userInput.split(" ")[0];

        while (!checkExit(userInput)) {
            switch (command) {
                case "list": //
                    if (this.taskList.isEmpty()) {
                        System.out.println("Upah! Feed me some tasks to track!");
                    }
                    else {
                        System.out.println("Upah! I have detected several tasks");
                        System.out.println(this.taskList);
                    }
                    break;
                case "mark":
                    listIndex = getListIndex(userInput);
                    this.taskList.markTask(listIndex);
                case "unmark":
                    listIndex = getListIndex(userInput);
                    this.taskList.unmarkTask(listIndex);
                default:
                    this.taskList.addTask(userInput);
                    System.out.println("Upah! I have added: " + userInput + "!");
            }

            userInput = this.sc.nextLine();
            command = userInput.split(" ")[0];
        }
    }
    private int getListIndex(String text) {
        String tmp;
        tmp = text.split(" ")[1];
        return Integer.parseInt(tmp) - 1;
    }
    private boolean checkExit(String userInput) {
        return userInput.equals(EXIT);
    }

}
