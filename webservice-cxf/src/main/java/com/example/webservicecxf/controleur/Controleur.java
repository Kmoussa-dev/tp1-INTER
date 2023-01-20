package com.example.webservicecxf.controleur;

import com.example.webservicecxf.modele.Personne;
import com.example.webservicecxf.service.Facade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/annuaire")
public class Controleur {

        @Autowired
        Facade facade;

        @PostMapping(value = "/{nom}",produces = "application/json")
        public void getsearchTelephone(@PathVariable String nom) {
            this.facade.searchTelephone(nom);
        }
        @GetMapping(value = "/{nom}",produces = "application/json")
        public Personne searchPersonne(@PathVariable String nom) throws Exception{
         return this.facade.searchPersonne(nom);
        }
        @PostMapping(value = "/personne",produces = "application/json")
        public void addPersonne(@RequestBody Personne p){
            this.facade.addPersonne(p);
        }
        @PostMapping(value = "/addpersonnelist")
        public void addPersonneList(@PathVariable String nom,@PathVariable String prenom,@PathVariable String tel){
                this.facade.addPersonneList(nom, prenom, tel);
        }
        @GetMapping(value = "/allName")
        public Collection<String> getAllNom(){
                return this.facade.getAllNom();
        }
}
