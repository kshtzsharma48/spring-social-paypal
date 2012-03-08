package org.springframework.social.paypal.connect;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.social.paypal.api.PayPal;
import org.springframework.social.paypal.api.PayPalProfile;
import org.springframework.social.paypal.api.PayPalProfileMock;
import org.springframework.social.paypal.api.impl.PayPalTemplate;
import org.springframework.social.paypal.connect.PayPalAdapter;


public class PayPalAdapterTest {
    
    private PayPalAdapter apiAdapter = new PayPalAdapter();
    private PayPal paypal = Mockito.mock(PayPalTemplate.class);

    @Test
    public void testFetchUserProfile() {
        Mockito.when(paypal.getUserProfile()).thenReturn(new PayPalProfileMock());
        PayPalProfile testProfile = paypal.getUserProfile();
        assertEquals("Marty", testProfile.getFirstName());
        assertEquals("McFly", testProfile.getLastName());
        assertEquals("marty@outatime.com", testProfile.getEmails().get(0));
    }

    @Test
    public void testSetConnectionValues() {
        Mockito.when(paypal.getUserProfile()).thenReturn(new PayPalProfileMock());
        ConnectionValuesMock values = new ConnectionValuesMock();
        apiAdapter.setConnectionValues(paypal, values);
        assertEquals("Marty McFly", values.displayName);
        assertEquals("hash123", values.providerUserId);
        assertNull(values.imageUrl); // PayPal does not provide a public profile url
        assertNull(values.profileUrl);  // PayPal does not provide a public profile url
    }

    @Test
    public void testTest() {
        Mockito.when(paypal.getUserProfile()).thenReturn(new PayPalProfileMock());
        assertTrue(apiAdapter.test(paypal));
        
        Mockito.when(paypal.getUserProfile()).thenReturn(null);
        assertFalse(apiAdapter.test(paypal));
    }

}
