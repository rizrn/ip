public class EventTask extends Task{
    private String startTime;
    private String endTime;

    public EventTask(String name, String startTime, String endTime) {
        super(name);
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public EventTask(String name, boolean isFinished,
                     String startTime, String endTime) {
        super(name, isFinished);
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public String getSaveInfo() {
        return "E" + super.getSaveInfo() + " | "
                + this.startTime + " | " + this.endTime;

    }
    @Override
    public String toString() {
        return "[E]" + super.toString()
                + " (from: " + this.startTime
                + " to: " + this.endTime + ")";
    }
}
