package WoopAI;

public class Parser {
    public static String parseCommand(String input) {
        return input.split(" ")[0];
    }

    public static Task parseDescriptor(String input, TaskType type)
            throws IllegalDescriptorException, UnknownCommandException {
        int index = input.indexOf(" ");
        if (index >= 0 && (index + 1) < input.length()) {
            String descriptor =  input.substring(index + 1);
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
        } else {
            throw new IllegalDescriptorException();
        }
    }

    public static String parseKeyword(String input) {
        String[] tmp = input.split(" ", 2);
        return tmp[1];
    }

    public static int parseIndex(String input) throws IllegalDescriptorException {
        if (!input.contains(" ")) {
            throw new IllegalDescriptorException();
        }
        String tmp = input.split(" ")[1];
        return Integer.parseInt(tmp) - 1; // go back to 0-indexing
    }
}
