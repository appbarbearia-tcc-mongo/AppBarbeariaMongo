package br.com.appbarbearia.repository;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.appbarbearia.model.Barbearia;
import br.com.appbarbearia.model.Barbeiro;
import br.com.appbarbearia.model.Cidade;
import br.com.appbarbearia.model.Cliente;
import br.com.appbarbearia.model.Endereco;
import br.com.appbarbearia.model.Estados;
import br.com.appbarbearia.model.Horario;

@Component
public class RepositoryTestHelper {

	@Autowired
	BarbeiroRepository barbeiroRepository;

	@Autowired
	BarbeariaRepository barbeariaRepository;

	@Autowired
	CidadeRepository cidadeRepository;

	@Autowired
	EnderecoRepository enderecoRepository;

	@Autowired
	HorarioRepository horarioRepository;

	@Autowired 
	HorarioMarcadoRepository horarioMarcadoRepository;

	@Autowired
	PromocaoRepository promocaoRepository;

	@Autowired
	ServicoRepository servicoRepository;

	@Autowired
	ClienteRepository clienteRepository;

	public void limpaBancoDeDados(){
		horarioMarcadoRepository.deleteAll();
		clienteRepository.deleteAll();
		promocaoRepository.deleteAll();
		servicoRepository.deleteAll();
		barbeariaRepository.deleteAll();
		barbeiroRepository.deleteAll();
		enderecoRepository.deleteAll();
		cidadeRepository.deleteAll();
		horarioRepository.deleteAll();
	}

	public Cidade criarCidade() {
		String[][] cidadeData = new String[][] { { "Salto", "SP" }, { "Indaiatuba", "SP" } };

		boolean retorna = true;
		Cidade cidadeRetorno = new Cidade();
		for (String[] cidadeInfo : cidadeData) {
			Cidade cidade = new Cidade();
			int idx = 0;
			cidade.setNome(cidadeInfo[idx++]);
			cidade.setEstado(Estados.valueOf(cidadeInfo[idx++]));
			if (retorna) {
				cidadeRetorno = cidadeRepository.save(cidade);
				retorna = false;
			} else {
				cidadeRepository.save(cidade);
			}
		}
		return cidadeRetorno;
	}

	public Endereco criarEndereco() {
		Cidade cidade = criarCidade();

		boolean retorna = true;
		Endereco enderecoRetorno = new Endereco();
		String[][] enderecoData = new String[][] { { "Rua Coelho Neto", "338", "13320-520" },
				{"Rua Brasil", "257", "13320-500" } };
		for (String[] enderecoInfo : enderecoData) {
			int idx = 0;
			Endereco endereco = new Endereco();
			endereco.setCidade(cidade);
			endereco.setEndereco(enderecoInfo[idx++]);
			endereco.setNumero(Integer.parseInt(enderecoInfo[idx++]));
			endereco.setCep(enderecoInfo[idx++]);
			if (retorna) {
				enderecoRetorno = enderecoRepository.save(endereco);
				retorna = false;
			} else {
				enderecoRepository.save(endereco);
			}
		}
		return enderecoRetorno;
	}

	public Endereco criarEndereco(Cidade cidade) {
		boolean retorna = true;
		Endereco enderecoRetorno = new Endereco();
		String[][] enderecoData = new String[][] { { "Rua Coelho Neto", "338", "13320-520" },
				{"Rua Brasil", "257", "13320-500" } };
		for (String[] enderecoInfo : enderecoData) {
			int idx = 0;
			Endereco endereco = new Endereco();
			endereco.setCidade(cidade);
			endereco.setEndereco(enderecoInfo[idx++]);
			endereco.setNumero(Integer.parseInt(enderecoInfo[idx++]));
			endereco.setCep(enderecoInfo[idx++]);
			if (retorna) {
				enderecoRetorno = enderecoRepository.save(endereco);
				retorna = false;
			} else {
				enderecoRepository.save(endereco);
			}
		}
		return enderecoRetorno;
	}

