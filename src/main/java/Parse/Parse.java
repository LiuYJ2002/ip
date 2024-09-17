package Parse;

import Storage.Storage;
import Task.TaskList;
import Ui.Ui;
import Exception.MissingArg;
import Exception.WrongKeyword;
public class Parse {
    private static final int todoParseSplitIndex = 5;
    private static final int deadlineParseSplitIndex = 9;
    private static final int eventParseSplitIndex = 6;
    private static final int findParseSplitIndex = 5;
    private static final String deadlineSplitBy = " /by ";
    private static final String eventSplitBy = " /from | /to ";
    /**
     * Parses a Todo input string to get the task description.
     *
     * @param input the input string
     * @return the task description as a string
     */
    public static String parseTodo(String input) throws MissingArg{
        if (input.replaceAll("\\s", "").length() <= 4) {
            throw new MissingArg("Please enter a task for Todo");
        }
        return input.substring(todoParseSplitIndex);
    }
    /**
     * Parses a Deadline input string to get the task description and the deadline.
     *
     * @param input the input string
     * @return an array of strings
     */
    public static String[] parseDeadline(String input) throws MissingArg{
        String[] s = input.substring(deadlineParseSplitIndex).split(deadlineSplitBy);
        if (s.length != 2) {
            throw new MissingArg("Wrong number of arguments for deadline task!");
        }
        return s;
    }
    /**
     * Parses an Event input string to get the task description, start time, and end time.
     *
     * @param input the input string
     * @return an array of strings
     */
    public static String[] parseEvent(String input) throws MissingArg{
        if (!input.contains("/from") || !input.contains("/to")) {
            throw new MissingArg("Wrong number of arguments for event task!");
        }
        String[] s = input.substring(eventParseSplitIndex).split(eventSplitBy);
        if (s.length != 3) {
            throw new MissingArg("Wrong number of arguments for event task!");
        }
        return s;
    }
    public static String parseFind(String input) {
        return input.substring(findParseSplitIndex);
    }
    /**
     * Initial parsing of user commands and updates the task list,storage and ui accordingly.
     *
     * @param input the user input
     * @param ui the user interface class instance
     * @param tasks the task list class instance
     * @param storage the storage class instance
     * @return false if user entered "bye" and true oterwise
     */
    public static String initialParse(String input, Ui ui, TaskList tasks, Storage storage) {
        if (input.equals("bye")) {
            return ui.uiBye();
        } else if (input.equals("list")) {
            return tasks.handleList();
        } else if (input.startsWith("mark")) {
            return tasks.markDone(input, storage);
        } else if (input.startsWith("unmark")) {
            return tasks.markUnDone(input, storage);
        } else if (input.startsWith("delete")) {
            return tasks.delete(input, storage);
        } else if (input.startsWith("find")) {
            return tasks.search(input);
        } else if (input.equals("sort")) {
            return tasks.sort(storage);
        }
        try {
            return tasks.handleTask(input, storage);
        } catch (WrongKeyword e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }


    }

}
