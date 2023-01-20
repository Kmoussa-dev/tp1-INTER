package com.example.webservicecxf.service;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import com.example.webservicecxf.modele.Personne;
import org.springframework.stereotype.Service;

import java.util.Collection;
@WebService
@Service
public interface Facade {
    public String searchTelephone(String nom);
    public Personne searchPersonne(String nom) throws Exception;
    public void addPersonne(Personne p);

    public void addPersonneList(String nom,String prenom,String tel);
    public Collection<String> getAllNom();
}
