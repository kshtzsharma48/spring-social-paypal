package org.springframework.social.paypal.api;

import java.util.ArrayList;

import org.springframework.social.paypal.api.PayPalProfile;

public class PayPalProfileMock extends PayPalProfile {
    
    public PayPalProfileMock() {
        this.firstName = "Marty";
        this.lastName = "McFly";
        this.fullName = "Marty McFly";
        this.userId = "hash123";
        this.emails = new ArrayList<String>();
        this.emails.add("marty@outatime.com");
        this.addresses = new ArrayList<Address>();
        
        Address address0 = new Address();
        address0.city = "Hill Valley";
        address0.state = "CA";
        address0.country = "USA";
        address0.street1 = "1640 John F. Kennedy Drive";
        address0.street2 = "";
        address0.zip = "90987";
        this.addresses.add(address0);
             
    }

}
