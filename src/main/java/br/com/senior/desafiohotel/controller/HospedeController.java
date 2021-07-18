package br.com.senior.desafiohotel.controller;

import br.com.senior.desafiohotel.model.HospedeModel;
import br.com.senior.desafiohotel.repository.HospedeRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;

@RestController
public class HospedeController {

    public HospedeRepository repository;

    public HospedeController(HospedeRepository repository) {
        this.repository = repository;
    }

    // Consultar hospedes por ID
    @GetMapping(path = "/api/hospede/{id}")
    public ResponseEntity consultar(@PathVariable("id") Integer id) {
        return repository.findById(id).map(record -> ResponseEntity.ok().body(record)).
                orElse(ResponseEntity.notFound().build());
    }

    // Incluir hospedes
    @PostMapping(path = "/api/hospede/salvar" )
    public HospedeModel salvar(@RequestBody HospedeModel hospede){
        return repository.save(hospede);
    }

    // Excluir hospedes
    @DeleteMapping(path = "/api/hospede/excluir/{id}" )
    public ResponseEntity <?> excluir(@PathVariable Integer id){
        return repository.findById(id).map(record -> {repository.deleteById(id);
        return ResponseEntity.ok().build();}).orElse(ResponseEntity.notFound().build());
    }

    // Alterar hospedes
    @PutMapping(value = "/api/hospede/alterar/{id}")
    public ResponseEntity alterar(@PathVariable ("id") Integer id, @RequestBody HospedeModel hospede){
        return repository.findById(id).map(record -> {
                    record.setNome(hospede.getNome());
                    record.setDocumento(hospede.getDocumento());
                    record.setTelefone(hospede.getTelefone());
                    HospedeModel updated = repository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    // Listar hospedes
    //@Query(nativeQuery = true, value = "Select * from hospede;")
    @GetMapping(path = "/api/hospede/listar" )
    //public Iterable<HospedeModel> listar(@RequestBody HospedeModel hospede){
    public Iterable<HospedeModel> listar(@RequestBody HospedeModel hospede){

        return repository.findAll();
    }

//    EntityManagerFactory factory = Persistence.createEntityManagerFactory("meuapp");
//    EntityManager em = factory.createEntityManager();
//    HospedeModel hospedeModel = new HospedeModel(1,"Marcos","4444","4444");



}
