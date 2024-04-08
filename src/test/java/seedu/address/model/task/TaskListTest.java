package seedu.address.model.task;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import seedu.address.model.task.exceptions.TaskNotFoundException;

public class TaskListTest {
    private final TaskList taskList = new TaskList();
    private final Task task = new Task(new TaskName("Test"), new TaskId(5), new TaskStatus(false),
            new AssignedEmployees(""));

    @Test
    public void execute_addRemoveTaskList_success() {
        taskList.add(task);
        assertTrue(taskList.contains(task));
        taskList.remove(task);
        assertFalse(taskList.contains(task));
    }

    @Test
    public void execute_taskListToString_success() {
        assertEquals(taskList.asUnmodifiableObservableList().toString(), taskList.toString());
    }

    @Test
    public void execute_removeFromEmptyTaskList_exception() {
        try {
            taskList.remove(task);
        } catch (TaskNotFoundException e) {
            assertEquals(e.getMessage(), null);
        }
    }
}
