public class EventTask extends Task{
    public EventTask(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "[E]" + super.toString();
    }
}
