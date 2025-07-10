package DTO;

public class ClienteDTO {
    private String nome;
    private String cognome;
    private String email;
    private String password;
    private int livelloPermesso;

    /*
    livelloPermesso = 0 => Amministratore
    livelloPermesso = 1 => Addetto Alla Biblioteca
    livelloPermesso = 3 => Cliente
     */

    public ClienteDTO(String nome, String cognome, String email, String password) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.password = password;
        this.livelloPermesso = 2; // Cliente
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
    
}
