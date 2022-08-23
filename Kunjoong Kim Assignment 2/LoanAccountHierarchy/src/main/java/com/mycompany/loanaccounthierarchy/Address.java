
package com.mycompany.loanaccounthierarchy;

public class Address {

    private String street;
    private String city;
    private String state;
    private String zipcode;
    
    public Address(String street, String city, String state, String zipcode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }

    @Override
    public String toString() {
        return String.format("Property Address: \n    %s\n    %s, %s %s",this.street,this.city,this.state,this.zipcode);
    }
        
}
