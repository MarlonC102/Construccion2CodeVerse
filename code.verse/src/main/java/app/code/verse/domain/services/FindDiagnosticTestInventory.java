package app.code.verse.domain.services;

import app.code.verse.domain.model.DiagnosticTestInventory;
import app.code.verse.domain.ports.DiagnosticTestInventoryPort;

public class FindDiagnosticTestInventory {
    private DiagnosticTestInventoryPort diagnosticTestInventoryPort;

    public boolean existsById(DiagnosticTestInventory diagnosticTestInventory) {
        return diagnosticTestInventoryPort.existsByIdNumber(diagnosticTestInventory.getIdExam());
    }

    public DiagnosticTestInventory findById(String idExam) {
        DiagnosticTestInventory diagnosticTestInventory = diagnosticTestInventoryPort.findById(idExam);
        if (diagnosticTestInventory == null) {
            throw new IllegalArgumentException("Diagnostic test inventory not found");
        }
        return diagnosticTestInventory;
    }
}
