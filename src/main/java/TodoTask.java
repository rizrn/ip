public class TodoTask extends Task{
    public TodoTask(String name) {
        super(name);
    }

    public TodoTask(String name, boolean isFinished) {
        super(name, isFinished);
    }

    @Override
    public String getSaveInfo() {
        return "T" + super.getSaveInfo();
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
