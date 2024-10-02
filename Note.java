import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Note {
    private String description;
    private LocalDateTime dateTime;

    public Note(String description, LocalDateTime dateTime) {
        this.description = description;
        this.dateTime = dateTime;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return dateTime.format(formatter) + " - " + description;
    }
}