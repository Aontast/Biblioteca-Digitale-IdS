# Sistema Software per la Gestione di una Biblioteca Digitale

Questo repository contiene il progetto sviluppato per il corso di **Ingegneria del Software** (A.A. 2024-2025) della Prof.ssa A.R. [cite_start]Fasolino, presso l'**Università degli Studi di Napoli Federico II**[cite: 3, 4].

## 📋 Descrizione del Progetto

[cite_start]L'obiettivo del progetto è sviluppare un sistema software per la gestione di una biblioteca digitale[cite: 17]. [cite_start]La piattaforma consente agli utenti di cercare e prenotare libri online per poi ritirarli fisicamente presso la sede della biblioteca[cite: 17].

[cite_start]Il sistema gestisce un catalogo digitale, le registrazioni degli utenti, il processo di prenotazione e ritiro, e fornisce strumenti di amministrazione per il personale della biblioteca[cite: 17, 27, 30].

---

## ✨ Funzionalità Principali

Il software offre funzionalità distinte per i diversi attori che interagiscono con il sistema.

### Per gli Utenti Registrati

* [cite_start]**Consultazione Catalogo**: Possibilità di cercare libri nel catalogo digitale utilizzando filtri per autore, genere o anno di pubblicazione[cite: 18].
* [cite_start]**Gestione Profilo Personale**: Dopo la registrazione e l'autenticazione, gli utenti possono accedere a un'area personale per visualizzare e modificare i propri dati, caricare un'immagine del profilo e consultare lo storico dei prestiti[cite: 21, 22, 23].
* [cite_start]**Prenotazione Libri**: Gli utenti possono prenotare una copia di un libro disponibile[cite: 24, 25]. [cite_start]Il sistema verifica la disponibilità e, in caso positivo, riserva la copia per l'utente[cite: 25].
* [cite_start]**Gestione Prenotazioni**: È possibile visualizzare le prenotazioni attive e annullarle in qualsiasi momento[cite: 24].

### Per gli Addetti alla Biblioteca

* [cite_start]**Gestione Ritiri**: Gli addetti possono visualizzare l'elenco delle prenotazioni e registrare il ritiro di una copia da parte di un utente, aggiornandone lo stato a "in prestito"[cite: 27, 28].
* [cite_start]**Gestione Restituzioni**: Possono registrare la restituzione di una copia, rendendola così di nuovo disponibile per altre prenotazioni[cite: 29].
* [cite_start]**Reportistica**: Capacità di generare report sui libri attualmente in prestito[cite: 29].

### Per gli Amministratori

* [cite_start]**Gestione Catalogo Completa**: Gli amministratori possono aggiungere nuovi libri al catalogo, aggiungere nuove copie di libri esistenti, modificare i dettagli dei libri o eliminare quelli obsoleti[cite: 30].
* [cite_start]**Report Avanzati**: Possono generare report mensili sull'utilizzo del servizio, sugli incassi, sui libri più prenotati e sugli utenti più attivi[cite: 31].

---

## 🚀 Funzionalità Implementate

Come documentato dai diagrammi di sequenza di progettazione, lo sviluppo si è concentrato sull'implementazione completa di **tre casi d'uso principali**, che rappresentano il cuore dell'applicazione:

1.  [cite_start]**Registrazione Utente** [cite: 328]
    * [cite_start]**Descrizione**: Flusso che permette a un nuovo utente di registrarsi al sistema fornendo i propri dati personali (nome, cognome, email, password) attraverso un'apposita interfaccia grafica. [cite: 21] [cite_start]Il sistema valida i dati e crea un nuovo account. [cite: 137]
    * [cite_start]**Attore Coinvolto**: `Utente`. [cite: 103]

2.  [cite_start]**Prenotazione Libro** [cite: 330]
    * [cite_start]**Descrizione**: Funzionalità complessa che consente a un utente già registrato e autenticato di accedere al proprio profilo, visualizzare il catalogo dei libri, selezionarne uno, scegliere una data di restituzione e confermare la prenotazione. [cite: 287, 288] [cite_start]Il sistema gestisce la creazione della prenotazione e l'aggiornamento dello stato della copia. [cite: 25]
    * [cite_start]**Attore Coinvolto**: `Utente Registrato`. [cite: 105]

3.  [cite_start]**Inserimento Libro** [cite: 332]
    * [cite_start]**Descrizione**: Fornisce agli amministratori un'interfaccia dedicata per aggiungere un nuovo libro al catalogo. [cite: 293] [cite_start]L'operazione richiede l'inserimento di tutti i dettagli del libro (titolo, autore, ISBN, genere, ecc.) e il suo salvataggio nel database. [cite: 30, 293]
    * [cite_start]**Attore Coinvolto**: `Amministratore`. [cite: 107]

---

## 🛠️ Architettura e Stack Tecnologico

L'applicazione è stata progettata seguendo una moderna architettura a livelli.

* [cite_start]**Linguaggio di Programmazione**: Java[cite: 358].
* [cite_start]**Interfaccia Grafica (GUI)**: Realizzata con la libreria **Java Swing**[cite: 358].
* [cite_start]**Pattern Architetturale**: L'architettura del sistema si basa sul pattern **BCED (Boundary-Controller-Entity-Database)**, che assicura una chiara separazione delle responsabilità tra i vari componenti del software[cite: 277].
* [cite_start]**Database**: Il sistema utilizza un database **MySQL** per la persistenza dei dati[cite: 334]. [cite_start]L'accesso ai dati è gestito tramite il pattern **DAO (Data Access Object)**, che astrae la logica di business dalle operazioni specifiche sul database[cite: 310].
* [cite_start]**Data Transfer Object (DTO)**: Per ridurre l'accoppiamento tra il livello di presentazione (Boundary) e quello di dominio (Entity), viene utilizzato il pattern DTO per il trasferimento di dati[cite: 354, 356].

---

## 👨‍💻 Autori

* [Antonio Di Giorgio]
* [Matteo Bottari]
* [Jacopo Ferrante]
