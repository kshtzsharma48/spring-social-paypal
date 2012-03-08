/*
 * Copyright 2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.paypal.api;

import java.util.List;

public class PayPalProfile {
    
    String status;
    String language;
    String fullName;
    String userId;
    String dob;
    List<PayPalProfile.Address> addresses;
    List<String> emails;
    String firstName;
    String lastName;
    String telephoneNumber;
    
    public static class Address {
        
        String state;
        String country;
        String street1;
        String street2;
        String city;
        String zip;
        
        public String getState() {
            return state;
        }
        
        public String getCountry() {
            return country;
        }
        
        public String getStreet1() {
            return street1;
        }
        
        public String getStreet2() {
            return street2;
        }
        
        public String getCity() {
            return city;
        }
        
        public String getZip() {
            return zip;
        }
        
    }

    public String getStatus() {
        return status;
    }

    public String getLanguage() {
        return language;
    }

    public String getFullName() {
        return fullName;
    }

    public String getUserId() {
        return userId;
    }

    public String getDob() {
        return dob;
    }

    public List<PayPalProfile.Address> getAddresses() {
        return addresses;
    }

    public List<String> getEmails() {
        return emails;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }
    
}