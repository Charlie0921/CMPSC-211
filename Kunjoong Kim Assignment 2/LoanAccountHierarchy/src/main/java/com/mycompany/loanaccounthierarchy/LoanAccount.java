
package com.mycompany.loanaccounthierarchy;

public class LoanAccount {
    private double principle;
    private double annualInterestRate;
    private int months;
    
    
    public LoanAccount(double principle, double annualInterestRate, int months) {
        this.principle = principle;
        this.annualInterestRate = annualInterestRate;
        this.months = months;
    }

    public double getPrinciple() {
        return principle;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public int getMonths() {
        return months;
    }
    
    public double calculateMonthlyPayment(){
        double monthlyInterest = (annualInterestRate*0.01)/12;
        double monthlyPayment = principle * (monthlyInterest/(1-Math.pow(1+monthlyInterest, -months)));
        return monthlyPayment;
    }

    @Override
    public String toString() {
        return String.format("Principal: $%.2f\nAnnual Interest Rate: %.2f%%\nTerm of Loan in Months: %s\nMonthly Payment: $%.2f\n", getPrinciple(),getAnnualInterestRate(),getMonths(),this.calculateMonthlyPayment());
    }
    
}
