package WoopAI;

public abstract class Task {
    private String name;
    private boolean isFinished;

    public Task(String name) {
        this.name = name;
        this.isFinished = false;
    }

    public Task(String name, boolean isFinished) {
        this.name = name;
        this.isFinished = isFinished;
    }

    public boolean getIsFinished() {
        return this.isFinished;
    }

    public boolean mark() {
        if (this.isFinished) {
            return false;
        } else {
            this.isFinished = true;
            return true;
        }
    }

    public boolean unmark() {
        if (this.isFinished) {
            this.isFinished = false;
            return true;
        } else {
            return false;
        }
    }

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
