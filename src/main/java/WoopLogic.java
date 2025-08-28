import java.util.Scanner;
public class WoopLogic {
    private final Scanner sc;
    private static final String EXIT = "bye";
    private TaskList taskList;

    public WoopLogic(TaskList tasklist) {
        this.sc = new Scanner(System.in);
        this.taskList = tasklist;
    }

    public void run() {
        String userInput = this.sc.nextLine().stripLeading();
        String command = userInput.split(" ")[0];

        while (!checkExit(userInput)) {
            try {
                switch (command) {
                case "list":
                    Ui.showTaskList(this.taskList);
                    break;
                case "mark":
                    int listIndex = getListIndex(userInput);
                    Ui.showMarked(this.taskList.markTask(listIndex));
                    break;
                case "unmark":
                    listIndex = getListIndex(userInput);
                    Ui.showUnmarked(this.taskList.unmarkTask(listIndex));
                    break;
                case "delete":
                    listIndex = getListIndex(userInput);
                    Ui.showDeleted(this.taskList.deleteTask(listIndex));
                    break;
                case "todo":
                    String descriptor = getDescriptor(userInput);
                    Task t = new TodoTask(descriptor);
                    Ui.showAddTask(this.taskList.addTask(t), this.taskList.getSize());
                    break;
                case "deadline":
                    descriptor = getDescriptor(userInput);
                    String[] tmp = descriptor.split("/by ");
                    String deadlineSubject = tmp[0];
                    String dueDate = tmp[1];
                    t = new DeadlineTask(deadlineSubject, dueDate);
                    Ui.showAddTask(this.taskList.addTask(t), this.taskList.getSize());
                    break;
                case "event":
                    descriptor = getDescriptor(userInput);
                    tmp = descriptor.split("/from ");
                    String eventSubject = tmp[0];
                    String[] tmp2 = tmp[1].split("/to ");
                    String startTime = tmp2[0];
                    String endTime = tmp2[1];
                    t = new EventTask(eventSubject, startTime, endTime);
                    Ui.showAddTask(this.taskList.addTask(t), this.taskList.getSize());
                    break;
                default:
                    throw new UnknownCommandException();
                }
            } catch (UnknownCommandException e) {
                Ui.showCommandError(command);
            } catch (IllegalDescriptorException e) {
                Ui.showDescriptorError(command);
            }
            finally {
                userInput = this.sc.nextLine().stripLeading();
                command = userInput.split(" ")[0];
                Storage.saveTasks(this.taskList);
            }
        }
    }

    private int getListIndex(String text) throws IllegalDescriptorException{
        if (!text.contains(" ")) {
            throw new IllegalDescriptorException();
        }
        String tmp = text.split(" ")[1];
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
