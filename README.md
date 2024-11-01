# Java Backend Server i React Frontend Aplikacija

Ovaj projekat se sastoji od Java backend servera koji parsira podatke i frontend aplikacije razvijene u React.js. Backend server koristi Spring Boot za izgradnju RESTful API-ja i Maven za upravljanje zavisnostima. Frontend aplikacija prikazuje korisničke podatke na interaktivan način.

## Opis projekta

### Backend (Java)

- **Zaduženje**: Backend server preuzima podatke sa API-ja (npr. Teltonika) i parsira ih u format koji je lako obradiv.
- **Tehnologije**:
  - **Java**: Glavni jezik za razvoj.
  - **Spring Boot**: Okvir za izgradnju RESTful API-ja.
  - **Maven**: Alat za upravljanje zavisnostima i gradnju projekta.
- **API Endpoint**: Server izlaže endpoint (`/api/teltonika/parse`) koji vraća parsirane podatke u JSON formatu.

### Frontend (React)

- **Zaduženje**: Frontend aplikacija preuzima podatke sa backend servera i prikazuje ih korisniku.
- **Tehnologije**:
  - **React.js**: Biblioteka za izgradnju korisničkog interfejsa.
  - **Fetch API**: Koristi se za komunikaciju sa backend serverom i dobijanje podataka.
- **Komponente(koje za obradu usera)**:
  - `UserData`: Komponenta koja preuzima korisničke podatke i prikazuje ih.
  - `RecordDetails`: Komponenta koja prikazuje detalje svakog korisničkog zapisa.

## Kako pokrenuti projekat

### 1. Pokretanje backend servera

- **Prerequisites**: Potreban instaliran JDK i Maven na sistemu.
- **Kloni projekat**: Preuzmite ili klonirajte projekat sa repozitorijuma:
  ```bash
  git clone https://github.com/username/ime-projekta.git

- Alati poput intellJ ili Eclipse


2. Pokretanje frontend aplikacije
   
Navigacija do frontend foldera: U terminalu, idite do foldera sa frontend aplikacijom:

    cd ../frontend

Instalacija zavisnosti: Pokrenite komandu za instalaciju zavisnosti:

    npm install

Pokretanje frontend aplikacije: Pokrenite aplikaciju koristeći:

    npm start
