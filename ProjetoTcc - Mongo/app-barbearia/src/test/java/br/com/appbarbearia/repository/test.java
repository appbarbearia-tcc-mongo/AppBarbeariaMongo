package br.com.appbarbearia.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

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
import br.com.appbarbearia.model.Cidade;
import br.com.appbarbearia.model.Endereco;
import br.com.appbarbearia.model.Estados;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppBarbeariaApplication.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class test {
    
    @Autowired
    CidadeRepository cidadeRepository;

    @Autowired
    EnderecoRepository enderecoRepository;

    private static Cidade cidadeInserida = null;

    @Test
    public void test00_findById(){
        Optional<Cidade> opCidade = cidadeRepository.findById("5d30f4c5b3ff4e2764c9adb0");
        assertTrue(opCidade.isPresent());
        assertTrue(opCidade.get().getNome().equals("Salto"));
    }

    @Test
    public void test01_findAll(){
        List<Cidade> cidades = cidadeRepository.findAll();
        assertTrue(cidades.size() == 2);
    }

    @Test
    public void test02_save(){
        Cidade cidade = new Cidade();
        cidade.setNome("Itu");
        cidade.setEstado(Estados.SP);
        assertNull(cidade.getId());
        Cidade retornoCidade = cidadeRepository.save(cidade);
        assertNotNull(retornoCidade);
        assertNotNull(retornoCidade.getId());
        cidadeInserida = retornoCidade;
    }

    @Test
    public void test03_saveEndereco(){
        Endereco endereco = new Endereco();
        endereco.setCidade(cidadeInserida);
        endereco.setEndereco("Rua Coelho Neto - Jd. três Marias");
        endereco.setCep("13320-520");
        endereco.setNumero(338);
        assertNull(endereco.getId());
        Endereco enderecoRetorno = enderecoRepository.save(endereco);
        assertNotNull(enderecoRetorno);
        assertNotNull(enderecoRetorno.getId());
    }
}