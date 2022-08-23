
package com.mycompany.loanaccounthierarchy;

public class PrimaryMortgage extends LoanAccount{
    private double PMIMonthlyAmount;
    private Address address ;

    public PrimaryMortgage(double principle, double annualInterestRate, int months, double PMIMonthlyAmount, Address address) {
        super(principle, annualInterestRate, months);
        this.PMIMonthlyAmount = PMIMonthlyAmount;
        this.address = address;
    }
   

    @Override
    public String toString() {
        return String.format("\nPrimary Mortgage Loan with: \n%sPMI Monthly Amount: $%s\n%s\n",super.toString(),this.PMIMonthlyAmount,this.address.toString());
    }
}
