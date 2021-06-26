package com.poverty.service;

import com.poverty.entity.Result;
import com.poverty.entity.dto.Login;
import com.poverty.entity.dto.PostId;
import com.poverty.entity.dto.SignUp;

/**
 * @author  LI
 */
public interface LoginService {
    Result login(Login login);

    Result logout(PostId id);

    Result signUpUser(SignUp signUp) throws Exception;

    Result signUpAdmin(SignUp signUp) throws Exception;
}
