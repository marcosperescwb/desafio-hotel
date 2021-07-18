package br.com.senior.desafiohotel.controller;

import br.com.senior.desafiohotel.model.CheckinModel;
import br.com.senior.desafiohotel.model.CheckinResult;
import br.com.senior.desafiohotel.repository.CheckinRepository;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
                           @RequestParam(value="telefone", required = false) String foneRequest){

        //Lista para verificações
        ArrayList<CheckinModel> checkinList = (ArrayList<CheckinModel>) repository.findAll();
        //Lista para o resultado
        ArrayList<CheckinResult> resultList = new ArrayList<>();

        if (null != nomeRequest) { //Se a consulta é pelo Nome
            for (CheckinModel checkin : checkinList) {
                System.out.println("Nome : " + checkin.getHospede().getNome());
                if (checkin.getHospede().getNome().equals(nomeRequest)) {
                    resultList.add(calculaTotal(checkin));
                }
            }
        }
        if (null != docRequest) {  //Se a consulta é pelo Documento
            for (CheckinModel checkin : checkinList) {
                if (checkin.getHospede().getDocumento().equals(docRequest)) {
                    resultList.add(calculaTotal(checkin));
                }
            }
        }
        if (null != foneRequest) {  //Se a consulta é pelo Telefone
            for (CheckinModel checkin : checkinList) {
                if (checkin.getHospede().getTelefone().equals(foneRequest)) {
                    resultList.add(calculaTotal(checkin));
                }
            }
        }
        return resultList;
    }
    // Consultar checkin em aberto
 /*   @GetMapping(path = "/api/checkin/Hospedados")
    public Iterable<CheckinModel> hospedados(){
        ArrayList<CheckinModel> checkinList = (ArrayList<CheckinModel>) repository.findAll();
        ArrayList<CheckinModel> resultList = new ArrayList<>();

        return CheckinResult.totaliza(resultList);
    }*/
    public CheckinResult calculaTotal(CheckinModel checkin){
        CheckinResult checklist = new CheckinResult();
        if (null != checkin.getDataSaida()){
            /*
		            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		            Date hora = Calendar.getInstance().getTime(); // Ou qualquer outra forma que tem
		            String dataFormatada = sdf.format(hora);
             */

            SimpleDateFormat sdf = new SimpleDateFormat("hh");
            String dataFormatada = sdf.format(checkin.getDataSaida());
            long dif = (long) (checkin.getDataSaida().getTime() - checkin.getDataEntrada().getTime());
            TimeUnit time = TimeUnit.DAYS;
            int diarias = (int) time.convert(dif,TimeUnit.MILLISECONDS);
            System.out.println(checkin.getDataSaida().getTime());
            System.out.println(dataFormatada);
        }
        checklist.setCheckin(checkin);
        checklist.setTotal(0.0F);
        return checklist;
    }
}
