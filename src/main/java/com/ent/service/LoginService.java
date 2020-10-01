package com.ent.service;

import com.ent.bean.LoginResult;

import java.util.List;

public interface LoginService {

    LoginResult loginSingleDepartment(String accessCode, String departmentCode);

    List<LoginResult> loginAllDepartment(String accessCode);
}
