package com.poverty.configure;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/13 21:40
 */
public class MyHashedCredentialsMatcher extends HashedCredentialsMatcher  {

    public MyHashedCredentialsMatcher(String hashAlgorithmName) {
        super(hashAlgorithmName);
    }

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        Object tokenHashedCredentials = this.hashProvidedCredentials(token, info);
        if ("".equals(tokenHashedCredentials)) {
            return true;
        }
        Object accountCredentials = this.getCredentials(info);
        return this.equals(tokenHashedCredentials, accountCredentials);
    }
}
