
package com.mycompany.customerloanaccount;

public class UnsecuredLoan extends LoanAccount{

    public UnsecuredLoan(double principle, double annualInterestRate, int months) {
        super(principle, annualInterestRate, months);
    }

    @Override
    public String toString() {
        return String.format("\nUnsecured Loan with: \n%s",super.toString());
    }
   
}
