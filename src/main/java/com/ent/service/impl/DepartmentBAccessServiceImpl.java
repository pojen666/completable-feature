package com.ent.service.impl;

import com.ent.service.DepartmentBAccessService;
import org.springframework.stereotype.Service;

@Service("com.ent.service.impl.DepartmentBAccessServiceImpl")
public class DepartmentBAccessServiceImpl
        extends BaseAccessServiceImpl
        implements DepartmentBAccessService {

    public DepartmentBAccessServiceImpl() {
        super("部門B");
    }

    @Override
    protected boolean accessGrant(String accessCode) {
        return "666".equalsIgnoreCase(accessCode)
                || "777".equalsIgnoreCase(accessCode);
    }
}
