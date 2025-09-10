package app.code.verse.domain.services;

import app.code.verse.domain.model.ProcedureInventory;
import app.code.verse.domain.model.utils.ValidateDataUtil;
import app.code.verse.domain.ports.ProcedureInventoryPort;

public class UpdateProcedureInventory {
    private ProcedureInventoryPort procedureInventoryPort;
    private FindProcedureInventory findProcedureInventory;

    public void updateProcedureInventory(String idProcedure, String name, double cost) throws Exception {
        ValidateDataUtil.validateString(idProcedure, "The procedure ID cannot be null or empty");
        ValidateDataUtil.validateString(name, "The procedure name cannot be null or empty");

        ProcedureInventory procedureInventory = findProcedureInventory.findById(idProcedure);
        procedureInventory.setName(name);
        procedureInventory.setCost(cost);
        procedureInventoryPort.save(procedureInventory);
    }
}
