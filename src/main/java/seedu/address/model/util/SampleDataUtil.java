package seedu.address.model.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.ReadOnlyTaskMasterPro;
import seedu.address.model.TaskMasterPro;
import seedu.address.model.employee.Address;
import seedu.address.model.employee.AssignedTasks;
import seedu.address.model.employee.Email;
import seedu.address.model.employee.Employee;
import seedu.address.model.employee.EmployeeId;
import seedu.address.model.employee.Name;
import seedu.address.model.employee.Phone;
import seedu.address.model.tag.Tag;
import seedu.address.model.task.AssignedEmployees;
import seedu.address.model.task.Task;
import seedu.address.model.task.TaskId;
import seedu.address.model.task.TaskName;
import seedu.address.model.task.TaskStatus;

/**
 * Contains utility methods for populating {@code TaskMasterPro} with sample data.
 */
public class SampleDataUtil {
    public static Employee[] getSampleEmployees() {
        Employee.setUniversalEmployeeId(7);
        return new Employee[] {
            new Employee(new EmployeeId(1), new Name("Alex Yeoh"), new Phone("87438807"),
                new Email("alexyeoh@gmail.com"), new Address("Blk 30 Geylang Street 29, #06-40"),
                    new AssignedTasks(""), getTagSet("Chief Software Engineer")),
            new Employee(new EmployeeId(2), new Name("Bernice Yu"), new Phone("99272758"),
                new Email("berniceyu@gmail.com"), new Address("Blk 30 Lorong 3 Serangoon Gardens, #07-18"),
                    new AssignedTasks(""), getTagSet("Software Engineer", "Intern")),
            new Employee(new EmployeeId(3), new Name("Charlotte Oliveiro"), new Phone("93210283"),
                new Email("charlotte@outlook.com"), new Address("Blk 11 Ang Mo Kio Street 74, #11-04"),
                    new AssignedTasks(""), getTagSet("Software Developer")),
            new Employee(new EmployeeId(4), new Name("David Li"), new Phone("91031282"),
                new Email("lidavid@yahoo.com"), new Address("Blk 436 Serangoon Gardens Street 26, #16-43"),
                    new AssignedTasks(""), getTagSet("Software Developer")),
            new Employee(new EmployeeId(5), new Name("Irfan Ibrahim"), new Phone("92492021"),
                new Email("irfan@gmail.com"), new Address("Blk 47 Tampines Street 20, #17-35"),
                    new AssignedTasks(""), getTagSet("Software Developer", "Intern")),
            new Employee(new EmployeeId(6), new Name("Roy Balakrishnan"), new Phone("92624417"),
                new Email("royb@hotmail.com"), new Address("Blk 45 Aljunied Street 85, #11-31"),
                    new AssignedTasks(""), getTagSet("Art Designer"))
        };
    }
    public static Task[] getSampleTasks() {
        Task.setUniversalTaskId(4);
        return new Task[] {
            new Task(new TaskName("Integrate AI into existing work"), new TaskId(1), new TaskStatus(false),
                    new AssignedEmployees("")),
            new Task(new TaskName("Create new GUI for data display"), new TaskId(2), new TaskStatus(true),
                    new AssignedEmployees("")),
            new Task(new TaskName("Intern Project - Build a chatbot"), new TaskId(3), new TaskStatus(false),
                    new AssignedEmployees(""))
        };
    }

    public static ReadOnlyTaskMasterPro getSampleTaskMasterPro() {
        TaskMasterPro sampleAb = new TaskMasterPro();
        Employee[] employees = getSampleEmployees();
        Task[] tasks = getSampleTasks();

        //tasks[0].assignEmployee(employees[0]); TODO, assign task 1 to employee 1,2,3, t2 to e3,4,5, t3 to e5,6

        for (Employee sampleEmployee : employees) {
            sampleAb.addEmployee(sampleEmployee);
        }
        for (Task sampleTask : tasks) {
            sampleAb.addTask(sampleTask);
        }

        return sampleAb;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }

}
