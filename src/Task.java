public class Task {
    private int number;
    private String name;
    private  String description;
    private Status status;


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }



    public Task(int number, String name, Status status, String description) {
        this.number = number;
        this.name = name;
        this.status = status;
        this.description = description;
    }

    public String toString(){
        return " Task - ID = "+ number+", Name = " + name +", Description = "+description + ", Status =" + status;
    }
}
