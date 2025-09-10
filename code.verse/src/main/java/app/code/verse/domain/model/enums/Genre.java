package app.code.verse.domain.model.enums;

public enum Genre {
    FEMALE("Female"),
    MALE("Male"),
    OTHER("Other");

    private final String genre;

    Genre(String genre) {
        this.genre = genre;
    }

    public String genre() {
        return genre;
    }
}
