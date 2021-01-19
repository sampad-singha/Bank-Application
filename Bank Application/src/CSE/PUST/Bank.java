package CSE.PUST;

import java.util.ArrayList;

public class Bank {
    private String bankName;
    private ArrayList<Branch> branches;

    public Bank(String bankName) {
        this.bankName = bankName;
        this.branches = new ArrayList<Branch>();
    }

    public boolean addBranch(String branchName){

        if(findBranch(branchName) == null){
            this.branches.add(new Branch(branchName));
            return true;
        }
        return false;
    }

    public boolean addNewCustomer(String branchName, String customerName, double initialAmount){
        Branch oldBranch = findBranch(branchName);

        if (oldBranch != null){
            return oldBranch.addNewCustomer(customerName, initialAmount);
        }
        return false;
    }

    public boolean addTransaction(String branchName, String customerName, double amount){
        Branch oldBranch = findBranch(branchName);

        if(oldBranch != null){
            return oldBranch.addTransaction(customerName, amount);
        }
        return false;
    }

    private Branch findBranch(String branchName){
        for(int i = 0; i < branches.size(); i++){
            Branch oldBranch = this.branches.get(i);

            if (oldBranch.getBranchName().equals(branchName)){
                return oldBranch;
            }
        }
        return null;
    }
}
