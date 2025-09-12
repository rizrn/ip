package WoopAI;

/**
 * A class for event type task.
 */
public class EventTask extends Task{
    private String startTime;
    private String endTime;
    private static final String TASK_STRING = "E";
    /**
     * Initialises a EventTask using name, startTime and endTime.
     * isFinished is set to false by default.
     *
     * @param name The name of task.
     * @param startTime The start time of task.
     * @param endTime The end time of task.
     */
    public EventTask(String name, String startTime, String endTime) {
        super(name);
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     * Initialises a EventTask using name, isFinished, startTime and endTime.
     *
     * @param name The name of task.
     * @param isFinished Whether task is finished.
     * @param startTime The start time of task.
     * @param endTime The end time of task.
     */
    public EventTask(String name, boolean isFinished,
                     String startTime, String endTime) {
        super(name, isFinished);
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getSaveInfo() {
        return TASK_STRING + super.getSaveInfo() + DIVIDER
                + this.startTime + DIVIDER + this.endTime;

    }
    @Override
    public String toString() {
        return "[E]" + super.toString()
                + " (from: " + this.startTime
                + " to: " + this.endTime + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (o instanceof EventTask t) {
            return t.startTime.equals(this.startTime)
                    && t.endTime.equals(this.endTime)
                    && super.equals(t);
        }

        return false;
    }
}
