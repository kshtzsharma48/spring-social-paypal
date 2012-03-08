package org.springframework.social.paypal.connect;

import static org.junit.Assert.*;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.springframework.social.paypal.connect.PayPalProfileRestResponse;
import org.springframework.social.paypal.connect.PayPalProfileRestResponse.Status;


public class PayPalProfileRestResponseTest {

    @Test
    public void testJsonParsing() throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
        PayPalProfileRestResponse response = mapper.readValue(getClass().getResourceAsStream("/paypal-api-response.json"), 
                PayPalProfileRestResponse.class);
        assertEquals(Status.SUCCESS, response.getStatus());
        assertEquals("Doc", response.getIdentity().getFirstName());
        assertEquals("Brown", response.getIdentity().getLastName());
        assertEquals("Hill Valley", response.getIdentity().getAddresses().get(0).getCity());
        assertEquals("CA", response.getIdentity().getAddresses().get(0).getState());
    }

}
