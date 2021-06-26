package com.poverty.service;

import com.poverty.entity.Result;
import com.poverty.entity.dto.Login;

/**
 * @author  LI
 */
public interface LoginService {
    Result login(Login login);
}
