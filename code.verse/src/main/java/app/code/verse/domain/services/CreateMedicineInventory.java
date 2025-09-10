package app.code.verse.domain.services;

import app.code.verse.domain.model.MedicineInventory;
import app.code.verse.domain.model.utils.ValidateDataUtil;
import app.code.verse.domain.ports.MedicineInventoryPort;

public class CreateMedicineInventory {
    private MedicineInventoryPort medicineInventoryPort;
    private FindMedicineInventory findMedicineInventory;

    public void createMedicineInventory(MedicineInventory medicineInventory) throws Exception {
        ValidateDataUtil.validateString(medicineInventory.getIdMedicine(), "The medicine ID cannot be null or empty");
        ValidateDataUtil.validateString(medicineInventory.getName(), "The medicine name cannot be null or empty");

        if (findMedicineInventory.existsById(medicineInventory)) {
            throw new IllegalArgumentException("The medicine inventory already exists");
        }
        medicineInventoryPort.save(medicineInventory);
    }
}