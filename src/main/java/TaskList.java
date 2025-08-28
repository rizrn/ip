import java.lang.StringBuffer;
import java.util.ArrayList;
public class TaskList {
    private ArrayList<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public String addTask(Task t) {
        this.tasks.add(t);
        return t.toString();
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public String markTask(int index) {
        this.tasks.get(index).mark();
        return this.getTaskName(index);
    }

    public String unmarkTask(int index) {
        this.tasks.get(index).unmark();
        return this.getTaskName(index);
    }

    public String deleteTask(int index) {
        Task t = this.tasks.get(index);
        this.tasks.remove(index);
        return t.toString();
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

    public int getSize() {
        return this.tasks.size();
    }

    private String getTaskName(int index) {
        return this.tasks.get(index).toString();
    }

    @Override
    public String toString() {
        if (isEmpty()) return "";
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
