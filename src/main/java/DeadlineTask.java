public class DeadlineTask extends Task{
    private String dueDate;

    public DeadlineTask(String name, String dueDate) {
        super(name);
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() +
                " (by: " + this.dueDate + ")";
    }
}
