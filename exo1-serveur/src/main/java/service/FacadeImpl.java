package service;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import modele.Contact;
import modele.Personne;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@WebService(name = "Annuaire")
public class FacadeImpl implements Facade{
    private static Map<String, Personne> annuaire = new HashMap<>();

    static {
        Personne fred = new Personne("moal", "frederic");
        fred.addContact(new Contact("tel", "0238000000", fred));
        fred.addContact(new Contact("mail", "frederic.moal@univ-orleans.fr", fred));
        annuaire.put(fred.getNom(), fred);

        final Personne matthieu = new Personne("exbrayat", "matthieu");
        matthieu.addContact(new Contact("tel","0202020202", matthieu));
        annuaire.put(matthieu.getNom(), matthieu);

        final Personne yohan = new Personne("yohan", "boichut");
        matthieu.addContact(new Contact("mail","yohan.boichut@univ-orleans.fr", yohan));
        annuaire.put(yohan.getNom(), yohan);
    }

    @Override
    public String searchTelephone(String nom) {
        Personne p =  annuaire.get(nom);
        if (p==null) {
            return "Pas trouve";
        }
        return p.getContacts().stream().filter(c->c.getType().startsWith("tel")).findAny().get().getAdresse();
    }
    @Override
    public Personne searchPersonne(String nom) throws Exception {
        Personne personne = annuaire.get(nom);
        if (Objects.isNull(personne)) throw new Exception("");
        return personne;

    }
    @Override
    public void addPersonne(Personne p) {
        annuaire.put(p.getNom(), p);
    }
    @Override
    @WebMethod(operationName = "ajouterPersonneTel")
    public void addPersonneList(@WebParam(name = "nom") String nom,@WebParam(name = "prenom") String prenom,@WebParam(name = "tel")  String tel) {
        Personne p = new Personne(nom,prenom);
        annuaire.put(p.getNom(), p);
    }
    @Override
    public Collection<String> getAllNom() {
        return annuaire.keySet();
    }
}

