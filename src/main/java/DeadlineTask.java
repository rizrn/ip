import java.time.LocalDate;

public class DeadlineTask extends Task{
    private LocalDate dueDate;

    public DeadlineTask(String name, String dueDate) {
        super(name);
        this.dueDate = LocalDate.parse(dueDate);
    }

    public DeadlineTask(String name, boolean isFinished, String dueDate) {
        super(name, isFinished);
        this.dueDate = LocalDate.parse(dueDate);
    }

    private String getDateString() {
        return this.dueDate.getMonth().toString().substring(0, 3)
                + " " + this.dueDate.getDayOfMonth()
                + " " + this.dueDate.getYear();
    }

    @Override
    public String getSaveInfo() {
        return "D" + super.getSaveInfo()
                + " | " + this.dueDate.toString();
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() +
                " (by: " + getDateString() + ")";
    }
}
