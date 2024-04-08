package seedu.address.model.employee;

/**
 * Represents an Employee's Id.
 */
public class EmployeeId {
    private final int employeeId;

    /**
     * Constructs a {@code EmployeeId}.
     *
     * @param id A valid employeeId.
     */
    public EmployeeId(int id) {
        employeeId = id;
    }

    /**
     * Getter for employeeId
     *
     * @return employeeId for this employee
     */
    public int getEmployeeId() {
        return employeeId;
    }

    @Override
    public String toString() {
        return "" + employeeId;
    }
}
