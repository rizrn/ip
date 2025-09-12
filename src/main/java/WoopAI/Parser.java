package WoopAI;

/**
 * Class to handle all user input and return needed information.
 */
public class Parser {
    /**
     * Retrieves the command from the given input.
     *
     * @param input The user input.
     * @return The command part of the input.
     */
    public static String parseCommand(String input) {
        return input.split(" ")[0];
    }

    /**
     * Retrieves the Task descriptor from the user input depending on the task type.
     * Additionally, creates a Task object that represents the descriptor.
     * If descriptor is invalid, throws IllegalDescriptorException.
     *
     * @param input The user input.
     * @param type The Task type that this descriptor is for.
     * @return A new Task object that represents the descriptor.
     * @throws IllegalDescriptorException If descriptor syntax is invalid.
     * @throws UnknownCommandException If type given is invalid.
     */
    public static Task parseDescriptor(String input, TaskType type)
            throws IllegalDescriptorException, UnknownCommandException {
        int index = input.indexOf(" ");
        if (index < 0) {
            throw new IllegalDescriptorException();
        }
        String descriptor = input.substring(index + 1).trim();
        if (descriptor.isBlank()) {
            throw new IllegalDescriptorException();
        }
        switch (type) {
        case TODO:
            return new TodoTask(descriptor);
        case EVENT:
            String[] tmp = descriptor.split(" /from ");
            String eventSubject = tmp[0];
            String[] tmp2 = tmp[1].split(" /to ");
            String startTime = tmp2[0];
            String endTime = tmp2[1];
            return new EventTask(eventSubject, startTime, endTime);
        case DEADLINE:
            tmp = descriptor.split(" /by ");
            String deadlineSubject = tmp[0];
            String dueDate = tmp[1];
            return new DeadlineTask(deadlineSubject, dueDate);
        default:
            throw new UnknownCommandException();
        }
    }

    /**
     * Retrieves the keyword from the user input.
     * The keyword is used to search for tasks that contain the keyword.
     *
     * @param input The user input.
     * @return The keyword to search for tasks.
     */
    public static String parseKeyword(String input) {
        String[] tmp = input.split(" ", 2);
        return tmp[1];
    }

    /**
     * Retrieves the index of the task from the user input.
     * The index of the task is used for commands that require to edit at specific indexes.
     *
     * @param input The user input.
     * @return The index of the Task in int.
     * @throws IllegalDescriptorException If descriptor syntax is not valid.
     */
    public static int parseIndex(String input) throws IllegalDescriptorException {
        if (!input.contains(" ")) {
            throw new IllegalDescriptorException();
        }
        String tmp = input.split(" ")[1];
        return Integer.parseInt(tmp) - 1; // go back to 0-indexing
    }
}
