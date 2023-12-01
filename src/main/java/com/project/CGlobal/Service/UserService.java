package com.project.CGlobal.Service;

import com.project.CGlobal.Domain.dto.BaseResDto;
import com.project.CGlobal.Domain.dto.LoginDto;

public interface UserService {
    BaseResDto login(LoginDto loginDto);
}
