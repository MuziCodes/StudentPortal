// Ahmed khursheed

public abstract class Person {
    private String name;
    private String ID;

    public Person(String name, String ID) {
        this.name = name;
        this.ID = ID;
    }

    public String get_name() {
        return  name ;
    }
    public String get_id() {
        return  ID;
    }
    public void update_info(String name, int ID) {
        this.name = name;
        this.ID = ID;
    }
    public void displayInfo() {
   System.out.println("Name:"+ name);
   System.out.println("ID:"+ ID);
        
}
