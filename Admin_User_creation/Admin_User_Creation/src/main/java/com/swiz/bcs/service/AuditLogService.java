package com.swiz.bcs.service;

import com.swiz.bcs.entity.AuditLog;
import com.swiz.bcs.repository.AuditLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AuditLogService {
    private final AuditLogRepository auditLogRepository;

    @Autowired
    public AuditLogService(AuditLogRepository auditLogRepository) {
        this.auditLogRepository = auditLogRepository;
    }

    public void logAdminAction(String adminUsername, String action, Integer targetEntityId, String objectType) {
        AuditLog logEntry = new AuditLog();
        logEntry.setTimestamp(new Date());
        logEntry.setAdminUsername(adminUsername);
        logEntry.setAction(action);
        logEntry.setObjectType(objectType);
        logEntry.setObjectId(targetEntityId);

        auditLogRepository.save(logEntry);
    }


//    public void logAdminAction(String adminUsername, String action, Integer targetUserId) {
//        AuditLog logEntry = new AuditLog();
//        logEntry.setTimestamp(new Date());
//        logEntry.setAdminUsername(adminUsername);
//        logEntry.setAction(action);
//        logEntry.setTargetUserId(targetUserId);
//
//        auditLogRepository.save(logEntry);
//    }
}

