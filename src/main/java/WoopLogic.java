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
        String descriptor = getDescriptor(userInput);

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
                    System.out.println(this.taskList.markTask(listIndex));
                    break;
                case "unmark":
                    listIndex = getListIndex(userInput);
                    System.out.println(this.taskList.unmarkTask(listIndex));
                    break;
                case "todo":
                    System.out.println(this.taskList.addTask(descriptor, "todo"));
                    break;
            }

            userInput = this.sc.nextLine();
            command = userInput.split(" ")[0];
            descriptor = getDescriptor(userInput);
        }
    }
    private int getListIndex(String text) {
        String tmp;
        tmp = text.split(" ")[1];
        return Integer.parseInt(tmp) - 1; // go back to 0-indexing
    }
    private String getDescriptor(String text) {
        int tmp = text.indexOf(" ");
        if (tmp >= 0 && (tmp + 1) < text.length()) {
            return text.substring(tmp + 1);
        }
        return "";
    }
    private boolean checkExit(String userInput) {
        return userInput.equals(EXIT);
    }

}
