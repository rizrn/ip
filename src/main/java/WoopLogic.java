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
        String command = Parser.parseCommand(userInput);

        while (!checkExit(userInput)) {
            try {
                switch (command) {
                case "list":
                    Ui.showTaskList(this.taskList);
                    break;
                case "mark":
                    int listIndex = Parser.parseIndex(userInput);
                    Ui.showMarked(this.taskList.markTask(listIndex));
                    break;
                case "unmark":
                    listIndex = Parser.parseIndex(userInput);
                    Ui.showUnmarked(this.taskList.unmarkTask(listIndex));
                    break;
                case "delete":
                    listIndex = Parser.parseIndex(userInput);
                    Ui.showDeleted(this.taskList.deleteTask(listIndex));
                    break;
                case "todo":
                    Task t = Parser.parseDescriptor(userInput, TaskType.TODO);
                    Ui.showAddTask(this.taskList.addTask(t), this.taskList.getSize());
                    break;
                case "deadline":
                    t = Parser.parseDescriptor(userInput, TaskType.DEADLINE);
                    Ui.showAddTask(this.taskList.addTask(t), this.taskList.getSize());
                    break;
                case "event":
                    t = Parser.parseDescriptor(userInput, TaskType.EVENT);
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
                command = Parser.parseCommand(userInput);
                Storage.saveTasks(this.taskList);
            }
        }
    }

    private boolean checkExit(String userInput) {
        return userInput.equals(EXIT);
    }

}
