package grzechu16.todolistm;

/**
 * Created by Gregory on 2017-08-19.
 */

public class ToDoTask {

    private String title;
    private String description;
    private String date;
    private Boolean isDone;

    public String getTitle() {
        return title;
    }

    public ToDoTask(String title, String description, String date, Boolean isDone) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.isDone = isDone;
    }

    @Override
    public String toString() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public Boolean getDone() {
        return isDone;
    }
}
