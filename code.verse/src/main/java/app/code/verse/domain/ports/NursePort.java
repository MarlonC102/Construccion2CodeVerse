package app.code.verse.domain.ports;

import app.code.verse.domain.model.MedicineAdministration;
import app.code.verse.domain.model.VisitRecord;

public interface NursePort {
    public void registerVitalSign(VisitRecord visitRecord) throws Exception;

    public void registerMedicationAdministration(MedicineAdministration medicineAdministration) throws Exception;
}
