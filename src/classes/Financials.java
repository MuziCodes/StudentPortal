// Fasih Siddique

//The fee tracking feature of the portal allows students to manage their financial obligations easily. The system displays a clear overview of due fees, including tuition, registration, and other associated costs. Students receive notifications about upcoming payment deadlines and can track their payment history. The portal also offers options for online payment processing, ensuring that students can manage their fees conveniently and securely without the need for in-person transactions.

package classes;

public class Financials {
    private String studentID;
    private double tuitionFee;
    private double paidAmount;
    private String dueDate;

    public Financials(String studentID, double tuitionFee, double paidAmount, String dueDate) {
        this.studentID = studentID;
        this.tuitionFee = tuitionFee;
        this.paidAmount = paidAmount;
        this.dueDate = dueDate;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public double getTuitionFee() {
        return tuitionFee;
    }

    public void setTuitionFee(double tuitionFee) {
        this.tuitionFee = tuitionFee;
    }

    public double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(double paidAmount) {
        this.paidAmount = paidAmount;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public double calculateBalance() {
        return tuitionFee - paidAmount;
    }

    public void updatePayment(double amount) {
        if (amount > 0) {
            paidAmount += amount;
            System.out.println("Payment of " + amount + " added successfully. Total Paid: " + paidAmount);
        } else {
            System.out.println("Invalid payment amount.");
        }
    }

    public boolean isFullyPaid() {
        return calculateBalance() <= 0;
    }

    public void displayFinancials() {
        System.out.println("Financial Details for Student ID: " + studentID);
        System.out.println("Tuition Fee: " + tuitionFee);
        System.out.println("Paid Amount: " + paidAmount);
        System.out.println("Outstanding Balance: " + calculateBalance());
        System.out.println("Due Date: " + dueDate);
        System.out.println("Status: " + (isFullyPaid() ? "Fully Paid" : "Pending"));
    }
}
