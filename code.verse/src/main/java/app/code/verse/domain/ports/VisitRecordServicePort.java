package app.code.verse.domain.ports;

import app.code.verse.domain.model.VisitRecord;

public interface VisitRecordServicePort {
    VisitRecord createVisitRecord(VisitRecord record);
    VisitRecord getVisitByDate(String idPatient, String dateKey);
}
