package com.mycompany.customerloanaccount;

import java.util.ArrayList;

public class Customer {
    private String firstName;
    private String lastName;
    private String SSN;
    private ArrayList<LoanAccount> loanAccounts = new ArrayList<LoanAccount>();

    public Customer(String firstName, String lastName, String SSN) {
        
        this.firstName = firstName;
        this.lastName = lastName;
        this.SSN = SSN;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSSN() {
        return SSN;
    }
    
    public void addLoanAccount(LoanAccount account){
        this.loanAccounts.add(account);
    }
    

    public String printMonthlyReport(){
        String value = String.format("Account Report for Customer: %s %s with SSN %s  \n\n",this.firstName,this.lastName,this.SSN);
        int size = this.loanAccounts.size();
        for (int i = 0; i < size; i++) {
            value += this.loanAccounts.get(i).toString();
            value += "\n";
        }
        return value;
    }
}
   
