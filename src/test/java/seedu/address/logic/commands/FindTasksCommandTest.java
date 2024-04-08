package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.Messages.MESSAGE_TASKS_LISTED_OVERVIEW;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.task.AssignedEmployees;
import seedu.address.model.task.Task;
import seedu.address.model.task.TaskId;
import seedu.address.model.task.TaskName;
import seedu.address.model.task.TaskNameContainsKeywordsPredicate;
import seedu.address.model.task.TaskStatus;

/**
 * Contains integration tests (interaction with the Model) for {@code FindTasksCommand}.
 */
public class FindTasksCommandTest {
    private Model model = new ModelManager();
    private Model expectedModel = new ModelManager();
    private Task firstTask = new Task(new TaskName("meeting 1"), new TaskId(123), new TaskStatus(false),
            new AssignedEmployees(""));
    private Task secondTask = new Task(new TaskName("project 2"), new TaskId(124), new TaskStatus(false),
            new AssignedEmployees(""));
    private Task thirdTask = new Task(new TaskName("presentation 3"), new TaskId(125), new TaskStatus(false),
            new AssignedEmployees(""));
    private Task fourthTask = new Task(new TaskName("presentations 4"), new TaskId(126), new TaskStatus(false),
            new AssignedEmployees(""));
    @Test
    public void equals() {
        TaskNameContainsKeywordsPredicate firstPredicate =
                new TaskNameContainsKeywordsPredicate(Collections.singletonList("first"));
        TaskNameContainsKeywordsPredicate secondPredicate =
                new TaskNameContainsKeywordsPredicate(Collections.singletonList("second"));

        FindTasksCommand findFirstCommand = new FindTasksCommand(firstPredicate);
        FindTasksCommand findSecondCommand = new FindTasksCommand(secondPredicate);

        // same object -> returns true
        assertTrue(findFirstCommand.equals(findFirstCommand));

        // same values -> returns true
        FindTasksCommand findFirstCommandCopy = new FindTasksCommand(firstPredicate);
        assertTrue(findFirstCommand.equals(findFirstCommandCopy));

        // different types -> returns false
        assertFalse(findFirstCommand.equals(1));

        // null -> returns false
        assertFalse(findFirstCommand.equals(null));

        // different employee -> returns false
        assertFalse(findFirstCommand.equals(findSecondCommand));
    }
    @Test
    public void execute_zeroKeywords_noTaskFound() {
        String expectedMessage = String.format(MESSAGE_TASKS_LISTED_OVERVIEW, 0);
        TaskNameContainsKeywordsPredicate predicate = preparePredicate(" ");
        FindTasksCommand command = new FindTasksCommand(predicate);
        expectedModel.updateFilteredTaskList(predicate);
        assertCommandSuccess(command, model, expectedMessage, expectedModel);
        assertEquals(Collections.emptyList(), model.getFilteredEmployeeList());
    }
    @Test
    public void execute_multipleKeywords_multipleTasksFound() {
        String expectedMessage = String.format(MESSAGE_TASKS_LISTED_OVERVIEW, 3);
        TaskNameContainsKeywordsPredicate predicate = preparePredicate("meeting project presentation");
        FindTasksCommand command = new FindTasksCommand(predicate);
        addTasksToModel(model);
        addTasksToModel(expectedModel);
        expectedModel.updateFilteredTaskList(predicate);
        assertCommandSuccess(command, model, expectedMessage, expectedModel);
        assertEquals(Arrays.asList(firstTask, secondTask, thirdTask), expectedModel.getFilteredTaskList());
    }
    @Test
    public void execute_unmatchedKeyword_noTasksFound() {
        String expectedMessage = String.format(MESSAGE_TASKS_LISTED_OVERVIEW, 0);
        TaskNameContainsKeywordsPredicate predicate = preparePredicate("present");
        FindTasksCommand command = new FindTasksCommand(predicate);
        addTasksToModel(model);
        addTasksToModel(expectedModel);
        expectedModel.updateFilteredTaskList(predicate);
        assertCommandSuccess(command, model, expectedMessage, expectedModel);
        assertEquals(Collections.emptyList(), expectedModel.getFilteredTaskList());
    }
    private TaskNameContainsKeywordsPredicate preparePredicate(String userInput) {
        return new TaskNameContainsKeywordsPredicate(Arrays.asList(userInput.split("\\s+")));
    }
    private void addTasksToModel(Model model) {
        model.addTask(firstTask);
        model.addTask(secondTask);
        model.addTask(thirdTask);
        model.addTask(fourthTask);
    }
}
