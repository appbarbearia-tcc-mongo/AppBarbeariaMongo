package br.com.appbarbearia.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.appbarbearia.app.barbearia.AppBarbeariaApplication;
import br.com.appbarbearia.model.Barbearia;
import br.com.appbarbearia.model.Barbeiro;
import br.com.appbarbearia.model.Cidade;
import br.com.appbarbearia.model.Cliente;
import br.com.appbarbearia.model.Endereco;
import br.com.appbarbearia.model.Horario;
import br.com.appbarbearia.model.HorarioMarcado;
import br.com.appbarbearia.model.HorarioMarcado.HorarioMarcadoBuilder;
import br.com.appbarbearia.repository.BarbeiroRepository;
import br.com.appbarbearia.repository.HorarioRepository;
import br.com.appbarbearia.repository.RepositoryTestHelper;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppBarbeariaApplication.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HorarioMarcadoServiceLogicTest {

    private static Cidade cidade = new Cidade();
    private static Endereco endereco = new Endereco();
    private static Barbeiro barbeiro = new Barbeiro();
    private static Cliente cliente = new Cliente();
    private static Horario horario = new Horario();


    @Autowired
    HorarioMarcadoService horarioMarcadoService;

    @Autowired
    BarbeiroRepository barbeiroRepository;

    @Autowired
    HorarioRepository horarioRepository;

    @Autowired
    RepositoryTestHelper rth;

    @Test
    public void test00_setUp(){
        rth.limpaBancoDeDados();
        cidade = rth.criarCidade();
        endereco = rth.criarEndereco(cidade);
        Barbearia barbearia = rth.criarBarbearia(endereco);
        barbeiro = rth.criarBarbeiro(cidade, barbearia);
        cliente = rth.criarCliente(cidade);
        horario = rth.criarHorario();
    }

    @Test
    public void test01_save(){
        HorarioMarcadoBuilder builder = HorarioMarcado.builder();
        HorarioMarcado horarioMarcado = builder.withBarbeiro(barbeiro).withCliente(cliente).withHorario(horario).withDia(new Date()).build();

        Optional<HorarioMarcado> opHorarioMarcado = horarioMarcadoService.save(horarioMarcado);
        assertTrue(opHorarioMarcado.isPresent());
    }

    @Test
    public void test02_listaHorariosDisponiveis(){
        Optional<Barbeiro> opBarbeiro = barbeiroRepository.findById(barbeiro.getId());
        assertTrue(opBarbeiro.isPresent());
        Optional<Horario> opHorario = horarioRepository.findById(horario.getId());
        assertTrue(opHorario.isPresent());
        
        List<Horario> horarios = horarioMarcadoService.listaHorariosDisponiveisBarbeiro(opBarbeiro.get(), new Date());
        assertFalse(horarios.isEmpty());
        Optional<Horario> optionalHorario = horarios.stream().filter(h -> h.getId() == opHorario.get().getId()).findAny();
        assertFalse(optionalHorario.isPresent());
    }
    
}