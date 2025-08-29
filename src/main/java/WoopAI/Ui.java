package WoopAI;

public class Ui {
    private static final String INDENT = "  ";

    public static void showIntro() {
        System.out.println("Upah! I'm Woop\nWhat can I do for you?");
    }

    public static void showGoodbye() {
        System.out.println("Upah! Hope to see you again soon!");
    }

    public static void showTaskList(TaskList list) {
        if (list.isEmpty()) {
            System.out.println("Upah! Feed me some tasks to track!");
        } else {
            System.out.println("Upah! I have detected several tasks");
            System.out.println(list);
        }

    }

    public static void showMarked(String task) {
        System.out.println("Upah! This task has been completed!\n"
                + INDENT + task);
    }

    public static void showUnmarked(String task) {
        System.out.println("Upah? The task has was not completed after all :(\n"
                + INDENT + task);
    }

    public static void showDeleted(String task) {
        System.out.println("Upah! I have deleted the task\n"
                + INDENT + task);
    }

    public static void showAddTask(String task, int size) {
        System.out.println("Upah! You're busy! I added this task:\n"
                + INDENT + task + "\nYou have " + size + " task(s) now");
    }

    public static void showCommandError(String command) {
        System.out.println("Upah! What is " + command + "?");
    }

    public static void showDescriptorError(String command) {
        System.out.println("Upah! The command " + command
                + " needs a valid description!");
    }
}
