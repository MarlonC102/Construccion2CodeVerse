package app.code.verse.domain.services;

import app.code.verse.domain.model.ProcedureInventory;
import app.code.verse.domain.model.utils.ValidateDataUtil;
import app.code.verse.domain.ports.ProcedureInventoryPort;

public class CreateProcedureInventory {
    private ProcedureInventoryPort procedureInventoryPort;
    private FindProcedureInventory findProcedureInventory;

    public void createProcedureInventory(ProcedureInventory procedureInventory) throws Exception {
        ValidateDataUtil.validateString(procedureInventory.getIdProcedure(), "The procedure ID cannot be null or empty");
        ValidateDataUtil.validateString(procedureInventory.getName(), "The procedure name cannot be null or empty");

        if (findProcedureInventory.existsById(procedureInventory)) {
            throw new IllegalArgumentException("The procedure inventory already exists");
        }
        procedureInventoryPort.save(procedureInventory);
    }
}
