package lab06.Ex2;

import java.util.List;

public class MovieBuilder {
    private String title;
    private int year;
    private Person director;
    private Person writer;
    private String series;
    private List<Person> cast;
    private List<Place> locations;
    private List<String> languages;
    private List<String> genres;
    private boolean isTelevision;
    private boolean isNetflix;
    private boolean isIndependent;

    public MovieBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public MovieBuilder setYear(int year) {
        this.year = year;
        return this;
    }

    public MovieBuilder setDirector(Person director) {
        this.director = director;
        return this;
    }

    public MovieBuilder setWriter(Person writer) {
        this.writer = writer;
        return this;
    }

    public MovieBuilder setSeries(String series) {
        this.series = series;
        return this;
    }

    public MovieBuilder setCast(List<Person> cast) {
        this.cast = cast;
        return this;
    }

    public MovieBuilder setLocations(List<Place> locations) {
        this.locations = locations;
        return this;
    }

    public MovieBuilder setLanguages(List<String> languages) {
        this.languages = languages;
        return this;
    }

    public MovieBuilder setGenres(List<String> genres) {
        this.genres = genres;
        return this;
    }

    public MovieBuilder setIsTelevision(boolean isTelevision) {
        this.isTelevision = isTelevision;
        return this;
    }

    public MovieBuilder setIsNetflix(boolean isNetflix) {
        this.isNetflix = isNetflix;
        return this;
    }

    public MovieBuilder setIsIndependent(boolean isIndependent) {
        this.isIndependent = isIndependent;
        return this;
    }

    public Movie build() {
        return new Movie(title, year, director, writer, series, cast, locations, languages, genres, isTelevision, isNetflix, isIndependent);
    }
}
