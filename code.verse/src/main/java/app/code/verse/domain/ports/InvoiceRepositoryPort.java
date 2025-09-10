package app.code.verse.domain.ports;

import app.code.verse.domain.model.Invoice;
import java.util.List;

public interface InvoiceRepositoryPort {
    void save(Invoice invoice);
    Invoice findById(String idInvoice);
    List<Invoice> findByPatientId(String idPatient);
}
