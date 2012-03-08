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
package org.springframework.social.paypal.api.impl;

import java.net.URI;

import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.paypal.api.PayPal;
import org.springframework.social.paypal.api.PayPalProfile;
import org.springframework.social.paypal.connect.PayPalProfileRestResponse;
import org.springframework.social.support.URIBuilder;

public class PayPalTemplate extends AbstractOAuth2ApiBinding implements PayPal {
    
    private String PROFILE_SERVICE_ENDPOINT = "https://identity.x.com/xidentity/resources/profile/me";
    
    private String accessToken;
    
    public PayPalTemplate() {} // Used if token was not obtained

    public PayPalTemplate(String accessToken) {
        super(accessToken);
        this.accessToken = accessToken;
    }

    @Override
    public PayPalProfile getUserProfile() {
        PayPalProfileRestResponse response = getRestTemplate().getForObject(buildURI(), PayPalProfileRestResponse.class);
        return response.getIdentity();
    }
    
    URI buildURI() {
        return URIBuilder.fromUri(PROFILE_SERVICE_ENDPOINT).queryParam("oauth_token", this.accessToken).build();
    }
    
}
