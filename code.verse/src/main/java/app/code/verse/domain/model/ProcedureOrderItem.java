package app.code.verse.domain.model;

public class ProcedureOrderItem extends OrderItem {

            private String procedureName;
            private int repetitions;
            private String frequency;
            private boolean requiresSpecialist;
            private String specialistType; // opcional

            public ProcedureOrderItem(int itemNumber, double cost, String procedureName, int repetitions, String frequency, boolean requiresSpecialist, String specialistType) {
                super(itemNumber, cost);
                this.procedureName = procedureName;
                this.repetitions = repetitions;
                this.frequency = frequency;
                this.requiresSpecialist = requiresSpecialist;
                this.specialistType = specialistType;
            }

            public String getProcedureName() { return procedureName; }
            public int getRepetitions() { return repetitions; }
            public String getFrequency() { return frequency; }
            public boolean isRequiresSpecialist() { return requiresSpecialist; }
            public String getSpecialistType() { return specialistType; }
        }

    }
}