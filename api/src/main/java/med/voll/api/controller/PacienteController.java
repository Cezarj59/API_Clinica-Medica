package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import med.voll.api.paciente.DadosCadastroPaciente;
import med.voll.api.paciente.Paciente;
import med.voll.api.paciente.PacienteRepository;

@RestController // Indica que esta classe é um controlador Rest que lida com requisições HTTP
@RequestMapping("pacientes") // Define o mapeamento da URL base para este controlador como "/pacientes"
public class PacienteController {

    @Autowired
    private PacienteRepository repository; // Injeta uma instância de PacienteRepository para interagir com o banco de dados

    @PostMapping // Mapeia a operação HTTP POST para este método
    @Transactional // Indica que esta operação é transacional, ou seja, envolve uma transação com o banco de dados
    public void cadastrar(@RequestBody @Valid DadosCadastroPaciente dados) {
        System.out.println(dados); // Imprime os dados recebidos no console (pode ser usado para fins de depuração)
        repository.save(new Paciente(dados)); // Cria um novo objeto Paciente com base nos dados recebidos e o salva no banco de dados
    }
}

