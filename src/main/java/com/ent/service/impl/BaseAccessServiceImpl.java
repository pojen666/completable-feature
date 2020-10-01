package com.ent.service.impl;

import com.ent.bean.LoginResult;
import com.ent.constant.LoginResultCode;
import com.ent.service.BaseAccessService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

@Slf4j
public abstract class BaseAccessServiceImpl implements BaseAccessService {

    @Getter
    private final String departmentName;

    public BaseAccessServiceImpl(String departmentName) {
        this.departmentName = departmentName;
    }


    @Override
    public CompletableFuture<LoginResult> access(String accessCode) {
        System.out.println(String.format("正連結至%s中", departmentName));
        LoginResult result = returnResult(accessCode);
        System.out.println("驗證完成");
        return CompletableFuture.completedFuture(result);
    }

    private LoginResult returnResult(String accessCode) {
        LoginResult target = new LoginResult();
        Random random = new Random();
        int time = random.nextInt(5);
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            log.error(e.getLocalizedMessage());
        }
        System.out.println(String.format("於%s花費%s秒進行驗證", getDepartmentName(), time));
        if (accessGrant(accessCode)) {
            target.setCode(LoginResultCode.OK);
            target.setMessage(String.format("於%s驗證成功", getDepartmentName()));
        } else {
            target.setCode(LoginResultCode.INCORRECT_IDENTITY);
            target.setMessage(String.format("於%s驗證失敗", getDepartmentName()));
        }
        return target;
    }

    protected abstract boolean accessGrant(String accessCode);
}
