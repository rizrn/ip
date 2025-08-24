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
        String descriptor;

        String userInput = this.sc.nextLine().stripLeading();
        String command = userInput.split(" ")[0];

        while (!checkExit(userInput)) {
            try {
                switch (command) {
                    case "list": //
                        if (this.taskList.isEmpty()) {
                            System.out.println("Upah! Feed me some tasks to track!");
                        } else {
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
                        descriptor = getDescriptor(userInput);
                        System.out.println(this.taskList.addTask(descriptor, "todo"));
                        break;
                    case "deadline":
                        descriptor = getDescriptor(userInput);
                        System.out.println(this.taskList.addTask(descriptor, "deadline"));
                        break;
                    case "event":
                        descriptor = getDescriptor(userInput);
                        System.out.println(this.taskList.addTask(descriptor, "event"));
                        break;
                    default:
                        throw new UnknownCommandException();
                }
            } catch (UnknownCommandException e) {
                System.out.println("Upah! What is " + command + "?");
            } catch (IllegalDescriptorException e) {
                System.out.println("Upah! The command " + command + " needs a valid" +
                        " description!");
            }
            finally {
                userInput = this.sc.nextLine().stripLeading();
                command = userInput.split(" ")[0];
            }
        }
    }
    private int getListIndex(String text) throws IllegalDescriptorException{
        String tmp;
        if (!text.contains(" ")) {
            throw new IllegalDescriptorException();
        }
        tmp = text.split(" ")[1];
        return Integer.parseInt(tmp) - 1; // go back to 0-indexing
    }
    private String getDescriptor(String text) throws IllegalDescriptorException {
        int tmp = text.indexOf(" ");
        if (tmp >= 0 && (tmp + 1) < text.length()) {
            return text.substring(tmp + 1);
        } else {
            throw new IllegalDescriptorException();
        }
    }
    private boolean checkExit(String userInput) {
        return userInput.equals(EXIT);
    }

}
