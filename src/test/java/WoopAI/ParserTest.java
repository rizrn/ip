package WoopAI;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParserTest {
    @Test
    public void parseDescriptor_todoTask_taskReturned()
            throws IllegalDescriptorException, UnknownCommandException {
        Task t = Parser.parseDescriptor("todo hello fs", TaskType.TODO);
        assertEquals(new TodoTask("hello fs"), t);
    }

    @Test
    public void parseDescriptor_eventTask_taskReturned()
        throws IllegalDescriptorException, UnknownCommandException {
        Task t = Parser.parseDescriptor("event hello /from 2 pm /to 4 pm", TaskType.EVENT);
        assertEquals(new EventTask("hello", "2 pm", "4 pm"),
                t);
    }

    @Test
    public void parseDescriptor_deadlineTask_taskReturned()
            throws IllegalDescriptorException, UnknownCommandException {
        Task t = Parser.parseDescriptor("deadline help /by 2024-11-12", TaskType.DEADLINE);
        assertEquals(new DeadlineTask("help", "2024-11-12"), t);
    }
}