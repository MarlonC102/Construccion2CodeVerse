package app.code.verse.domain.services;

import app.code.verse.domain.model.MedicineInventory;
import app.code.verse.domain.model.utils.ValidateDataUtil;
import app.code.verse.domain.ports.MedicineInventoryPort;

public class RemoveMedicineInventory {
    private MedicineInventoryPort medicineInventoryPort;
    private FindMedicineInventory findMedicineInventory;

    public void removeMedicineInventory(String idMedicine) throws Exception {
        ValidateDataUtil.validateString(idMedicine, "The medicine ID cannot be null or empty");

        MedicineInventory medicineInventory = findMedicineInventory.findById(idMedicine);
        medicineInventoryPort.saveDelete(medicineInventory);
    }
}
