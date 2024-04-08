package seedu.address.model.task;

/**
 * Represents the status of a task, which can be either completed or in progress.
 */
public class TaskStatus {
    private boolean isCompleted;

    /**
     * Constructs a {@code TaskStatus}.
     *
     * @param taskStatus A valid boolean.
     */
    public TaskStatus(boolean taskStatus) {
        isCompleted = taskStatus;
    }

    /**
     * Constructs a {@code TaskStatus}.
     *
     * @param taskStatus A valid String.
     */
    public TaskStatus(String taskStatus) {
        assert taskStatus != null;
        if (taskStatus.equals("Completed")) {
            isCompleted = true;
        } else if (taskStatus.equals("In Progress")) {
            isCompleted = false;
        }
    }
    public void setTaskDone() {
        isCompleted = true;
    }
    public void setTaskNotDone() {
        isCompleted = false;
    }
    public boolean getStatus() {
        return isCompleted;
    }

    @Override
    public String toString() {
        if (isCompleted) {
            return "Completed";
        } else {
            return "In Progress";
        }
    }
}
