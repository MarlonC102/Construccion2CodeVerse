package app.code.verse.domain.ports;

import app.code.verse.domain.model.MedicalHistory;
import app.code.verse.domain.model.Order;

public interface DoctorPort {
    public void createMedicalHistory(MedicalHistory history) throws Exception;

    public void addOrder(Order order) throws Exception;
}