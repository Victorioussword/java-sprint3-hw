
public class Main {
    public static void main(String args[]) {

        InMemoryTaskManager taskManager = (InMemoryTaskManager) Managers.getDefault();

/**
 Спринт 3
 */

        /**
         * Создание Task
         */
        Task task1 = new Task(1, "Задача1", Status.NEW, "Описание задачи1");
        Task task2 = new Task(2, "Задача2", Status.NEW, "Описание задачи2");

        /**
         * Создание subTask
         */
        SubTask subTask11 = new SubTask(1, "Подзадача11", Status.DONE, "Описание Подзадачи11", 3);
        SubTask subTask12 = new SubTask(2, "Подзадача12", Status.DONE, "Описание Подзадачи12", 3);
        SubTask subTask21 = new SubTask(3, "Подзадача21", Status.NEW, "Описание Подзадачи21", 4);

        /**
         * Создание epicTask
         */
        EpicTask epicTask1 = new EpicTask(1, "Эпик1", "Описание Эпика1");
        EpicTask epicTask2 = new EpicTask(2, "Эпик2", "Описание Эпика2");

        /**
         * Сохранение Task, EpicTask и SubTask
         */
        taskManager.saveTask(task1);
        taskManager.saveTask(task2);
        taskManager.saveEpicTask(epicTask1);
        taskManager.saveEpicTask(epicTask2);
        taskManager.saveSubTask(subTask11);
        taskManager.saveSubTask(subTask12);
        taskManager.saveSubTask(subTask21);

        /**
         * Обновление
         * Обновление статуса epicTask
         */
        System.out.println(epicTask1.toString());
        System.out.println(epicTask2.toString());
        System.out.println("\n" + "Обновление: ");
        taskManager.updateTask(task1);
        taskManager.updateSubTask(subTask11);
        taskManager.updateEpicTask(epicTask1);

        /**
         * Получение Task
         */
        System.out.println("\n" + "Получение Task:");
        System.out.println("Отдельные Task");
        taskManager.getTaskById(1);
        taskManager.getTaskById(2);
        System.out.println("\n" + "Список Task");
        taskManager.getAllTasks();

        /**
         * Получение EpicTask
         */
        System.out.println("\n" + "Получение EpicTask:");
        System.out.println("EpicTask");
        taskManager.getEpicTaskById(3);
        taskManager.getEpicTaskById(4);
        System.out.println("\n" + "Список EpicTask");
        taskManager.getAllEpiTask();
        System.out.println("\n" + "Все Subtask по номеру EpicTask");
        taskManager.getSubtasksByEpicId(3);
        taskManager.getSubtasksByEpicId(4);

        /**
         * Получение SubTask
         */
        System.out.println("\n" + "Печать подзадач:");
        System.out.println("Отдельные подзадачи");
        taskManager.getSubtasksByEpicId(3);
        taskManager.getSubtasksByEpicId(4);
        System.out.println("\n" + "Список подзадач");
        taskManager.getAllSubTask();
        taskManager.getSubTaskById(5);


        /**
         * Удаление задач разного типа по номеру
         */
        System.out.println("\n" + "После удаления" + "\n");

        /**
         * Удаление Task
         */
        taskManager.deleteTask(1);
        //   taskManager.deleteAllTasks();         // закомментировано для проверки задания Спринта №4
        System.out.println("Список Task после удаления");
        taskManager.getAllTasks();

        /**
         * Удаление SubTask
         */
        taskManager.deleteSubTask(6);
        taskManager.getAllSubTask();
        //   taskManager.deleteAllSubTasks();
        System.out.println("\n" + "Список SubTask после удаления");
        taskManager.getAllSubTask();

        /**
         * Удаление EpicTask
         */
        taskManager.deleteEpicTask(3);
        System.out.println("\n" + "Список EpicTask после удаления одного EpicTask");
        taskManager.getAllEpiTask();
        System.out.println("\n" + "Список EpicTask после удаления всех EpicTask");
        // taskManager.deleteAllEpicTasks();       // закомментировано для проверки задания Спринта №4
        taskManager.getAllEpiTask();

/**
 Спринт 4
 */

        System.out.println("\nТестирование спринта 4");
        System.out.println("Создание элемента");
        Task task3 = new Task(1, "Задача3", Status.NEW, "Описание задачи3");
        taskManager.saveTask(task3);
        System.out.println("Обращение к элементам");
        taskManager.getTaskById(8);
        taskManager.getTaskById(8);
        taskManager.getTaskById(2);
        taskManager.getTaskById(2);
        taskManager.getEpicTaskById(4);
        taskManager.getSubTaskById(7);
        taskManager.getTaskById(2);
        taskManager.getTaskById(8);
        taskManager.getTaskById(8);
        taskManager.getTaskById(8);
        taskManager.getTaskById(8);
        System.out.println("\nОтображение истории обращения к элементам");
        taskManager.historyManager.printHistory();
        }
}
