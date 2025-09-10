package app.code.verse.domain.services;

import app.code.verse.domain.model.DiagnosticTestInventory;
import app.code.verse.domain.model.utils.ValidateDataUtil;
import app.code.verse.domain.ports.DiagnosticTestInventoryPort;

public class RemoveDiagnosticTestInventory {
    private DiagnosticTestInventoryPort diagnosticTestInventoryPort;
    private FindDiagnosticTestInventory findDiagnosticTestInventory;

    public void removeDiagnosticTestInventory(String idExam) throws Exception {
        ValidateDataUtil.validateString(idExam, "The diagnostic test ID cannot be null or empty");

        DiagnosticTestInventory diagnosticTestInventory = findDiagnosticTestInventory.findById(idExam);
        diagnosticTestInventoryPort.saveDelete(diagnosticTestInventory);
    }
}
