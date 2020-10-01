package com.ent.service.impl;

import com.ent.service.DepartmentCAccessService;
import org.springframework.stereotype.Service;

@Service("com.ent.service.impl.DepartmentCAccessServiceImpl")
public class DepartmentCAccessServiceImpl
        extends BaseAccessServiceImpl
        implements DepartmentCAccessService {

    public DepartmentCAccessServiceImpl() {
        super("部門C");
    }

    @Override
    protected boolean accessGrant(String accessCode) {
        return "666".equalsIgnoreCase(accessCode)
                || "777".equalsIgnoreCase(accessCode)
                || "888".equalsIgnoreCase(accessCode);
    }
}
