package br.com.appbarbearia.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@SpringBootTest(classes = AppBarbeariaApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HorarioMarcadoControllerTest {
    
    private static final String PORT = "http://localhost:8080";

    private static Cidade cidade = new Cidade();
    private static Endereco endereco = new Endereco();
    private static Barbeiro barbeiro = new Barbeiro();
    private static Cliente cliente = new Cliente();
    private static Horario horario = new Horario();

    @Autowired
    TestRestTemplate restTemplate;

    @Autowired
    private BarbeiroRepository barbeiroRepository;

    @Autowired
    private HorarioRepository horarioRepository;

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
        ParameterizedTypeReference<HorarioMarcado> tipoRetorno = new ParameterizedTypeReference<HorarioMarcado>() {
        };
        // Calendar calendar = Calendar.getInstance();
        // calendar.set(0, 0, 0, 1, 15);
        HorarioMarcado horarioMarcado = builder.withBarbeiro(barbeiro).withCliente(cliente).withHorario(horario).withDia(new Date()).build();
        HttpEntity<Object> httpEntity = new HttpEntity<>(horarioMarcado);

        ResponseEntity<HorarioMarcado> response = restTemplate.exchange(PORT + "/api/horarioMarcado", HttpMethod.POST,
         httpEntity, tipoRetorno);

        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertNotNull(response.getBody());
    }

    @Test
    public void test02_listaHorariosMarcados(){
        Optional<Barbeiro> opBarbeiro = barbeiroRepository.findById(barbeiro.getId());
        assertTrue(opBarbeiro.isPresent());
        Optional<Horario> opHorario = horarioRepository.findById(horario.getId());
        assertTrue(opHorario.isPresent());
        ParameterizedTypeReference<List<Horario>> tipoRetorno = new ParameterizedTypeReference<List<Horario>>() {
        };
        HttpEntity<String> entity = new HttpEntity<>(null);
        ResponseEntity<List<Horario>> response = restTemplate.exchange("/api/horarioMarcado/horariosDisponiveis/{barbeiro}/{data}", HttpMethod.GET,
        entity, tipoRetorno, barbeiro.getId(), new Date().getTime());
        
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        List<Horario> horarios = response.getBody(); 
        Optional<Horario> optionalHorario = horarios.stream().filter(h -> h.getId() == opHorario.get().getId()).findAny();
        assertFalse(optionalHorario.isPresent());
    }
}