package app.code.verse.domain.services;

import app.code.verse.domain.model.MedicalHistory;
import app.code.verse.domain.model.VisitRecord;
import app.code.verse.domain.ports.MedicalHistoryPort;

import java.text.SimpleDateFormat;
import java.util.HashMap;

public class MedicalHistoryService implements MedicalHistoryPort {
    private final HashMap<String, MedicalHistory> storage = new HashMap<>();

    @Override
    public void addVisit(String idPatient, VisitRecord record) {
        validatePatient(idPatient);
        validateVisitDate(idPatient, record);

        MedicalHistory history = storage.getOrDefault(idPatient, new MedicalHistory());
        history.setIdPatient(idPatient);

        String dateKey = new SimpleDateFormat("dd/MM/yyyy").format(record.getDate());
        history.getRecords().put(dateKey, record);

        storage.put(idPatient, history);
    }

    @Override
    public MedicalHistory getHistory(String idPatient) {
        return storage.get(idPatient);
    }

    private void validatePatient(String idPatient) {
        if (idPatient == null || idPatient.isEmpty()) {
            throw new IllegalArgumentException("La historia clínica debe estar asociada a un paciente válido.");
        }
    }

    private void validateVisitDate(String idPatient, VisitRecord record) {
        if (record.getDate() == null) {
            throw new IllegalArgumentException("Cada registro de visita debe tener una fecha.");
        }

        MedicalHistory history = storage.get(idPatient);
        if (history != null) {
            String dateKey = new SimpleDateFormat("dd/MM/yyyy").format(record.getDate());
            if (history.getRecords().containsKey(dateKey)) {
                throw new IllegalArgumentException("Ya existe una visita registrada en esa fecha.");
            }
        }
    }
}
