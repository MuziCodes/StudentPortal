// Ahmed khursheed

public abstract class Person {
    private String name;
    private int ID;

    public Person(String name, int ID) {
        this.name = name;
        this.ID = ID;
    }

    public String get_info() {
        return "Name: " + name + "\nID: " + ID;
    }

    public void update_info(String name, int ID) {
        this.name = name;
        this.ID = ID;
    }
}