package br.com.senior.desafiohotel.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@RestController
public class StatusController {

    @GetMapping(path = "/api/status")
    public String check(){
        return "online";
    }

    @GetMapping(path = "/api/teste")
    public String teste(){
        String timeStamp = new SimpleDateFormat("dd/MM/yyyy HH:mm")
                .format(Calendar.getInstance().getTime());
        Long data = new Date().getTime();

        String timeStamp2 = new SimpleDateFormat("dd/MM/yyyy HH:mm")
                .format(new Date().getTime());
        String resultado = "TS1: " + timeStamp + " TS2: " + timeStamp2;
        return resultado;
    }
}
