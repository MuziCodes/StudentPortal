// Fasih Siddique

//The fee tracking feature of the portal allows students to manage their financial obligations easily. The system displays a clear overview of due fees, including tuition, registration, and other associated costs. Students receive notifications about upcoming payment deadlines and can track their payment history. The portal also offers options for online payment processing, ensuring that students can manage their fees conveniently and securely without the need for in-person transactions.

public class Financials {
    private Student student;
    private double tuition_fee;
    private String due_date;

    public Financials(Student student, double tuition_fee, String due_date) {
        this.student = student;
        this.tuition_fee = tuition_fee;
        this.due_date = due_date;
    }

    public void update_fees() {
        // Implementation
    }

    public void check_due_fees() {
        // Implementation
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public double getTuition_fee() {
        return tuition_fee;
    }

    public void setTuition_fee(double tuition_fee) {
        this.tuition_fee = tuition_fee;
    }

    public String getDue_date() {
        return due_date;
    }

    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }
}