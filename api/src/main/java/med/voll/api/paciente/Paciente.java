package med.voll.api.paciente;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.Endereco;
import med.voll.api.medico.DadosCadastroMedico;

@Table(name = "pacientes") // Anotação para especificar a tabela do banco de dados associada a esta classe
@Entity(name = "Paciente") // Anotação para indicar que esta classe é uma entidade JPA
@Getter // Lombok: gera automaticamente métodos getters para os campos
@NoArgsConstructor // Lombok: gera automaticamente um construtor sem argumentos
@AllArgsConstructor // Lombok: gera automaticamente um construtor com todos os argumentos
@EqualsAndHashCode(of = "id") 
public class Paciente {

	@Id // Indica que o campo 'id' é uma chave primária no banco de dados
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Define a estratégia de geração de valores para 'id'
														// (auto-incremento)
	private Long id;

	private String nome;
	private String email;
	private String telefone;
	private String cpf;

	@Embedded // Indica que 'endereco' é um objeto embutido no banco de dados
	private Endereco endereco; // Campo que armazena informações de endereço do médico

	 public Paciente(DadosCadastroPaciente dados) {
			this.nome = dados.nome();
			this.email = dados.email();
			this.telefone = dados.telefone();
			this.cpf = dados.cpf();
			this.endereco = new Endereco(dados.endereco());
		}
}
