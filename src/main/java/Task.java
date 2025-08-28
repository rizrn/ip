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

    public boolean isFinished() {
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
}
