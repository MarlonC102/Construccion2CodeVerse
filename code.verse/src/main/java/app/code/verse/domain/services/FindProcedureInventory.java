package app.code.verse.domain.services;

import app.code.verse.domain.model.ProcedureInventory;
import app.code.verse.domain.ports.ProcedureInventoryPort;

public class FindProcedureInventory {
    private ProcedureInventoryPort procedureInventoryPort;

    public boolean existsById(ProcedureInventory procedureInventory) {
        return procedureInventoryPort.existsByIdNumber(procedureInventory.getIdProcedure());
    }

    public ProcedureInventory findById(String idProcedure) {
        ProcedureInventory procedureInventory = procedureInventoryPort.findById(idProcedure);
        if (procedureInventory == null) {
            throw new IllegalArgumentException("Procedure inventory not found");
        }
        return procedureInventory;
    }
}
