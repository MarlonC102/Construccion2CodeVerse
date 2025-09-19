package app.code.verse.domain.ports;

public interface PersonPort {
    boolean  existsByIdNumber(String idNumber);
}
