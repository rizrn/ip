package WoopAI;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DeadlineTaskTest {
    @Test
    public void initialise_badDate_descriptorExceptionThrown() {
        assertThrows(IllegalDescriptorException.class,
                () -> new DeadlineTask("Give Book", "2022-32-10"));
    }

    @Test
    public void initialise_incompleteDate_descriptorExceptionThrown() {
        assertThrows(IllegalDescriptorException.class,
                () -> new DeadlineTask("Give Book", "2022-12"));
    }
}