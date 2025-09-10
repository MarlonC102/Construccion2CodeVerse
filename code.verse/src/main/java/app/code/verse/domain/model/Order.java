package app.code.verse.domain.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {
    public Order() {

            private String orderNumber;
            private String patientId;
            private String doctorId;
            private LocalDate creationDate;
            private List<OrderItem> items;

            public Order(String orderNumber, String patientId, String doctorId) {
                if(orderNumber.length() > 6) {
                    throw new IllegalArgumentException("El número de orden no puede exceder 6 dígitos");
                }
                this.orderNumber = orderNumber;
                this.patientId = patientId;
                this.doctorId = doctorId;
                this.creationDate = LocalDate.now();
                this.items = new ArrayList<>();
            }
            public void addItem(OrderItem item) {
                // Regla: Si la orden ya tiene un examen diagnóstico, no se pueden agregar medicamentos/procedimientos
                if(item instanceof DiagnosticTestOrderItem && !items.isEmpty()) {
                    throw new IllegalStateException("No se puede agregar un examen si ya existen medicamentos o procedimientos en la orden");
                }
                if(!(item instanceof DiagnosticTestOrderItem) && containsDiagnosticTest()) {
                    throw new IllegalStateException("No se pueden agregar medicamentos o procedimientos si la orden ya contiene un examen diagnóstico");
                }
                for (OrderItem i : items) {
                    if (i.getItemNumber() == item.getItemNumber()) {
                        throw new IllegalArgumentException("El número de ítem ya existe en la orden");
                    }
                }
                items.add(item);
            }
            private boolean containsDiagnosticTest() {
                return items.stream().anyMatch(i -> i instanceof DiagnosticTestOrderItem);
            }
            public String getOrderNumber() { return orderNumber; }
            public String getPatientId() { return patientId; }
            public String getDoctorId() { return doctorId; }
            public LocalDate getCreationDate() { return creationDate; }
            public List<OrderItem> getItems() { return items; }
        }

    }
}