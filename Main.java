public class Main {
    public static void main(String[] args) {
        Notebook notebook = new Notebook();
        NotebookView view = new ConsoleNotebookView();
        NotebookPresenter presenter = new NotebookPresenter(notebook, view);

        view.showMessage("Добро пожаловать в приложение Notebook");
        boolean exit = false;

        while (!exit) {
            view.showMessage("Выберите нужный вариант: \n1. Добавить примечание\n2. Показывать заметки за день\n3. Показывать заметки за неделю\n4. Выход");
            String choice = view.getInput();

            switch (choice) {
                case "1":
                    presenter.addNote();
                    break;
                case "2":
                    presenter.showNotesForDay();
                    break;
                case "3":
                    presenter.showNotesForWeek();
                    break;
                case "4":
                    exit = true;
                    break;
                default:
                    view.showError("Неверный выбор. Пожалуйста, попробуйте снова.");
                    break;
            }
        }

        view.showMessage("До свидания!");
    }
}