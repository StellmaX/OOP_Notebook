import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class NotebookPresenter {
    private Notebook notebook;
    private NotebookView view;

    public NotebookPresenter(Notebook notebook, NotebookView view) {
        this.notebook = notebook;
        this.view = view;
    }

    public void addNote() {
        view.showMessage("Введите описание заметки:");
        String description = view.getInput();

        view.showMessage("Введите дату и время (format: yyyy-MM-dd HH:mm):");
        String dateTimeStr = view.getInput();
        
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr, formatter);
            notebook.addNote(new Note(description, dateTime));
            view.showMessage("Заметка успешно добавлена.");
        } catch (Exception e) {
            view.showError("Неверный формат даты. Пожалуйста, попробуйте снова.");
        }
    }

    public void showNotesForDay() {
        view.showMessage("Введите дату (format: yyyy-MM-dd):");
        String dateStr = view.getInput();

        try {
            LocalDate date = LocalDate.parse(dateStr);
            List<Note> notes = notebook.getNotesForDay(date);
            if (notes.isEmpty()) {
                view.showMessage("Нет заметок на этот день.");
            } else {
                view.showNotes(notes);
            }
        } catch (Exception e) {
            view.showError("Неверный формат даты. Пожалуйста, попробуйте снова.");
        }
    }

    public void showNotesForWeek() {
        view.showMessage("Введите дату (format: yyyy-MM-dd) чтобы найти заметки за неделю:");
        String dateStr = view.getInput();

        try {
            LocalDate date = LocalDate.parse(dateStr);
            List<Note> notes = notebook.getNotesForWeek(date);
            if (notes.isEmpty()) {
                view.showMessage("Нет заметок на эту неделю.");
            } else {
                view.showNotes(notes);
            }
        } catch (Exception e) {
            view.showError("Неверный формат даты. Пожалуйста, попробуйте снова.");
        }
    }
}