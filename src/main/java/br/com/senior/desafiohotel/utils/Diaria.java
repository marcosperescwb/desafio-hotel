package br.com.senior.desafiohotel.utils;

import br.com.senior.desafiohotel.model.Checkin;
import br.com.senior.desafiohotel.model.CheckinResult;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Diaria {

    public final static SimpleDateFormat analiseHora = new SimpleDateFormat("HH:mm");


    public static CheckinResult calculaTotal(Checkin checkin) throws ParseException {
        CheckinResult checklist = new CheckinResult();

        float totalDiaria = 0;
        long diariasSemana = 0,diariasFinalSemana = 0;
        if (null != checkin.getDataSaida()){
            // ## CALCULO DAS DIARIAS

            // #1 - Intervalo entre dataEntrada e dataSaida
            long temp01 = (checkin.getDataSaida().getTime() - checkin.getDataEntrada().getTime());

            // Converte millisegundos em dias
            TimeUnit dataDias = TimeUnit.DAYS;

            long diarias = dataDias.convert(temp01,TimeUnit.MILLISECONDS);


            // #2 - Verificação se houve checkout atrasado
            SimpleDateFormat sdfh = new SimpleDateFormat("HH:mm");
            String horaFormatada = sdfh.format(checkin.getDataSaida());
            Date limite = analiseHora.parse("16:30");
            Date fechamento = analiseHora.parse(horaFormatada);     // Comparação entre horários
            if (fechamento.after(limite)) {                         // Adiciona-se 1 diária se latecheckout
                Boolean lateCheckout;
                diarias++;
            }

            // #3 - Calcula o número de sabados e domingos usando a formula:
            // (DAY_OF_WEEK(dataEntrada - <dia>) - diasEntrada + diasSaida) / 7
            // INICIO
            long sabados = calculaNumDias(checkin,"sabado");
            long domingos = calculaNumDias(checkin,"domingo");

            // #4 - Calcula os dias de final de semana
            diariasFinalSemana = sabados + domingos;

            // #5 - Calcula os dias de semana
            diariasSemana = diarias - diariasFinalSemana;

            // #6 - Calcula os valores de diaria com base nos dias da semana
            totalDiaria = (diariasSemana * 120) + (diariasFinalSemana * 150);

            // #7 - Calcula o valores de estacionamento, caso haja
            if (checkin.isAdicionalVeiculo()){
                totalDiaria = totalDiaria + (diariasSemana * 15) + (diariasFinalSemana * 20);
            }
        }
        checklist.setCheckin(checkin);
        checklist.setTotalDiariasSemana(diariasSemana);
        checklist.setTotalDiariasFinalSemana(diariasFinalSemana);
        checklist.setValorTotal(totalDiaria);
        return checklist;
    }
    public static long calculaNumDias(Checkin checkin, String diaDaSemana){

        int num = 1;
        if (diaDaSemana.equals("sabado")){num = 7;}
        if (diaDaSemana.equals("domingo")){num = 1;}

        // Converte millisegundos em dias
        TimeUnit dataDias = TimeUnit.DAYS;

        Calendar temp02 = Calendar.getInstance();
        temp02.setTimeInMillis(checkin.getDataEntrada().getTime() - (86400000*num));

        // Verifica o dia da semana da data de checkin

        long temp03 = (checkin.getDataEntrada().getTime() - Calendar.getInstance().getTime().getTime());
        long diasEntrada = dataDias.convert(temp03,TimeUnit.MILLISECONDS);

        long temp04 = (checkin.getDataSaida().getTime() - Calendar.getInstance().getTime().getTime());
        long diasSaida = dataDias.convert(temp04,TimeUnit.MILLISECONDS);

        return (temp02.get(Calendar.DAY_OF_WEEK) - diasEntrada + diasSaida) / 7;

    }

}
