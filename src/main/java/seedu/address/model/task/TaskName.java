package seedu.address.model.task;

/**
 * Represents a Task's name.
 */
public class TaskName {
    private static final String MESSAGE_CONSTRAINTS = // ToDo, check if should use this (compare to Employee.Name)
            "Names should only contain alphanumeric characters and spaces, and it should not be blank";

    private final String taskName;

    /**
     * Constructs a {@code TaskName}.
     *
     * @param name A valid task name.
     */
    public TaskName(String name) {
        taskName = name;
    }

    /**
     * Getter for taskName
     *
     * @return taskName for this task
     */
    public String getTaskName() {
        return taskName;
    }

    @Override
    public String toString() {
        return taskName;
    }
}
