# BibliotecaDigitale - Applicazione Java

Applicazione Java per la gestione di una biblioteca digitale sviluppata con Swing e MySQL.

## 🏗️ Struttura del Progetto

```
src/
├── boundary/           # Interfacce grafiche (Swing)
│   ├── FormRegistrazione.java
│   ├── FormProfiloUtente.java
│   ├── InserimentoLibro.java
│   ├── PrenotazioneLibro.java
│   └── ...
├── control/            # Logica di controllo
│   ├── ControllerCatalogo.java
│   ├── ControllerRegistrazione.java
│   └── ...
├── entity/            # Modelli di dominio
│   ├── Libro.java
│   ├── UtenteRegistrato.java
│   ├── Cliente.java
│   └── ...
├── database/          # Accesso ai dati (DAO)
│   ├── LibroDAO.java
│   ├── UtenteRegistratoDAO.java
│   └── ...
├── DTO/              # Data Transfer Objects
│   ├── LibroDTO.java
│   └── ...
└── resources/        # Immagini e risorse
```

## 🔧 Configurazione Database

Assicurati che il database MySQL sia configurato correttamente in `database/DBConnectionManager.java`:

```java
private static final String URL = "jdbc:mysql://localhost:3306/";
private static final String DBNAME = "biblioteca";
private static final String USERNAME = "root";
private static final String PASSWORD = "your_password";
```

## 📱 Funzionalità Principali

- **Registrazione Utenti**: Form completo per registrazione e accesso ad un profilo
- **Gestione Profilo**: Visualizzazione e modifica dati personali
- **Prenotazione Libri**: Sistema di prenotazione con catalogo
- **Inserimento Libri**: Interfaccia amministrativa per aggiungere libri
- **Gestione Catalogo**: Strumenti di amministrazione