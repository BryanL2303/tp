package seedu.address.model.employee;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class AssignedTasksTest {
    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new AssignedTasks(null));
    }

    @Test
    public void isValidAssignedTasks() {
        // null assignedTasks
        assertThrows(NullPointerException.class, () -> AssignedTasks.isValidTask(null));

        // valid assignedTasks
        assertTrue(AssignedTasks.isValidTask("")); // empty string
        assertTrue(AssignedTasks.isValidTask("1"));
        assertTrue(AssignedTasks.isValidTask("1 2"));
        assertTrue(AssignedTasks.isValidTask("1 2 3"));
    }

    @Test
    public void equals() {
        AssignedTasks assignedTasks = new AssignedTasks("1");

        // same values -> returns true
        assertTrue(assignedTasks.equals(new AssignedTasks("1")));

        // same object -> returns true
        assertTrue(assignedTasks.equals(assignedTasks));

        // null -> returns false
        assertFalse(assignedTasks.equals(null));

        // different types -> returns false
        assertFalse(assignedTasks.equals(5.0f));

        // different values -> returns false
        assertFalse(assignedTasks.equals(new AssignedTasks("1 2")));
    }
}
