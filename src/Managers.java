public class Managers {

   public static TaskManager getDefault(){
       return new InMemoryTaskManager();
    }
public static  HistoryManager getHistory () {
       return new InMemoryHistoryManager();
    }

}


/**
 * Метод getDefault() будет без параметров. Он должен возвращать объект-менеджер, поэтому типом его возвращаемого значения будет TaskManager.*/


/**
 * Добавьте в служебный класс Managers статический метод HistoryManager getDefaultHistory().
 * Он должен возвращать объект InMemoryHistoryManager — историю просмотров.
 *
 * Проверьте, что теперь InMemoryTaskManager обращается к менеджеру истории через
 * интерфейс HistoryManager и использует реализацию, которую возвращает метод getDefaultHistory().
 *
 *
 *
 *
 * Да там вроде просто всё, в классе два метода: getDefault и getHistory,
 * и тот и другой возвращают новый инстанс классов InMemoryTaskManager и InMemoryHistoryManager соответственно*/