package WoopAI;

/**
 * An abstract class for all Task types
 */
public abstract class Task {
    private String name;
    private boolean isFinished;

    /**
     * Initialises a Task object by using the given name.
     * Automatically sets isFinished to false.
     *
     * @param name The name of the task.
     */
    public Task(String name) {
        this.name = name;
        this.isFinished = false;
    }

    /**
     * Initialises a Task object by using the given name and a boolean for isFinished.
     *
     * @param name The name of the task.
     * @param isFinished True if task is finished, false otherwise.
     */
    public Task(String name, boolean isFinished) {
        this.name = name;
        this.isFinished = isFinished;
    }

    public boolean getIsFinished() {
        return this.isFinished;
    }

    /**
     * Marks task as finished.
     *
     * @return Whether task was completed successfully or not.
     */
    public boolean mark() {
        if (this.isFinished) {
            return false;
        } else {
            this.isFinished = true;
            return true;
        }
    }

    /**
     * Marks task as finished.
     *
     * @return Whether task was completed successfully or not.
     */
    public boolean unmark() {
        if (this.isFinished) {
            this.isFinished = false;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns encoded version of Task to store in a file.
     *
     * @return Encoded string for save state.
     */
    public String getSaveInfo() {
        return " | " + (this.isFinished ? "1" : "0")
                + " | " + this.name;
    };

    @Override
    public String toString() {
        String finished = "[X]";
        String unfinished = "[ ]";

        if (this.isFinished) {
            return finished + " " + this.name;
        } else {
            return unfinished + " " + this.name;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof Task t) {
            return t.name.equals(this.name)
                    && this.isFinished == t.isFinished;
        }
        return false;
    }
}
