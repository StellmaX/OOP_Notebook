import java.util.List;

public interface NotebookView {
    void showNotes(List<Note> notes);
    void showMessage(String message);
    void showError(String error);
    String getInput();
}