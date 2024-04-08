package seedu.address.model.task;

/**
 * Represents a Task's Id.
 */
public class TaskId {
    private final int taskId;

    /**
     * Constructs a {@code TaskId}.
     *
     * @param id A valid taskId.
     */
    public TaskId(int id) {
        taskId = id;
    }

    /**
     * Getter for taskId
     *
     * @return taskId for this task
     */
    public int getId() {
        return taskId;
    }

    @Override
    public String toString() {
        return "" + taskId;
    }
}
