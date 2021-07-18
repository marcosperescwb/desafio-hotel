package br.com.senior.desafiohotel.utils;

import br.com.senior.desafiohotel.model.CheckinModel;
import br.com.senior.desafiohotel.model.CheckinResult;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Diaria {

    public final static SimpleDateFormat analiseHora = new SimpleDateFormat("HH:mm");
    public final static SimpleDateFormat analiseData = new SimpleDateFormat("dd/MM/yyyy");

    public static CheckinResult calculaTotal(CheckinModel checkin) throws ParseException {
        CheckinResult checklist = new CheckinResult();


        if (null != checkin.getDataSaida()){
            // Calculo das diarias
            long dif = (checkin.getDataSaida().getTime() - checkin.getDataEntrada().getTime());
            TimeUnit data = TimeUnit.DAYS;
            int diarias = (int) data.convert(dif,TimeUnit.MILLISECONDS);

            System.out.println("Valor de DIF: " + dif);
            // Verificação se houve checkout atrasado
            // Comparação com horário do checkout e 16h30
            // Adiciona-se 1 diária e aumenta o intervalo
            SimpleDateFormat sdfh = new SimpleDateFormat("HH:mm");
            String horaFormatada = sdfh.format(checkin.getDataSaida());
            Date limite = analiseHora.parse("16:30");
            Date fechamento = analiseHora.parse(horaFormatada);
            if (fechamento.after(limite)) {
                Boolean lateCheckout;
                diarias++;
            }


            // Calcula o número de sabados

            // Diminui o dia da semana pela dataEntrada
            long dif2 = (checkin.getDataEntrada().getTime() - (86400000*7));
            TimeUnit data2 = TimeUnit.DAYS;
            long temp = data2.convert(dif2,TimeUnit.MILLISECONDS);

            SimpleDateFormat formatadata = new SimpleDateFormat();
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(dif2);
            System.out.println("Calendar: " + calendar.get(Calendar.DAY_OF_WEEK));

            // Verifica o dia da semana da data de checkin
            Calendar calendario = Calendar.getInstance();
            calendario.setTime(checkin.getDataEntrada());
            int diaSemanaEntrada = calendario.get(Calendar.DAY_OF_WEEK);
            System.out.println("Dia da Semana: " + diaSemanaEntrada);

            long dif4 = (checkin.getDataEntrada().getTime() - Calendar.getInstance().getTime().getTime());
            TimeUnit data4 = TimeUnit.DAYS;
            long temp4 = data4.convert(dif4,TimeUnit.MILLISECONDS);

            long dif3 = (checkin.getDataSaida().getTime() - Calendar.getInstance().getTime().getTime());
            TimeUnit data3 = TimeUnit.DAYS;
            long temp2 = data2.convert(dif3,TimeUnit.MILLISECONDS);
            System.out.println("Data Entrada: " + temp4);
            long temp3 = (calendar.get(Calendar.DAY_OF_WEEK) - temp4 + temp2) / 7;
            System.out.println("Data Saida: " + temp2);
            System.out.println("Será que deu certo? " + temp3);


            //Date dataIni,dataFim;
            //SimpleDateFormat sdfd = new SimpleDateFormat("dd/MM/yyyy");
            //String dataSaida = sdfd.format(checkin.getDataSaida());
            //String dataEntrada = sdfd.format(checkin.getDataEntrada());
            //dataIni
            //long sabados = (diaSemanaEntrada - 7 - dataEntrada + dataSaida)/7;

            System.out.println("Diarias: " + diarias);
        }
        checklist.setCheckin(checkin);
        checklist.setTotal(0.0F);
        return checklist;
    }

}
