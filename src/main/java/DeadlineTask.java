public class DeadlineTask extends Task{
    public DeadlineTask(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "[D]" + super.toString();
    }
}
