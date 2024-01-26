package soa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import soa.entities.Categorie;
import soa.entities.Produit;
import soa.repository.CategorieRepository;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/categories")
public class CategorieRESTController {

    @Autowired
    private CategorieRepository categorieRepository;

    @GetMapping("/index")
    public String accueil() {
        return "Bienvenue au service Web REST 'categories'.....";
    }

    @GetMapping(
            value = "/",
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
    )
    public List<Categorie> getAllCategories() {
        return categorieRepository.findAll();
    }

    @GetMapping(
            value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public Categorie getCategorie(@PathVariable Long id) {
        return categorieRepository.findById(id).orElse(null);
    }

    @GetMapping("/delete/{id}")
    public void deleteCategorie(@PathVariable Long id) {
        categorieRepository.deleteById(id);
    }

    @PostMapping(
            value = "/",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public Categorie saveCategorie(@RequestBody Categorie c) {
        return categorieRepository.save(c);
    }

    @PutMapping(
            value = "/",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public Categorie updateCategorie(@RequestBody Categorie c) {
        return categorieRepository.save(c);
    }

    @DeleteMapping("/")
    public void deleteCategorie(@RequestBody Categorie c) {
        categorieRepository.delete(c);
    }
}
