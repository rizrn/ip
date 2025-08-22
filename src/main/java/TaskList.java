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

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean markTask(int index) {
        return this.tasks[index].mark();
    }

    public boolean unmarkTask(int index) {
        return this.tasks[index].unmark();
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
