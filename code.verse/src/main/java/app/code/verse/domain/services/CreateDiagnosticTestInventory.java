package app.code.verse.domain.services;

import app.code.verse.domain.model.DiagnosticTestInventory;
import app.code.verse.domain.model.utils.ValidateDataUtil;
import app.code.verse.domain.ports.DiagnosticTestInventoryPort;

public class CreateDiagnosticTestInventory {
    private DiagnosticTestInventoryPort diagnosticTestInventoryPort;
    private FindDiagnosticTestInventory findDiagnosticTestInventory;

    public void createDiagnosticTestInventory(DiagnosticTestInventory diagnosticTestInventory) throws Exception {
        ValidateDataUtil.validateString(diagnosticTestInventory.getIdExam(), "The diagnostic test ID cannot be null or empty");
        ValidateDataUtil.validateString(diagnosticTestInventory.getName(), "The diagnostic test name cannot be null or empty");

        if (findDiagnosticTestInventory.existsById(diagnosticTestInventory)) {
            throw new IllegalArgumentException("The diagnostic test inventory already exists");
        }
        diagnosticTestInventoryPort.save(diagnosticTestInventory);
    }
}
