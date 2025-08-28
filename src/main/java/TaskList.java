import java.lang.StringBuffer;
import java.util.ArrayList;
public class TaskList {
    private ArrayList<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public String addTask(Task t) {
        this.tasks.add(t);
        return "Upah! You're busy! I added this task:\n  " +
                t +
                "\nYou have " + getSize() + " task(s) now";
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public String markTask(int index) {
        StringBuffer sb = new StringBuffer();
        this.tasks.get(index).mark();
        sb.append("Upah! This task has been completed!\n");
        sb.append("  ");
        sb.append(this.getTaskName(index));
        return sb.toString();
    }

    public String unmarkTask(int index) {
        StringBuffer sb = new StringBuffer();
        this.tasks.get(index).unmark();
        sb.append("Upah? The task has was not completed after all :(\n");
        sb.append("  ");
        sb.append(this.getTaskName(index));
        return sb.toString();
    }

    public String deleteTask(int index) {
        Task t = this.tasks.get(index);
        this.tasks.remove(index);
        return "Upah! I have deleted the task\n  " + t;
    }

    public String getTasksSaveFormat() {
        StringBuffer sb = new StringBuffer();
        if (isEmpty()) return "";
        for (int i = 0; i < getSize(); i++) {
            sb.append(this.tasks.get(i).getSaveInfo());
            sb.append("\n");
        }

        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private int getSize() {
        return this.tasks.size();
    }

    private String getTaskName(int index) {
        return this.tasks.get(index).toString();
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < getSize(); i++) {
            String newLine = (i + 1) + " " + this.tasks.get(i); //increment i by 1 to start at 1
            sb.append(newLine);
            sb.append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
