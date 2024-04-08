package seedu.address.model.task;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class AssignedEmployeesTest {
    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new AssignedEmployees(null));
    }

    @Test
    public void isValidAssignedEmployees() {
        // null assignedEmployees
        assertThrows(NullPointerException.class, () -> AssignedEmployees.isValidEmployee(null));

        // valid assignedEmployees
        assertTrue(AssignedEmployees.isValidEmployee("")); // empty string
        assertTrue(AssignedEmployees.isValidEmployee("1"));
        assertTrue(AssignedEmployees.isValidEmployee("1 2"));
        assertTrue(AssignedEmployees.isValidEmployee("1 2 3"));
    }

    @Test
    public void equals() {
        AssignedEmployees assignedEmployees = new AssignedEmployees("1");

        // same values -> returns true
        assertTrue(assignedEmployees.equals(new AssignedEmployees("1")));

        // same object -> returns true
        assertTrue(assignedEmployees.equals(assignedEmployees));

        // null -> returns false
        assertFalse(assignedEmployees.equals(null));

        // different types -> returns false
        assertFalse(assignedEmployees.equals(5.0f));

        // different values -> returns false
        assertFalse(assignedEmployees.equals(new AssignedEmployees("1 2")));
    }
}
