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
        String[] tmp;

        switch (taskType){
            case "deadline":
                tmp = name.split("/by ");
                String deadlineSubject = tmp[0];
                String dueDate = tmp[1];
                t = new DeadlineTask(deadlineSubject, dueDate);
                break;
            case "todo":
                t = new TodoTask(name);
                break;
            case "event":
                tmp = name.split("/from ");
                String eventSubject = tmp[0];
                String[] tmp2 = tmp[1].split("/to ");
                String startTime = tmp2[0];
                String endTime = tmp2[1];
                t = new EventTask(eventSubject, startTime, endTime);
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
