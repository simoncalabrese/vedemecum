package api.utils;

/**
 * Created by simon on 05/09/16.
 */
public class Enumerators {

    public enum viewsPath {
        LOGIN("frontend/LoginView.fxml"),
        HOMEPAGE("frontend/HomePage.fxml"),
        ROLE("frontend/RoleView.fxml"),
        EMPLOYEE("frontend/EmployeeView.fxml"),
        SPACE("frontend/SpaceView.fxml"),
        CARD   ("frontend/CardView.fxml"),
        STRUMENTATION("frontend/StrumentationView.fxml"),
        ASSOCIATION("frontend/AssociationEmployeeView.fxml"),
        ASSOCIATIONDIALOG("frontend/AssociationListView.fxml"),
        CARDDIALOGSELECTED("frontend/ShowSelectedView.fxml"),
        CARDSELECTIONDIALOG("frontend/CardSelectDialog.fxml");


        private String path;

        viewsPath(String path) {
            this.path = path;
        }

        public String getPath() {
            return path;
        }
    }

    public enum Alert {
        INSERT("Errore nell' inserimento", "Errore sollevato durante l' inserimento nella classe: "),
        UPDATE("Errore nella modifica", "Errore sollevato durante la modifica nella classe: "),
        DELETE("Impossibile eliminare", "Errore sollevato durante l'eliminazione nella classe: "),
        LOGINFIELDS("Dati non validi", "Inserire tutti i dati obbligatori"),
        LOGINVALUES("Utente non trovato", "Inserire i dati corretti o registrarsi."),
        SIGNINVALUES("Valori inseriti non validi" , "Password non corretta o Username già in uso"),
        SELECTIONROW("Nessuna riga selezionata", "Selezionare almeno una riga dalla tabella per continuare"),
        VALUES("Dato non inserito", "Dato non inserito nei campi obligatori "),
        VALUESNOTVALID("Dato non valido" , "Tipo dato inserito non valido per il campo: "),
        SUCCESS("Successo","Dato inserito correttamente nella tabella : ");

        private String head;
        private String body;

        Alert(String head, String body) {
            this.head = head;
            this.body = body;
        }

        public String getHead() {
            return head;
        }

        public String getBody() {
            return body;
        }
    }
}
