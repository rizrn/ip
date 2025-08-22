public class Task {
    private String name;
    private boolean isFinished;

    public Task(String name) {
        this.name = name;
        this.isFinished = false;
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
