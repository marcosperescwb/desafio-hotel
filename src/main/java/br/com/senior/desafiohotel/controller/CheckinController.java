package br.com.senior.desafiohotel.controller;

import br.com.senior.desafiohotel.model.Checkin;
import br.com.senior.desafiohotel.model.CheckinResult;
import br.com.senior.desafiohotel.repository.CheckinRepository;
import br.com.senior.desafiohotel.utils.Diaria;
import br.com.senior.desafiohotel.utils.EncodeString;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;
import java.util.ArrayList;

@RestController
public class CheckinController {

    public CheckinRepository repository;


    public CheckinController(CheckinRepository repository) {
        this.repository = repository;
    }

    // Incluir Checkin
    @PostMapping(path = "/api/checkin/incluiCheckin" )
    public Checkin incluir(@RequestBody Checkin checkin){
        return repository.save(checkin);
    }

    // Consultar checkin pelos dados do hospede
    @GetMapping(path = "/api/checkin/consultaHospede")
    public Iterable<CheckinResult>
                listarNome(@RequestParam(value="nome", required = false) String nomeRequest,
                           @RequestParam(value="documento", required = false) String docRequest,
                           @RequestParam(value="telefone", required = false) String foneRequest) throws ParseException {

        //Resultado
        ArrayList<CheckinResult> resultList = new ArrayList<>();

        if (null != nomeRequest) {                                              // Se a consulta é pelo Nome
            nomeRequest = EncodeString.converter(nomeRequest);                  // Tratando caracteres
            ArrayList<Checkin> checkinList = repository.getFindByName(nomeRequest);
            for (Checkin checkin : checkinList) {
                resultList.add(Diaria.calculaTotal(checkin));
            }
        }
        if (null != docRequest) {                                              // Se a consulta é pelo Documento
            ArrayList<Checkin> checkinList = repository.getFindByDoc(docRequest);
            for (Checkin checkin : checkinList) {
                resultList.add(Diaria.calculaTotal(checkin));
            }
        }
        if (null != foneRequest) {                                              // Se a consulta é pelo Telefone
            ArrayList<Checkin> checkinList = repository.getFindByFone(foneRequest);
            for (Checkin checkin : checkinList) {
                resultList.add(Diaria.calculaTotal(checkin));
            }
        }
        return resultList;
    }
    // Consulta hospedes com checkin em aberto
    @GetMapping(path = "/api/checkin/consultaHospedados")
    public Iterable<CheckinResult> listarHospedados() throws ParseException {
        // Lista para receber o repositorio
        ArrayList<Checkin> checkinList = repository.findHospedados();
        // Lista para o resultado
        ArrayList<CheckinResult> resultList = new ArrayList<>();
        CheckinResult result = new CheckinResult();

        for (Checkin checkin : checkinList) {
            result.setCheckin(checkin);
            resultList.add(result);
        }
        return resultList;
    }
    // Consulta checkouts
    @GetMapping(path = "/api/checkin/consultaCheckouts")
    public Iterable<CheckinResult> listaCheckouts() throws ParseException {
        // Lista para receber o repositorio
        ArrayList<Checkin> checkinList = repository.findCheckout();
        // Lista para o resultado
        ArrayList<CheckinResult> resultList = new ArrayList<>();

        for (Checkin checkin : checkinList) {
            resultList.add(Diaria.calculaTotal(checkin));
        }
        return resultList;
    }


}
