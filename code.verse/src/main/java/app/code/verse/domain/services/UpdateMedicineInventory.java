package app.code.verse.domain.services;

import app.code.verse.domain.model.MedicineInventory;
import app.code.verse.domain.model.utils.ValidateDataUtil;
import app.code.verse.domain.ports.MedicineInventoryPort;

public class UpdateMedicineInventory {
    private MedicineInventoryPort medicineInventoryPort;
    private FindMedicineInventory findMedicineInventory;

    public void updateMedicineInventory(String idMedicine, String name, int stock, double price) throws Exception {
        ValidateDataUtil.validateString(idMedicine, "The medicine ID cannot be null or empty");
        ValidateDataUtil.validateString(name, "The medicine name cannot be null or empty");

        MedicineInventory medicineInventory = findMedicineInventory.findById(idMedicine);
        medicineInventory.setName(name);
        medicineInventory.setStock(stock);
        medicineInventory.setPrice(price);
        medicineInventoryPort.save(medicineInventory);
    }
}
