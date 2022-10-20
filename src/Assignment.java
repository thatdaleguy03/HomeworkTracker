package src;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Assignment {
    String title;
    String description;
    LocalDateTime dueDate;

    public Assignment(String title, String description, LocalDateTime dueDate) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
    }

    public Assignment(String title, LocalDateTime dueDate) {
        this(title, "", dueDate);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }
}