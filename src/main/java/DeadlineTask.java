public class DeadlineTask extends Task{
    private String dueDate;

    public DeadlineTask(String name, String dueDate) {
        super(name);
        this.dueDate = dueDate;
    }

    public DeadlineTask(String name, boolean isFinished, String dueDate) {
        super(name, isFinished);
        this.dueDate = dueDate;
    }

    @Override
    public String getSaveInfo() {
        return "D" + super.getSaveInfo()
                + " | " + this.dueDate;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() +
                " (by: " + this.dueDate + ")";
    }
}
