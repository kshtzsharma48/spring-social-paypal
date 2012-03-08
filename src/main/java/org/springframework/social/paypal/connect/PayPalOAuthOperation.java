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
package org.springframework.social.paypal.connect;

import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.social.oauth2.OAuth2Template;

/**
 * Implements an OAuth facility for PayPal with the predefined API URLs.
 * 
 * @author Felipe Albetao
 *
 */
public class PayPalOAuthOperation extends OAuth2Template {

    public PayPalOAuthOperation(String clientId, String clientSecret) {
        super(clientId, clientSecret, 
                "https://identity.x.com/xidentity/resources/authorize", 
                "https://identity.x.com/xidentity/oauthtokenservice");
    }

    @Override
    public String buildAuthenticateUrl(GrantType grantType, OAuth2Parameters parameters) {
        return super.buildAuthenticateUrl(grantType, fixedScope(parameters));
    }

    @Override
    public String buildAuthorizeUrl(GrantType grantType, OAuth2Parameters parameters) {
        return super.buildAuthorizeUrl(grantType, fixedScope(parameters));
    }
    
    private OAuth2Parameters fixedScope(OAuth2Parameters parameters) {
        parameters.setScope("https://identity.x.com/xidentity/resources/profile/me");
        return parameters;
    }
    
    

}