	public Barbeiro criarBarbeiro() {
		Cidade cidade = criarCidade();
		Barbearia barbearia = criarBarbearia();
		Barbeiro barbeiroRetorno = new Barbeiro();
		boolean retorna = true;

		String[][] barbeiroData = new String[][] {
				{"LUGOR", "50.037.334-6", "433044988/93", "46021192", "972932872" },
				{"LUIS", "11.111.111-6", "222222222/43", "46021192", "943026511" } };
		for (String[] barbeiroInfo : barbeiroData) {
			int idx = 0;
			Calendar calendar = Calendar.getInstance();
			Barbeiro barbeiro = new Barbeiro();
			barbeiro.setCidade(cidade);
			barbeiro.setBarbearia(barbearia);
			barbeiro.setNome(barbeiroInfo[idx++]);
			barbeiro.setRg(barbeiroInfo[idx++]);
			barbeiro.setCpf(barbeiroInfo[idx++]);
			barbeiro.setTelefone(Integer.parseInt(barbeiroInfo[idx++]));
			barbeiro.setCelular(Integer.parseInt(barbeiroInfo[idx++]));
			if (barbeiro.getNome().contains("LUCAS")) {
				calendar.set(1998, 06, 20);
				barbeiro.setDataNascimento(calendar.getTime());
			} else {
				calendar.set(1969, 10, 1);
				barbeiro.setDataNascimento(calendar.getTime());
			}
			if (retorna) {
				barbeiroRetorno = barbeiroRepository.save(barbeiro);
				retorna = false;
			} else {
				barbeiroRepository.save(barbeiro);
			}
		}
		return barbeiroRetorno;
	}

	public Barbeiro criarBarbeiro(Cidade cidade, Barbearia barbearia) {
		Barbeiro barbeiroRetorno = new Barbeiro();
		boolean retorna = true;

		String[][] barbeiroData = new String[][] {
				{"LUGOR", "50.037.334-6", "433044988/93", "46021192", "972932872" },
				{"LUIS", "11.111.111-6", "222222222/43", "46021192", "943026511" } };
		for (String[] barbeiroInfo : barbeiroData) {
			int idx = 0;
			Calendar calendar = Calendar.getInstance();
			Barbeiro barbeiro = new Barbeiro();
			barbeiro.setCidade(cidade);
			barbeiro.setBarbearia(barbearia);
			barbeiro.setNome(barbeiroInfo[idx++]);
			barbeiro.setRg(barbeiroInfo[idx++]);
			barbeiro.setCpf(barbeiroInfo[idx++]);
			barbeiro.setTelefone(Integer.parseInt(barbeiroInfo[idx++]));
			barbeiro.setCelular(Integer.parseInt(barbeiroInfo[idx++]));
			if (barbeiro.getNome().contains("LUCAS")) {
				calendar.set(1998, 06, 20);
				barbeiro.setDataNascimento(calendar.getTime());
			} else {
				calendar.set(1969, 10, 1);
				barbeiro.setDataNascimento(calendar.getTime());
			}
			if (retorna) {
				barbeiroRetorno = barbeiroRepository.save(barbeiro);
				retorna = false;
			} else {
				barbeiroRepository.save(barbeiro);
			}
		}
		return barbeiroRetorno;
	}

	public Horario criarHorario() {
		String[][] horarioData = new String[][] { { "UMA HORA E 15 MINUTOS" }, { "DUAS HORAS E 15 MINUTOS" } };

		Horario horarioRetorno = new Horario();
		boolean retorna = true;

		for (String[] horarioInfo : horarioData) {
			Horario horario = new Horario();
			Calendar calendar = Calendar.getInstance();
			int idx = 0;
			horario.setDescricao(horarioInfo[idx++]);
			if (horario.getDescricao().contains("UMA HORA E 15 MINUTOS")) {
				calendar.set(Calendar.HOUR_OF_DAY, 1);
				calendar.set(Calendar.MINUTE, 15);
				calendar.set(Calendar.SECOND, 0);
				calendar.set(0, 0, 0);
				horario.setHora(calendar.getTime());
			} else {
				calendar.set(Calendar.HOUR_OF_DAY, 2);
				calendar.set(Calendar.MINUTE, 15);
				calendar.set(Calendar.SECOND, 0);
				calendar.set(0000, 00, 00);
				horario.setHora(calendar.getTime());
			}
			if (retorna) {
				horarioRetorno = horarioRepository.save(horario);
				retorna = false;
			} else {
				horarioRepository.save(horario);
			}
		}
		return horarioRetorno;
	}

