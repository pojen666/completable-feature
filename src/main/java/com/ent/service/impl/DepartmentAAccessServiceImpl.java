package com.ent.service.impl;

import com.ent.service.DepartmentAAccessService;
import org.springframework.stereotype.Service;

@Service("com.ent.service.impl.DepartmentAAccessServiceImpl")
public class DepartmentAAccessServiceImpl
        extends BaseAccessServiceImpl
        implements DepartmentAAccessService {

    public DepartmentAAccessServiceImpl() {
        super("部門A");
    }

    @Override
    protected boolean accessGrant(String accessCode) {
        return "666".equalsIgnoreCase(accessCode);
    }
}
