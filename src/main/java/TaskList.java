import java.lang.StringBuffer;
public class TaskList {
    private static final int MAX_SIZE = 100;
    private Task[] tasks;
    private int size;

    public TaskList() {
        this.tasks = new Task[MAX_SIZE];
        this.size = 0;
    }
    public String addTask(String name, String taskType) {
        Task t;
        switch (taskType){
            case "deadline":
                t = new DeadlineTask(name);
                break;
            case "todo":
                t = new TodoTask(name);
                break;
            case "event":
                t = new EventTask(name);
                break;
            default:
                t = new TodoTask(name); //placeholder
        }

        this.tasks[this.size++] = t;
        return "Upah! You're busy! I added this task: \n" +
                t.toString();
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public String markTask(int index) {
        StringBuffer sb = new StringBuffer();
        this.tasks[index].mark();
        sb.append("Upah! This task has been completed!\n");
        sb.append(this.getTaskName(index));
        return sb.toString();
    }

    public String unmarkTask(int index) {
        StringBuffer sb = new StringBuffer();
        this.tasks[index].unmark();
        sb.append("Upah? The task has was not completed after all :(");
        sb.append(this.getTaskName(index));
        return sb.toString();
    }

    private String getTaskName(int index) {
        return this.tasks[index].toString();
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < this.size; i++) {
            String newLine = (i + 1) + " " + this.tasks[i]; //increment i by 1 to start at 1
            sb.append(newLine);
            sb.append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
