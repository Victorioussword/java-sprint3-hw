import java.util.ArrayList;
import java.util.List;

public class EpicTask extends Task {
   private ArrayList<Integer> listOfSubTasks = new ArrayList<>();

    public EpicTask(int number, String name,  String description) {
        super(number, name, Status.NEW, description);
        }


    public String toString() {
        if (listOfSubTasks.isEmpty()) {
            return " EpicTask - ID = " + getNumber() + ", Name = " + getName() + ", Description = " + getDescription()
                    + ", Status = " + getStatus() + " Quantity of SubTask = " + "0" + "\n";
        } else {
            return " EpicTask - ID = " + getNumber() + ", Name = " + getName() + ", Description = " + getDescription()
                    + ", Status = " + getStatus() + ", Quantity of SubTask = " + listOfSubTasks.size();
        }
    }
    public ArrayList<Integer> getListOfSubTasks() {
        return listOfSubTasks;
    }

    public void setListOfSubTasks (ArrayList<Integer> listOfSubTasks) {
        this.listOfSubTasks = listOfSubTasks;
    }
}
