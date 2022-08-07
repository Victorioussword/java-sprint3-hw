import java.util.ArrayList;
import java.util.List;

public class InMemoryHistoryManager implements HistoryManager {

    private List<Task> history = new ArrayList();

    @Override
    public void add(Task task) {
        history.add(task);
        if (history.size() > 10) {
            history.remove(0);
        }
    }

    @Override
    public List<Task> getHistory() {
        return history;
    }


    @Override
    public void printHistory() {        // вспомогательный метод для контроля и визуализации работы програмы
        System.out.println("\n История просмоторов:");
        for (int j = history.size(); j >= 1; j--) {
            System.out.println(history.get(j - 1));
        }
        System.out.println("Окончание истории просмотров.\n");
    }

}
