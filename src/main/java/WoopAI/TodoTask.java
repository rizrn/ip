package WoopAI;

/**
 * A class for to do type tasks
 */
public class TodoTask extends Task{

    /**
     * Initialises a TodoTask object using name.
     * isFinished is set to false by default.
     *
     * @param name The name of task.
     */
    public TodoTask(String name) {
        super(name);
    }

    /**
     * Initialises a TodoTask object using name and isFinished.
     *
     * @param name The name of task.
     * @param isFinished Whether task is finished.
     */
    public TodoTask(String name, boolean isFinished) {
        super(name, isFinished);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getSaveInfo() {
        return "T" + super.getSaveInfo();
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (o instanceof TodoTask t) {
            return super.equals(t);
        }

        return false;
    }
}
