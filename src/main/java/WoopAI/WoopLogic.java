package WoopAI;

import java.util.Scanner;

/**
 * Handles main logic of Woop
 */
public class WoopLogic {
    private final Scanner sc;
    private static final String EXIT = "bye"; //String constant to exit loop
    private TaskList taskList;

    /**
     * Initialises a WoopLogic object.
     *
     * @param tasklist stores the task list for the Woop to use.
     */
    public WoopLogic(TaskList tasklist) {
        this.sc = new Scanner(System.in);
        this.taskList = tasklist;
    }

    /**
     * Runs WoopLogic.
     * Exits when the constant EXIT is inputted by the user.
     */
    public void run() {
        String userInput = this.sc.nextLine().stripLeading();
        String command = Parser.parseCommand(userInput);

        while (!checkExit(userInput)) {
            try {
                switch (command) { //handles all valid commands
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
                case "find":
                    String keyword = Parser.parseKeyword(userInput);
                    Ui.showFindKeyword(this.taskList.findKeyword(keyword));
                    break;
                default:
                    throw new UnknownCommandException();
                }
            } catch (UnknownCommandException e) {
                Ui.showCommandError(command);
            } catch (IllegalDescriptorException e) {
                Ui.showDescriptorError(command);
            } catch (Exception e) {
                Ui.showError(e);
            } finally {
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
