package lab06.Ex2;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Criar instâncias de Person
        Person christopherNolan = new Person("Christopher Nolan");
        Person leonardoDicaprio = new Person("Leonardo DiCaprio");
        Person ellenPage = new Person("Ellen Page");

        // Criar instâncias de Place
        Place location1 = new Place("Los Angeles");
        Place location2 = new Place("Paris");

        // Lista de elenco
        List<Person> cast = new ArrayList<>();
        cast.add(leonardoDicaprio);
        cast.add(ellenPage);

        // Lista de locações
        List<Place> locations = new ArrayList<>();
        locations.add(location1);
        locations.add(location2);

        // Criar uma instância de Movie usando MovieBuilder
        Movie inception = new MovieBuilder()
                .setTitle("Inception")
                .setYear(2010)
                .setDirector(christopherNolan)
                .setWriter(christopherNolan)
                .setCast(cast)
                .setLocations(locations)
                .setIsTelevision(false)
                .setIsNetflix(true)
                .setIsIndependent(false)
                .build();

        // Imprimir informações sobre "Inception"
        System.out.println("Title: " + inception.getTitle());
        System.out.println("Year: " + inception.getYear());
        System.out.println("Director: " + inception.getDirector().getName());
        System.out.println("Writer: " + inception.getWriter().getName());
        System.out.println("Cast:");
        for (Person actor : inception.getCast()) {
            System.out.println("- " + actor.getName());
        }
        System.out.println("Locations:");
        for (Place place : inception.getLocations()) {
            System.out.println("- " + place.getName());
        }
        System.out.println("Is Television: " + inception.isTelevision());
        System.out.println("Is Netflix: " + inception.isNetflix());
        System.out.println("Is Independent: " + inception.isIndependent());
    }
}
