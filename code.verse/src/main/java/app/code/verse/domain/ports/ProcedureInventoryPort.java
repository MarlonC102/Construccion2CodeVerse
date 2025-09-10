package app.code.verse.domain.ports;

import app.code.verse.domain.model.ProcedureInventory;

import java.util.List;

public interface ProcedureInventoryPort {
    void createProcedureInventory(ProcedureInventory procedureInventory) throws Exception;
    void updateProcedureInventory(String idProcedure, String name, double cost) throws Exception;
    ProcedureInventory findById(String idProcedure);
    List<ProcedureInventory> findAll();
    void removeProcedureInventory(String idProcedure) throws Exception;
    boolean existsByIdNumber(String idProcedure);
    void save(ProcedureInventory procedureInventory) throws Exception;
    void saveDelete(ProcedureInventory procedureInventory) throws Exception;
}
