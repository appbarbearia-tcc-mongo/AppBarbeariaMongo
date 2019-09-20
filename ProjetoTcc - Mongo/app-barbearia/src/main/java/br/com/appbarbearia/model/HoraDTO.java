package br.com.appbarbearia.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class HoraDTO {

    Hora hora;
    Minutos minutos;

    public Hora getHora() {
        return hora;
    }

    public void setHora(Hora hora) {
        this.hora = hora;
    }

    public Minutos getMinutos() {
        return minutos;
    }

    public void setMinutos(Minutos minutos) {
        this.minutos = minutos;
    }

    public static Calendar toCalendar(HoraDTO horaDTO) {
        Calendar calendar = Calendar.getInstance();
        int hora = horaDTO.getHora().getValue();
        calendar.set(1980, 1, 1);
        calendar.set(Calendar.HOUR, hora);
        int minutos = horaDTO.getMinutos().getValue();
        calendar.set(Calendar.MINUTE, minutos);
        calendar.set(Calendar.SECOND, 00);
        return calendar;
    }


    public static HoraDTO toHoraDTO(Calendar calendar) {
        HoraDTO horaDTO = new HoraDTO();
        DateFormat horaFormat = new SimpleDateFormat("hh");
        DateFormat minutosFormat = new SimpleDateFormat("mm");
        Hora horaValue = Hora.getValue(Integer.parseInt(horaFormat.format(calendar.getTime())));
        horaDTO.setHora(horaValue);
        Minutos minutosValue = Minutos.getValue(Integer.parseInt(minutosFormat.format(calendar.getTime())));
        horaDTO.setMinutos(minutosValue);
        return horaDTO;
    }

    public boolean equals(HoraDTO horaDTO){
        if(!this.hora.equals(horaDTO.getHora())){
            return false;
        } else if(!this.minutos.equals(horaDTO.getMinutos())){
            return false;
        }
        return true;
    }
}