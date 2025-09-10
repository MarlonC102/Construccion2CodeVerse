package app.code.verse.domain.services;

import app.code.verse.domain.model.ProcedureInventory;
import app.code.verse.domain.model.utils.ValidateDataUtil;
import app.code.verse.domain.ports.ProcedureInventoryPort;

public class RemoveProcedureInventory {
    private ProcedureInventoryPort procedureInventoryPort;
    private FindProcedureInventory findProcedureInventory;

    public void removeProcedureInventory(String idProcedure) throws Exception {
        ValidateDataUtil.validateString(idProcedure, "The procedure ID cannot be null or empty");

        ProcedureInventory procedureInventory = findProcedureInventory.findById(idProcedure);
        procedureInventoryPort.saveDelete(procedureInventory);
    }
}
