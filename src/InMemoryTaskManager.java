import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InMemoryTaskManager implements TaskManager {
    private int id = 1;

    private HashMap<Integer, Task> tasks = new HashMap<>();
    private HashMap<Integer, EpicTask> epicTasks = new HashMap<>();
    private HashMap<Integer, SubTask> subTasks = new HashMap<>();
    HistoryManager historyManager = Managers.getHistory();

    @Override
    public Task saveTask(Task task) {
        task.setNumber(id++);
        tasks.put(task.getNumber(), task);
        return task;
    }

    @Override
    public EpicTask saveEpicTask(EpicTask epicTask) {
        epicTask.setNumber(id++);
        epicTasks.put(epicTask.getNumber(), epicTask);
        return epicTask;
    }

    @Override
    public SubTask saveSubTask(SubTask subTask) {
        subTask.setNumber(id++);
        subTasks.put(subTask.getNumber(), subTask);
        epicTasks.get(subTask.getPartOfEpic()).getListOfSubTasks().add(subTask.getNumber());
        updateEpicStatus(epicTasks.get(subTask.getPartOfEpic()));
        return subTask;
    }

    @Override
    public void deleteTask(int number) {
        tasks.remove(number);
    }

    @Override
    public void deleteSubTask(int number) {
        epicTasks.get(subTasks.get(number).getPartOfEpic()).getListOfSubTasks().remove((Integer) number);
        updateEpicStatus(epicTasks.get(subTasks.get(number).getPartOfEpic()));
        subTasks.remove(number);
    }

    @Override
    public void deleteEpicTask(int number) {
        for (Integer idST : epicTasks.get(number).getListOfSubTasks()) {
            subTasks.remove(idST);
        }
        epicTasks.remove(number);
    }

    @Override
    public void deleteAllTasks() {
        tasks.clear();
    }

    @Override
    public void deleteAllSubTasks() {
        for (Map.Entry<Integer, EpicTask> epicTask : epicTasks.entrySet()) {
            epicTask.getValue().getListOfSubTasks().clear();
            updateEpicStatus(epicTask.getValue());
        }
        subTasks.clear();
    }

    @Override
    public void deleteAllEpicTasks() {
        epicTasks.clear();
        subTasks.clear();
    }

    private void updateEpicStatus(EpicTask epicTask) {
        int counterNew = 0;
        int counterDone = 0;
        for (Integer numberSubTask : epicTask.getListOfSubTasks()) {
            SubTask subTask = subTasks.get(numberSubTask);
            switch ((subTask.getStatus())) {
                case NEW:
                    counterNew++;
                case DONE:
                    counterDone++;
            }
            if (counterNew == epicTask.getListOfSubTasks().size() || epicTask.getListOfSubTasks().isEmpty()) {
                epicTask.setStatus(Status.NEW);
                epicTasks.put(epicTask.getNumber(), epicTask);
            }
            if (counterDone == epicTask.getListOfSubTasks().size()) {
                epicTask.setStatus(Status.DONE);
                epicTasks.put(epicTask.getNumber(), epicTask);
            } else {
                epicTask.setStatus(Status.IN_PROGRESS);
                epicTasks.put(epicTask.getNumber(), epicTask);
            }
        }
    }

    @Override
    public ArrayList<SubTask> getSubtasksByEpicId(int number) {
        System.out.println("Подзадачи эпика " + number + ":");
        ArrayList<SubTask> subTasksOfEpic = new ArrayList<>();
        for (Integer id : epicTasks.get(number).getListOfSubTasks()) {
            System.out.println(subTasks.get(id).toString());
            subTasksOfEpic.add(subTasks.get(id));
        }
        return subTasksOfEpic;
    }

    @Override
    public Task getTaskById(int number) {    // добавлено помещение в историю
        historyManager.add(tasks.get(number));
        System.out.println(tasks.get(number).toString());
        return tasks.get(number);
    }

    @Override
    public SubTask getSubTaskById(int number) {    // добавлено помещение в историю
        historyManager.add(subTasks.get(number));
        System.out.println(subTasks.get(number).toString());
        return subTasks.get(number);
    }

    @Override
    public EpicTask getEpicTaskById(int number) {    // добавлено помещение в историю
        historyManager.add(epicTasks.get(number));
        System.out.println(epicTasks.get(number).toString());
        return epicTasks.get(number);
    }

    @Override
    public ArrayList<Task> getAllTasks() {
        System.out.println(tasks.toString());
        return new ArrayList<Task>(tasks.values());
    }

    @Override
    public ArrayList<SubTask> getAllSubTask() {
        System.out.println(subTasks.toString());
        return new ArrayList<SubTask>(subTasks.values());
    }

    @Override
    public ArrayList<EpicTask> getAllEpiTask() {
        System.out.println(epicTasks.toString());
        return new ArrayList<EpicTask>(epicTasks.values());
    }

    @Override
    public void updateTask(Task task) {
        tasks.put(task.getNumber(), task);
    }

    @Override
    public void updateSubTask(SubTask subtask) {
        subTasks.put(subtask.getNumber(), subtask);
    }

    @Override
    public void updateEpicTask(EpicTask epicTask) {
        updateEpicStatus(epicTask);
        epicTasks.put(epicTask.getNumber(), epicTask);
    }

}

