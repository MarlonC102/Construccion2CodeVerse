package app.code.verse.domain.services;

import app.code.verse.domain.model.MedicineInventory;
import app.code.verse.domain.ports.MedicineInventoryPort;

public class FindMedicineInventory {
    private MedicineInventoryPort medicineInventoryPort;

    public boolean existsById(MedicineInventory medicineInventory) {
        return medicineInventoryPort.existsByIdNumber(medicineInventory.getIdMedicine());
    }

    public MedicineInventory findById(String idMedicine) {
        MedicineInventory medicineInventory = medicineInventoryPort.findById(idMedicine);
        if (medicineInventory == null) {
            throw new IllegalArgumentException("Medicine inventory not found");
        }
        return medicineInventory;
    }
}
