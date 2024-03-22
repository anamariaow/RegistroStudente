import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Objects;

public class Registro {
    private ArrayList<Studente> registroArrayList = new ArrayList<>();
    private LinkedList<Studente> registroLinkedList = new LinkedList<>();
    private HashMap<Integer, Studente> registroHashMap = new HashMap<>();

    public Registro(ArrayList<Studente> registroArrayList, LinkedList<Studente> registroLinkedList, HashMap<Integer, Studente> registroHashMap) {
        this.registroArrayList = registroArrayList;
        this.registroLinkedList = registroLinkedList;
        this.registroHashMap = registroHashMap;
    }

    public void stampaRegistro(Studente studente) {
        System.out.println("Elenco degli studenti nel registro:");
        for (Studente studenteVar : registroArrayList) {
            System.out.println("ID: " + studente.getId() + ", Nome: " + studente.getNome() + ", Voto: " + studente.getVoto());
        }
    }
    public void aggiungiStudente(Studente studente) {
        try{
            //variabile d'appoggio
            Studente studenteTemp = null;
            //ciclo per vedere se ci sono doppioni
            for(Studente studenteVar : registroArrayList) {
                //controllo se non hanno lo stesso id
                if(studenteVar.equals(studente)) {
                    //lancio eccezione
                    throw new ArrayStoreException("Studente già presente" + studente.getNome());
                } else {
                    //se non ci sono codici uguali salviamo l'oggetto da aggiungere
                    studenteTemp = studenteVar;
                }

            }
            //se non ci sono doppioni aggiungo
            if(studenteTemp != null) {
                registroLinkedList.add(studente);
            }
        } catch (NullPointerException e) {
            System.out.println("Errore: studente vuoto");
        }
        registroArrayList.add(studente);
        System.out.println("Lo studente è stato aggiunto");
    }
    public void rimuoviStudente(Integer id) {
        Studente appoggio = null;
        for(Studente studente : registroLinkedList) {
            if(studente.getId().equals(id)) {
                appoggio = studente;
            }
        }
        if(appoggio != null) {
            registroLinkedList.remove(appoggio);
            System.out.println("Lo studente è stato rimosso");
        }
    }
    public void modificaVoto(Integer id) {
        for(Studente studente : registroLinkedList) {

        }
    }
    public ArrayList<Studente> getRegistroArrayList() {
        return registroArrayList;
    }

    public LinkedList<Studente> getRegistroLinkedList() {
        return registroLinkedList;
    }

    public HashMap<Integer, Studente> getRegistroHashMap() {
        return registroHashMap;
    }

    public void setRegistroArrayList(ArrayList<Studente> registroArrayList) {
        this.registroArrayList = registroArrayList;
    }

    public void setRegistroLinkedList(LinkedList<Studente> registroLinkedList) {
        this.registroLinkedList = registroLinkedList;
    }

    public void setRegistroHashMap(HashMap<Integer, Studente> registroHashMap) {
        this.registroHashMap = registroHashMap;
    }

    @Override
    public String toString() {
        return "Registro{" +
                "registroArrayList=" + registroArrayList +
                ", registroLinkedList=" + registroLinkedList +
                ", registroHashMap=" + registroHashMap +
                '}';
    }
}
