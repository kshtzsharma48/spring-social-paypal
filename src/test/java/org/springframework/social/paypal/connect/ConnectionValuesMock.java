package org.springframework.social.paypal.connect;

import org.springframework.social.connect.ConnectionValues;

public class ConnectionValuesMock implements ConnectionValues {

    String displayName;
    String imageUrl;
    String profileUrl;
    String providerUserId;

    @Override
    public void setProviderUserId(String providerUserId) {
        this.providerUserId = providerUserId;
    }

    @Override
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public void setProfileUrl(String profileUrl) {
        this.setProfileUrl(profileUrl);
    }

    @Override
    public void setImageUrl(String imageUrl) {
        this.setImageUrl(imageUrl);
    }

}
