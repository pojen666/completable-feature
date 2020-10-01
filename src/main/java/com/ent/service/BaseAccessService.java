package com.ent.service;

import com.ent.bean.LoginResult;
import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.CompletableFuture;

public interface BaseAccessService {

    @Async
    CompletableFuture<LoginResult> access(String accessCode);
}
