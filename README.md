# Biblioteca Digitale - Sistema di Gestione per Biblioteca Digitale

Un sistema completo di gestione per biblioteca digitale sviluppato per il corso di Ingegneria del Software presso l'Università degli Studi di Napoli Federico II.

## 📖 Panoramica

Questo progetto implementa un sistema di gestione per biblioteca digitale che consente agli utenti di cercare e prenotare libri online per poi ritirarli fisicamente presso la biblioteca. Il sistema gestisce un catalogo digitale, le registrazioni degli utenti, il processo di prenotazione e fornisce strumenti di amministrazione per il personale della biblioteca.

## ✨ Funzionalità

Il software offre funzionalità distinte per i diversi attori che interagiscono con il sistema.

### Per gli Utenti
- **Consultazione Catalogo**: Possibilità di cercare libri nel catalogo digitale utilizzando filtri per autore, genere o anno di pubblicazione.

### Per gli Utenti Non Registrati
- **Registrazione**: Possibilità di effettuare richiesta di registrazione di un nuovo account

### Per gli Utenti Registrati
- **Gestione Profilo Personale**: Dopo la registrazione e l'autenticazione, gli utenti possono accedere a un'area personale per visualizzare e modificare i propri dati, caricare un'immagine del profilo e consultare lo storico dei prestiti.
- **Prenotazione Libri**: Gli utenti possono prenotare una copia di un libro disponibile. Il sistema verifica la disponibilità e, in caso positivo, riserva la copia per l'utente.
- **Gestione Prenotazioni**: È possibile visualizzare le prenotazioni attive e annullarle in qualsiasi momento.
- **Cronologia Libri Consultati**: È possibile visualizzare la cronologia di tutti i libri consultati in passato.

### Per gli Addetti alla Biblioteca
- **Gestione Ritiri**: Gli addetti possono visualizzare l'elenco delle prenotazioni e registrare il ritiro di una copia da parte di un utente, aggiornandone lo stato a "in prestito".
- **Gestione Restituzioni**: Possibilità di registrare la restituzione di una copia, rendendola così di nuovo disponibile per altre prenotazioni.
- **Reportistica**: Capacità di generare report sui libri attualmente in prestito.

### Per gli Amministratori
- **Gestione Completa del Catalogo**: Gli amministratori possono aggiungere nuovi libri al catalogo, aggiungere nuove copie di libri esistenti, modificare i dettagli dei libri o eliminare quelli obsoleti.
- **Report Avanzati**: Possono generare report mensili sull'utilizzo del servizio, sugli incassi, sui libri più prenotati e sugli utenti più attivi.

## Funzionalità Principali Implementate

Lo sviluppo si è concentrato su tre casi d'uso principali:

1. **Registrazione Utente** - Flusso che permette a un nuovo utente di registrarsi al sistema fornendo i propri dati personali (nome, cognome, email, password) attraverso un'apposita interfaccia grafica. Il sistema valida i dati e crea un nuovo account.
    **Attore Coinvolto**: `Utente`.
2. **Prenotazione Libro** - Funzionalità complessa che consente a un utente già registrato e autenticato di accedere al proprio profilo, visualizzare il catalogo dei libri, selezionarne uno, scegliere una data di restituzione e confermare la prenotazione. Il sistema gestisce la creazione della prenotazione e l'aggiornamento dello stato della copia.
    **Attore Coinvolto**: `Utente Registrato`.
3. **Inserimento Libro** - Fornisce agli amministratori un'interfaccia dedicata per aggiungere un nuovo libro al catalogo. L'operazione richiede l'inserimento di tutti i dettagli del libro (titolo, autore, ISBN, genere, ecc.) e il suo salvataggio nel database.
    **Attore Coinvolto**: `Amministratore`.

## 🛠️ Architettura e Stack Tecnologico

L'applicazione è stata progettata seguendo una moderna architettura a livelli.

- **Linguaggio di Programmazione**: Java.
- **Interfaccia Grafica (GUI)**: Realizzata con la libreria **Java Swing**.
- **Pattern Architetturale**: L'architettura del sistema si basa sul pattern **BCED (Boundary-Controller-Entity-Database)**, che assicura una chiara separazione delle responsabilità tra i vari componenti del software.
- **Database**: Il sistema utilizza un database **MySQL** per la persistenza dei dati. L'accesso ai dati è gestito tramite il pattern **DAO (Data Access Object)**, che astrae la logica di business dalle operazioni specifiche sul database.
- **Data Transfer Object (DTO)**: Per ridurre l'accoppiamento tra il livello di presentazione (Boundary) e quello di dominio (Entity), viene utilizzato il pattern DTO per il trasferimento di dati.

## 📁 Struttura del Progetto

```
├── Documentation/
│   ├── ProgettoBiblioteca.docx
│   └── ProgettoBiblioteca.pdf
├── JavaProject/
│   ├── BibliotecaDigitale/
│       └── src/
│           ├── boundary/          
│           ├── control/           
│           ├── entity/            
│           ├── database/          
│           ├── DTO/
│           └── resources/            
│   └──MySql/                        
│      ├── biblioteca_copie.sql
│      ├── biblioteca_libri.sql
│      ├── biblioteca_prenotazioni.sql
│      └── biblioteca_utenti.sql
└── VisualParadigm/
    └── BibliotecaDigitale.vpp    # Diagrammi UML
```

### Configurazione Applicazione

1. Aprire il progetto nell'IDE:
   - Navigare su `JavaProject/BibliotecaDigitale/`
   - Importare come progetto Java

2. Configurare la connessione al database:
   - Aggiornare i parametri di connessione in [`DBConnectionManager.java`](JavaProject/BibliotecaDigitale/src/database/DBConnectionManager.java)

3. Eseguire l'applicazione:
   - Per la registrazione utente: [`FormRegistrazione.java`](JavaProject/BibliotecaDigitale/src/boundary/FormRegistrazione.java)
   - Per il profilo utente: [`FormProfiloUtente.java`](JavaProject/BibliotecaDigitale/src/boundary/FormProfiloUtente.java)
   - Per l'inserimento libri: [`InserimentoLibro.java`](JavaProject/BibliotecaDigitale/src/boundary/InserimentoLibro.java)

## 📚 Documentazione

La documentazione dettagliata del progetto, inclusi i diagrammi UML, l'architettura del sistema e le decisioni di progettazione, si trova nella cartella [`Documentation/`](Documentation/):

- **Report del Progetto**: [`ProgettoBiblioteca.pdf`](Documentation/ProgettoBiblioteca.pdf)
- **Diagrammi UML**: [`VisualParadigm/BibliotecaDigitale.vpp`](VisualParadigm/BibliotecaDigitale.vpp)

## 👥 Autori

- **Antonio Di Giorgio**
- **Matteo Bottari**  
- **Jacopo Ferrante**

*Corso di Ingegneria del Software - Università degli Studi di Napoli Federico II (A.A. 2024-2025)*  
*Prof.ssa A.R. Fasolino*
