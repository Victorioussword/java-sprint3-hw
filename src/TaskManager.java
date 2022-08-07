import java.util.ArrayList;
import java.util.List;

public interface TaskManager {

    public Task saveTask(Task task);

    public EpicTask saveEpicTask(EpicTask epicTask);

    public SubTask saveSubTask(SubTask subTask);

    public void deleteTask(int number);

    public void deleteSubTask(int number);

    public void deleteEpicTask(int number);

    public void deleteAllTasks();

    public void deleteAllSubTasks();

    public void deleteAllEpicTasks();

    public ArrayList<SubTask> getSubtasksByEpicId(int number);

    public Task getTaskById(int number);

    public SubTask getSubTaskById(int number);

    public EpicTask getEpicTaskById(int number);

    public ArrayList<Task> getAllTasks();

    public ArrayList<SubTask> getAllSubTask();

    public ArrayList<EpicTask> getAllEpiTask();

    public void updateTask(Task task);

    public void updateSubTask(SubTask subtask);

    public void updateEpicTask(EpicTask epicTask);

}

