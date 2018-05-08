package com.formiga.java8;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class LocalDateTimeApp {

    private void verificar(int version) {
        if (version == 7) {
            Calendar data1 = Calendar.getInstance();
            Calendar data2 = Calendar.getInstance();

            data1.set(1990, Calendar.DECEMBER, 17);
            System.out.println(data1.after(data2));
        } else if (version == 8) {
            // locaDate
            LocalDate data1 = LocalDate.of(1990, 12, 17);
            LocalDate data2 = LocalDate.now();
            System.out.println(data1.isAfter(data2));
            System.out.println(data1.isBefore(data2));

            // localTime
            LocalTime time1 = LocalTime.of(22, 1, 15);
            LocalTime time2 = LocalTime.now();
            System.out.println(time1.isAfter(time2));
            System.out.println(time1.isBefore(time2));


            // localDateTime
            LocalDateTime dateTime1 = LocalDateTime.of(1990, 12, 17, 22, 1, 15);
            LocalDateTime dateTime2 = LocalDateTime.now();
            System.out.println(dateTime1.isAfter(dateTime2));
            System.out.println(dateTime1.isBefore(dateTime2));


        }
    }

    private void medirTempo(int version) throws InterruptedException {
        if (version == 7) {
            long inicio = System.currentTimeMillis();
            Thread.sleep(1000);
            long fim = System.currentTimeMillis();
            System.out.println(fim - inicio);
        } else if (version == 8) {
            Instant ini = Instant.now();
            Thread.sleep(1000);
            Instant fim = Instant.now();
            System.out.println(Duration.between(ini, fim).toMillis());
        }
    }

    private void periodoEntreDatas(int version) {
        if (version == 7) {
            Calendar nascimento = Calendar.getInstance();
            Calendar atual = Calendar.getInstance();

            nascimento.set(1990, 11, 17);

            int anos = 0;
            while (nascimento.before(atual)) {
                nascimento.add(Calendar.YEAR, 1);
                if (nascimento.before(atual)) {
                    anos++;
                }
            }
            System.out.println(anos);
        } else if (version == 8) {
            LocalDate nascimento = LocalDate.of(1990, 12, 17);
            LocalDate atual = LocalDate.now();

            Period periodo = Period.between(nascimento, atual);
            System.out.println(periodo.getYears() + " anos. " + periodo.getMonths() + " meses. " + periodo.getDays() + " dias, " +
                    "desde " + nascimento + " até " + atual);
        }
    }

    private void converter(int version) throws ParseException {
        if (version == 7) {
            String data = "17/12/1990";
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date dataConvertida = format.parse(data);
            System.out.println(dataConvertida);

            Date dataAtual = Calendar.getInstance().getTime();
            format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss a");
            String dateTimeString = format.format(dataAtual);
            System.out.println(dateTimeString);
        } else if (version == 8) {
            String data = "17/12/1990";
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dataLocal = LocalDate.parse(data, formatter);
            System.out.println(dataLocal);
            System.out.println(formatter.format(dataLocal));
        }
    }

    public static void main(String[] args) {
        LocalDateTimeApp localDateTimeApp = new LocalDateTimeApp();
        try {
//            localDateTimeApp.verificar(8);
//            localDateTimeApp.medirTempo(8);
//            localDateTimeApp.periodoEntreDatas(8);
//            localDateTimeApp.periodoEntreDatas(8);
            localDateTimeApp.converter(8);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
