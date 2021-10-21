package com.sg.vendingmachine.dao;

import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

@Component
public class VendingMachineAuditDaoFileImpl implements VendingMachineAuditDao {

    private final String AUDIT_FILE;
    public VendingMachineAuditDaoFileImpl() {
        this.AUDIT_FILE = "audit.txt";
    }
    public VendingMachineAuditDaoFileImpl(String auditTestFile) {
        this.AUDIT_FILE = auditTestFile;
    }

    @Override
    public void writeAuditEntry(String entry) throws VendingMachinePersistenceException {
         PrintWriter out;
         try {
             out = new PrintWriter(new FileWriter(AUDIT_FILE, true));
         } catch (IOException e) {
             throw new VendingMachinePersistenceException("Could not persist audit information", e);
         }
         LocalDateTime timestamp = LocalDateTime.now();
         out.println(timestamp.toString() + " : " +entry);
         out.flush();
    }
}
