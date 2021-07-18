package br.com.senior.desafiohotel.controller;

import br.com.senior.desafiohotel.model.Hospede;
import br.com.senior.desafiohotel.repository.HospedeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class HospedeController {

    public HospedeRepository repository;

    public HospedeController(HospedeRepository repository) {
        this.repository = repository;
    }

    // Lista hospedes
    @GetMapping(path = "/api/hospede/listaHospede" )
    public Iterable<Hospede> listar(@RequestBody Hospede hospede){
        return repository.findAll();
    }
    // lista hospede por ID
    @GetMapping(path = "/api/hospede/listaHospedeId")
    public ResponseEntity consultar(@RequestParam(value="id", required = false) Integer id) {
        return repository.findById(id).map(record -> ResponseEntity.ok().body(record)).
                orElse(ResponseEntity.notFound().build());
    }
    // Inclui hospede
    @PostMapping(path = "/api/hospede/incluiHospede" )
    public Hospede salvar(@RequestBody Hospede hospede){
        return repository.save(hospede);
    }
    // Exclui hospede
    @DeleteMapping(path = "/api/hospede/excluiHospede" )
    public ResponseEntity <?> excluir(@RequestParam(value="id", required = false) Integer id){
        return repository.findById(id).map(record -> {repository.deleteById(id);
        return ResponseEntity.ok().build();}).orElse(ResponseEntity.notFound().build());
    }
    // Altera hospede
    @PutMapping(value = "/api/hospede/alteraHospede")
    public ResponseEntity alterar(@RequestParam(value="id", required = false) Integer id, @RequestBody Hospede hospede){
        return repository.findById(id).map(record -> {
                    record.setNome(hospede.getNome());
                    record.setDocumento(hospede.getDocumento());
                    record.setTelefone(hospede.getTelefone());
                    Hospede updated = repository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }
}
