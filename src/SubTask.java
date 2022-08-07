public class SubTask extends Task {
    private int partOfEpic;

    public SubTask(int number, String name, Status status, String description, int partOfEpic) {
        super(number, name, status, description);
        this.partOfEpic = partOfEpic;
    }

    public String toString() {
        return " SubTask - ID = " + getNumber() + ", Name = " + getName() + ", Description = " + getDescription() + ", Status = "
                + getStatus() + ", Part of EpicTask = "+ partOfEpic;
    }

    public int getPartOfEpic() {
        return partOfEpic;
    }

    public void setPartOfEpic(int partOfEpic) {
        this.partOfEpic = partOfEpic;
    }
}