package com.mycompany.loanaccount;

public class LoanAccount{
    private int principal;
    private static double annualInterestRate;
    
    public static void setAnnualInterestRate(int value){
        annualInterestRate = value * 0.01;
    }
    
    public void setPrincipal(int principal) {
        this.principal = principal;
    }

    public double calculateMonthlyPayment(int numberOfPayments){
        double monthlyInterest = annualInterestRate/12;
        double monthlyPayment = principal * (monthlyInterest/(1-Math.pow(1+monthlyInterest, -numberOfPayments)));
        return monthlyPayment;
    }
    
    public static void main(String[] args) {
        LoanAccount loan1 = new LoanAccount();
        loan1.setPrincipal(5000);
        LoanAccount loan2 = new LoanAccount();
        loan2.setPrincipal(31000);
        
        setAnnualInterestRate(1);
        
        System.out.print("Montly payments for loan1 of $5000.00 and $31000.00 for 3, 5, and 6 year loans at 1% interest\n");
        System.out.printf("%s%10s%10s%10s%n", "Loan ", "3 years", "5 years", "6 years");
        System.out.printf("%s%10s%10s%10s%n", "Loan1", String.format("%.2f", loan1.calculateMonthlyPayment(36)), String.format("%.2f", loan1.calculateMonthlyPayment(60)), String.format("%.2f", loan1.calculateMonthlyPayment(72)));
        System.out.printf("%s%10s%10s%10s%n", "Loan2", String.format("%.2f", loan2.calculateMonthlyPayment(36)), String.format("%.2f", loan2.calculateMonthlyPayment(60)), String.format("%.2f", loan2.calculateMonthlyPayment(72)));
        
        setAnnualInterestRate(5);
        
        System.out.print("\n\nMontly payments for loan1 of $5000.00 and $31000.00 for 3, 5, and 6 year loans at 5% interest\n");
        System.out.printf("%s%10s%10s%10s%n", "Loan ", "3 years", "5 years", "6 years");
        System.out.printf("%s%10s%10s%10s%n", "Loan1", String.format("%.2f", loan1.calculateMonthlyPayment(36)), String.format("%.2f", loan1.calculateMonthlyPayment(60)), String.format("%.2f", loan1.calculateMonthlyPayment(72)));
        System.out.printf("%s%10s%10s%10s%n", "Loan2", String.format("%.2f", loan2.calculateMonthlyPayment(36)), String.format("%.2f", loan2.calculateMonthlyPayment(60)), String.format("%.2f", loan2.calculateMonthlyPayment(72)));
        
        
        
    }
}
