package app.code.verse.domain.ports;

import app.code.verse.domain.model.VisitRecord;

public interface VisitRecordRepositoryPort {
    void save(String idPatient, VisitRecord record);
    VisitRecord findByDate(String idPatient, String dateKey);
}
