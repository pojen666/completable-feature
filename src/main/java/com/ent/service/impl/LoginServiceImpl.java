package com.ent.service.impl;

import com.ent.bean.LoginResult;
import com.ent.constant.LoginResultCode;
import com.ent.service.DepartmentAAccessService;
import com.ent.service.DepartmentBAccessService;
import com.ent.service.DepartmentCAccessService;
import com.ent.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service("com.ent.service.impl.LoginServiceImpl")
public class LoginServiceImpl implements LoginService {

    @Resource
    private DepartmentAAccessService departmentAAccessService;

    @Resource
    private DepartmentBAccessService departmentBAccessService;

    @Resource
    private DepartmentCAccessService departmentCAccessService;

    @Override
    public LoginResult loginSingleDepartment(String accessCode, String departmentCode) {
        if ("A".equalsIgnoreCase(departmentCode)) {
            return departmentAAccessService.access(accessCode).join();
        } else if ("B".equalsIgnoreCase(departmentCode)) {
            return departmentBAccessService.access(accessCode).join();
        } else if ("C".equalsIgnoreCase(departmentCode)) {
            return departmentCAccessService.access(accessCode).join();
        } else {
            LoginResult target = new LoginResult();
            target.setCode(LoginResultCode.INCORRECT_IDENTITY);
            target.setMessage("無對應單位代碼無法登入");
            return target;
        }
    }

    @Override
    public List<LoginResult> loginAllDepartment(String accessCode) {
        List<LoginResult> targetList = new ArrayList<>();
        CompletableFuture<LoginResult> resultA = departmentAAccessService.access(accessCode);
        CompletableFuture<LoginResult> resultB = departmentBAccessService.access(accessCode);
        CompletableFuture<LoginResult> resultC = departmentCAccessService.access(accessCode);
        CompletableFuture.allOf(
                resultA,
                resultB,
                resultC
        ).thenRun(() -> {
            targetList.add(resultA.join());
            targetList.add(resultB.join());
            targetList.add(resultC.join());
        }).join();
        return targetList;
    }
}
