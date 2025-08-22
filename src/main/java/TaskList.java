import java.lang.StringBuffer;
public class TaskList {
    private static final int MAX_SIZE = 100;
    private Task[] tasks;
    private int size;

    public TaskList() {
        this.tasks = new Task[MAX_SIZE];
        this.size = 0;
    }
    public void addTask(String name) {
        Task t = new Task(name);
        this.tasks[this.size++] = t;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < this.size; i++) {
            String newLine = i + " " + this.tasks[i];
            sb.append(newLine);
            sb.append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
