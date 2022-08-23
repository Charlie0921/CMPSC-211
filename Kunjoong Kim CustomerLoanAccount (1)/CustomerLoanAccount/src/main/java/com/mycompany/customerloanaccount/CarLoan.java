
package com.mycompany.customerloanaccount;

public class CarLoan extends LoanAccount {

    private String vehicleVIN;
    
    public CarLoan(double principle, double annualInterestRate, int months, String vehicleVIN) {
        super(principle, annualInterestRate, months);
        this.vehicleVIN = vehicleVIN;
    }

    @Override
    public String toString() {
        return String.format("Car Loan with:\n%sVehicle VIN: %s\n", super.toString(),this.vehicleVIN);
    }
    
}
