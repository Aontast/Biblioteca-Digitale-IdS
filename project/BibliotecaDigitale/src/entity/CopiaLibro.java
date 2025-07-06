package entity;

public class CopiaLibro {
    private static int counter = 0;

    private int ID;
    private String stato;
    private Libro libro;

    public CopiaLibro(String stato, Libro libro){
        this.ID = counter++;
        this.stato = stato;
        this.libro = libro;
    }
}
