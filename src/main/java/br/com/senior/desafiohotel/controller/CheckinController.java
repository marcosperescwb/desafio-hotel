package br.com.senior.desafiohotel.controller;

import br.com.senior.desafiohotel.model.CheckinModel;
import br.com.senior.desafiohotel.model.CheckinResult;
import br.com.senior.desafiohotel.repository.CheckinRepository;
import br.com.senior.desafiohotel.utils.Diaria;
import javassist.Loader;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

@RestController
public class CheckinController {

    public CheckinRepository repository;


    public CheckinController(CheckinRepository repository) {
        this.repository = repository;
    }

    // Incluir Checkin
    @PostMapping(path = "/api/checkin/incluiCheckin" )
    public CheckinModel incluir(@RequestBody CheckinModel checkin){
        return repository.save(checkin);
    }

    // Consultar checkin pelos dados do hospede
    @GetMapping(path = "/api/checkin/consultaHospede")
    public Iterable<CheckinResult>
                listarNome(@RequestParam(value="nome", required = false) String nomeRequest,
                           @RequestParam(value="documento", required = false) String docRequest,
                           @RequestParam(value="telefone", required = false) String foneRequest) throws ParseException {

        //Lista para verificações
        ArrayList<CheckinModel> checkinList = (ArrayList<CheckinModel>) repository.findAll();
        //Lista para o resultado
        ArrayList<CheckinResult> resultList = new ArrayList<>();

        if (null != nomeRequest) { //Se a consulta é pelo Nome
            for (CheckinModel checkin : checkinList) {
                System.out.println("Nome : " + checkin.getHospede().getNome());
                if (checkin.getHospede().getNome().equals(nomeRequest)) {
                    resultList.add(Diaria.calculaTotal(checkin));
                }
            }
        }
        if (null != docRequest) {  //Se a consulta é pelo Documento
            for (CheckinModel checkin : checkinList) {
                if (checkin.getHospede().getDocumento().equals(docRequest)) {
                    resultList.add(Diaria.calculaTotal(checkin));
                }
            }
        }
        if (null != foneRequest) {  //Se a consulta é pelo Telefone
            for (CheckinModel checkin : checkinList) {
                if (checkin.getHospede().getTelefone().equals(foneRequest)) {
                    resultList.add(Diaria.calculaTotal(checkin));
                }
            }
        }
        return resultList;

    }
}