	public Cliente criarCliente() {
		Cidade cidade = criarCidade();

		Cliente clienteRetorno = new Cliente();
		boolean retorna = true;

		String[][] clienteData = new String[][] {
				{"LUGOR", "50.037.334-6", "433044988/93", "46021192", "972932872" },
				{"LUIS", "11.111.111-6", "222222222/43", "46021192", "943026511" } };
		for (String[] clienteInfo : clienteData) {
			Calendar calendar = Calendar.getInstance();
			int idx = 0;
			Cliente cliente = new Cliente();
			cliente.setCidade(cidade);
			cliente.setNome(clienteInfo[idx++]);
			cliente.setRg(clienteInfo[idx++]);
			cliente.setCpf(clienteInfo[idx++]);
			cliente.setTelefone(Integer.parseInt(clienteInfo[idx++]));
			cliente.setCelular(Integer.parseInt(clienteInfo[idx++]));
			if (cliente.getNome().contains("LUCAS")) {
				calendar.set(1997, 06, 20);
				cliente.setDataNascimento(calendar.getTime());
			} else {
				calendar.set(1970, 06, 20);
				cliente.setDataNascimento(calendar.getTime());
			}
			if (retorna) {
				clienteRetorno = clienteRepository.save(cliente);
				retorna = false;
			} else {
				clienteRepository.save(cliente);
			}
		}
		return clienteRetorno;
	}

	public Cliente criarCliente(Cidade cidade) {

		Cliente clienteRetorno = new Cliente();
		boolean retorna = true;

		String[][] clienteData = new String[][] {
				{"LUGOR", "50.037.334-6", "433044988/93", "46021192", "972932872" },
				{"LUIS", "11.111.111-6", "222222222/43", "46021192", "943026511" } };
		for (String[] clienteInfo : clienteData) {
			Calendar calendar = Calendar.getInstance();
			int idx = 0;
			Cliente cliente = new Cliente();
			cliente.setCidade(cidade);
			cliente.setNome(clienteInfo[idx++]);
			cliente.setRg(clienteInfo[idx++]);
			cliente.setCpf(clienteInfo[idx++]);
			cliente.setTelefone(Integer.parseInt(clienteInfo[idx++]));
			cliente.setCelular(Integer.parseInt(clienteInfo[idx++]));
			if (cliente.getNome().contains("LUCAS")) {
				calendar.set(1997, 06, 20);
				cliente.setDataNascimento(calendar.getTime());
			} else {
				calendar.set(1970, 06, 20);
				cliente.setDataNascimento(calendar.getTime());
			}
			if (retorna) {
				clienteRetorno = clienteRepository.save(cliente);
				retorna = false;
			} else {
				clienteRepository.save(cliente);
			}
		}
		return clienteRetorno;
	}

	public Barbearia criarBarbearia() {
		Endereco endereco = criarEndereco();

		Barbearia barbeariaRetorno = new Barbearia();
		boolean retorna = true;

		String[][] barbeariaData = new String[][] {
				{ "Barbearia do Juquinha", "A melhor barbearia da região... BY FAR", "1" },
				{ "Barbearia do Zezinho", "Melhor do que a do Juquinha... BY THE WAY", "2" } };

		for (String[] barbeariaInfo : barbeariaData) {
			int idx = 0;
			Calendar calendar = Calendar.getInstance();
			Barbearia barbearia = new Barbearia();
			barbearia.setNome(barbeariaInfo[idx++]);
			barbearia.setDescricao(barbeariaInfo[idx++]);
			barbearia.setEndereco(endereco);
			calendar.set(Calendar.HOUR_OF_DAY, 9);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			barbearia.setHorarioAbertura(calendar.getTime());
			calendar.set(Calendar.HOUR_OF_DAY, 18);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			barbearia.setHorarioFechamento(calendar.getTime());
			if (retorna) {
				barbeariaRetorno = barbeariaRepository.save(barbearia);
				retorna = false;
			} else {
				barbeariaRepository.save(barbearia);
			}
		}
		return barbeariaRetorno;
	}

	public Barbearia criarBarbearia(Endereco endereco) {

		Barbearia barbeariaRetorno = new Barbearia();
		boolean retorna = true;

		String[][] barbeariaData = new String[][] {
				{ "Barbearia do Juquinha", "A melhor barbearia da região... BY FAR", "1" },
				{ "Barbearia do Zezinho", "Melhor do que a do Juquinha... BY THE WAY", "2" } };

		for (String[] barbeariaInfo : barbeariaData) {
			int idx = 0;
			Calendar calendar = Calendar.getInstance();
			Barbearia barbearia = new Barbearia();
			barbearia.setNome(barbeariaInfo[idx++]);
			barbearia.setDescricao(barbeariaInfo[idx++]);
			barbearia.setEndereco(endereco);
			calendar.set(Calendar.HOUR_OF_DAY, 9);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			barbearia.setHorarioAbertura(calendar.getTime());
			calendar.set(Calendar.HOUR_OF_DAY, 18);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			barbearia.setHorarioFechamento(calendar.getTime());
			if (retorna) {
				barbeariaRetorno = barbeariaRepository.save(barbearia);
				retorna = false;
			} else {
				barbeariaRepository.save(barbearia);
			}
		}
		return barbeariaRetorno;
	}
}