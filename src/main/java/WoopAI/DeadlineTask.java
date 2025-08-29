package WoopAI;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class DeadlineTask extends Task{
    private LocalDate dueDate;

    public DeadlineTask(String name, String dueDate)
            throws IllegalDescriptorException {
        super(name);
        try {
            this.dueDate = LocalDate.parse(dueDate);
        } catch (DateTimeParseException e) {
            throw new IllegalDescriptorException();
        }
    }

    public DeadlineTask(String name, boolean isFinished, String dueDate) {
        super(name, isFinished);
        this.dueDate = LocalDate.parse(dueDate);
    }

    private String getDateString() {
        return this.dueDate.getMonth().toString().substring(0, 3)
                + " " + this.dueDate.getDayOfMonth()
                + " " + this.dueDate.getYear();
    }

    @Override
    public String getSaveInfo() {
        return "D" + super.getSaveInfo()
                + " | " + this.dueDate.toString();
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() +
                " (by: " + getDateString() + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (o instanceof DeadlineTask t) {
            return t.dueDate.equals(this.dueDate)
                    && super.equals(t);
        }

        return false;
    }
}
