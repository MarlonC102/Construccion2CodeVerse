package app.code.verse.domain.ports;

import app.code.verse.domain.model.MedicalHistory;
import app.code.verse.domain.model.VisitRecord;

public interface MedicalHistoryPort {
    void addVisit(String idPatient, VisitRecord record);
    MedicalHistory getHistory(String idPatient);
}
