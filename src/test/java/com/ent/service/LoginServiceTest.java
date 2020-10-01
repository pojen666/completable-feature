package com.ent.service;

import com.ent.bean.LoginResult;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class LoginServiceTest {

    @Resource
    private LoginService loginService;

    @Test
    void testLogin() {
        String accessCode = "777";
        LoginResult resultA = loginService.loginSingleDepartment(accessCode, "A");
        LoginResult resultB = loginService.loginSingleDepartment(accessCode, "B");
        LoginResult resultC = loginService.loginSingleDepartment(accessCode, "C");
        System.out.println(resultA.getMessage());
        System.out.println(resultB.getMessage());
        System.out.println(resultC.getMessage());
    }

    @Test
    void testLoginAll() {
        List<LoginResult> resultList = loginService.loginAllDepartment("666");
        resultList.forEach(result -> System.out.println(result.getMessage()));
    }
}
