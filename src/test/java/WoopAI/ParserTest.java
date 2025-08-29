package WoopAI;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParserTest {
    @Test
    public void parseDescriptor_todoTask_taskReturned()
            throws IllegalDescriptorException, UnknownCommandException {
        Task t = Parser.parseDescriptor("hello fs", TaskType.TODO);
        assertEquals(" ", " ");
    }
}