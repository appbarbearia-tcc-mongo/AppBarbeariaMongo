package br.com.appbarbearia.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.appbarbearia.app.barbearia.AppBarbeariaApplication;
import br.com.appbarbearia.model.Hora;
import br.com.appbarbearia.model.HoraDTO;
import br.com.appbarbearia.model.Horario;
import br.com.appbarbearia.model.Minutos;
import br.com.appbarbearia.repository.RepositoryTestHelper;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppBarbeariaApplication.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HorarioServiceLogicTest {

    @Autowired
    private HorarioService horarioService;

    @Autowired
    private RepositoryTestHelper rth;

    private static Horario horario;

    @Test
    public void test00_CleanUp(){
        rth.limpaBancoDeDados();
        horario = rth.criarHorario();
    }
    
    @Test
    public void test01_toCalendar(){
        Calendar calendar = horarioService.horaDtoToCalendar(horario.getHoraDTO());
        assertNotNull(calendar);
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String data = dateFormat.format(calendar.getTime());
        System.out.println(data);
    }

    @Test
    public void test02_toHoraDTO(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(1980, 1, 1, 4, 15, 0);
        HoraDTO horaDTO = horarioService.calendarToHoraDTO(calendar);
        assertEquals(horaDTO.getHora(), Hora.QUATRO);
        assertEquals(horaDTO.getMinutos(), Minutos.QUINZE_MINUTOS);
    }
}