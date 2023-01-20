package service;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import modele.Personne;
import java.util.Collection;
@WebService
public interface Facade {
    public String searchTelephone(String nom);
    public Personne searchPersonne(String nom) throws Exception;
    public void addPersonne(Personne p);
    @WebMethod(operationName = "ajouterPersonneTel")
    public void addPersonneList(@WebParam(name = "nom") String nom,@WebParam(name = "prenom") String prenom,@WebParam(name = "tel") String tel);
    public Collection<String> getAllNom();
}
