package WoopAI;

import javafx.application.Platform;

import ui.Ui;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * Handles main logic of Woop
 */
public class WoopLogic {
    private static final String EXIT = "bye"; //String constant to exit loop
    private TaskList tasks;

    public WoopLogic(TaskList tasks) {
        this.tasks = tasks;
    }
    /**
     * Runs WoopLogic.
     * Exits when the constant EXIT is inputted by the user.
     */
    public String run(String userInput) {
        String command = Parser.parseCommand(userInput);
        if (checkExit(userInput)) {
            Ui.showGoodbye();
            CompletableFuture.delayedExecutor(800, TimeUnit.MILLISECONDS)
                    .execute(Platform::exit);
        }
        try {
            switch (command) { //handles all valid commands
            case "list":
                Ui.showTaskList(this.tasks);
                break;
            case "mark":
                int listIndex = Parser.parseIndex(userInput);
                Ui.showMarked(this.tasks.markTask(listIndex));
                break;
            case "unmark":
                listIndex = Parser.parseIndex(userInput);
                Ui.showUnmarked(this.tasks.unmarkTask(listIndex));
                break;
            case "delete":
                listIndex = Parser.parseIndex(userInput);
                Ui.showDeleted(this.tasks.deleteTask(listIndex));
                break;
            case "todo":
                Task t = Parser.parseDescriptor(userInput, TaskType.TODO);
                Ui.showAddTask(this.tasks.addTask(t), this.tasks.getSize());
                break;
            case "deadline":
                t = Parser.parseDescriptor(userInput, TaskType.DEADLINE);
                Ui.showAddTask(this.tasks.addTask(t), this.tasks.getSize());
                break;
            case "event":
                t = Parser.parseDescriptor(userInput, TaskType.EVENT);
                Ui.showAddTask(this.tasks.addTask(t), this.tasks.getSize());
                break;
            case "find":
                String keyword = Parser.parseKeyword(userInput);
                Ui.showFindKeyword(this.tasks.findKeyword(keyword));
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
            Storage.saveTasks(this.tasks);
        }
        return "";
    }

    private boolean checkExit(String userInput) {
        return userInput.equals(EXIT);
    }
}
