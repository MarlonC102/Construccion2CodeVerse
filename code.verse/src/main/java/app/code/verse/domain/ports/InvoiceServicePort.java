package app.code.verse.domain.ports;

import app.code.verse.domain.model.Invoice;
import java.util.List;

public interface InvoiceServicePort {
    Invoice generateInvoice(String idPatient);
    Invoice getInvoiceById(String idInvoice);
    List<Invoice> getInvoicesByPatient(String idPatient);
}
