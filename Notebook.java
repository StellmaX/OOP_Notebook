import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class Notebook {
    private List<Note> notes = new ArrayList<>();

    public void addNote(Note note) {
        notes.add(note);
    }

    public List<Note> getNotes() {
        return notes;
    }

    public List<Note> getNotesForDay(LocalDate day) {
        List<Note> result = new ArrayList<>();
        for (Note note : notes) {
            if (note.getDateTime().toLocalDate().equals(day)) {
                result.add(note);
            }
        }
        result.sort(Comparator.comparing(Note::getDateTime));
        return result;
    }

    public List<Note> getNotesForWeek(LocalDate date) {
        List<Note> result = new ArrayList<>();
        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        int targetWeek = date.get(weekFields.weekOfWeekBasedYear());

        for (Note note : notes) {
            int noteWeek = note.getDateTime().get(weekFields.weekOfWeekBasedYear());
            if (noteWeek == targetWeek) {
                result.add(note);
            }
        }
        result.sort(Comparator.comparing(Note::getDateTime));
        return result;
    }
}