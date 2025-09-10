package app.code.verse.domain.ports;

import app.code.verse.domain.model.MedicineInventory;

import java.util.List;

public interface MedicineInventoryPort {
    void createMedicineInventory(MedicineInventory medicine) throws Exception;
    void updateMedicineInventory(String idMedicine, String name, int stock, double price) throws Exception;
    MedicineInventory findById(String idMedicine);
    List<MedicineInventory> findAll();
    void removeMedicineInventory(String idMedicine) throws Exception;
    boolean existsByIdNumber(String idMedicine);
    void save(MedicineInventory medicine) throws Exception;
    void saveDelete(MedicineInventory medicine) throws Exception;
}