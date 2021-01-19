package CSE.PUST;

import java.util.ArrayList;

public class Branch {
    private String branchName;
    private ArrayList<Customer> customers;

    public Branch(String branchName) {
        this.branchName = branchName;
        this.customers = new ArrayList<Customer>();
    }

    public boolean addNewCustomer(String customerName, double initialAmount){
        if(findCustomer(customerName) == null){
            this.customers.add(new Customer(customerName,initialAmount));
            return true;
        }
        return false;
    }

    public boolean addTransaction(String customerName, double amount){
        Customer oldCustomer = findCustomer(customerName);

        if(oldCustomer != null){
            oldCustomer.addTransaction(amount);
            return true;
        }
        return false;
    }

    public String getBranchName() {
        return branchName;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public Customer findCustomer(String customerName){
        for (int i = 0; i < customers.size(); i++){
            Customer searchCustomer = this.customers.get(i);

            if (searchCustomer.getName().equals(customerName)){
                return searchCustomer;
            }
        }
        return null;
    }
}
