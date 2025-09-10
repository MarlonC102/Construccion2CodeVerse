package app.code.verse.domain.services;

import app.code.verse.domain.model.DiagnosticTestInventory;
import app.code.verse.domain.model.utils.ValidateDataUtil;
import app.code.verse.domain.ports.DiagnosticTestInventoryPort;

public class UpdateDiagnosticTestInventory {
    private DiagnosticTestInventoryPort diagnosticTestInventoryPort;
    private FindDiagnosticTestInventory findDiagnosticTestInventory;

    public void updateDiagnosticTestInventory(String idExam, String name, double cost) throws Exception {
        ValidateDataUtil.validateString(idExam, "The diagnostic test ID cannot be null or empty");
        ValidateDataUtil.validateString(name, "The diagnostic test name cannot be null or empty");

        DiagnosticTestInventory diagnosticTestInventory = findDiagnosticTestInventory.findById(idExam);
        diagnosticTestInventory.setName(name);
        diagnosticTestInventory.setCost(cost);
        diagnosticTestInventoryPort.save(diagnosticTestInventory);
    }
}
