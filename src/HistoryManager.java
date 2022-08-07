import java.util.List;

public interface HistoryManager {

    public void add (Task task);

    public List<Task>  getHistory ();

    public void printHistory();   // вспомогательный метод для контроля и визуализации работы програмы

}
