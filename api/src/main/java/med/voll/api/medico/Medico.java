package med.voll.api.medico;  // Pacote onde a classe Medico está localizada

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.Endereco;

@Table(name = "medicos")  // Anotação para especificar a tabela do banco de dados associada a esta classe
@Entity(name = "Medico")  // Anotação para indicar que esta classe é uma entidade JPA
@Getter  // Lombok: gera automaticamente métodos getters para os campos
@NoArgsConstructor  // Lombok: gera automaticamente um construtor sem argumentos
@AllArgsConstructor  // Lombok: gera automaticamente um construtor com todos os argumentos
@EqualsAndHashCode(of = "id")  // Lombok: gera automaticamente métodos equals e hashCode usando o campo 'id'

public class Medico {   

	@Id  // Indica que o campo 'id' é uma chave primária no banco de dados
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Define a estratégia de geração de valores para 'id' (auto-incremento)
    private Long id;  

    private String nome; 
    private String email;  
    private String telefone;  
    private String crm;  

    @Enumerated(EnumType.STRING)  // Indica que 'especialidade' é uma enumeração armazenada como uma string no banco de dados
    private Especialidade especialidade;  // Campo que armazena a especialidade médica do médico

    @Embedded  // Indica que 'endereco' é um objeto embutido no banco de dados
    private Endereco endereco;  // Campo que armazena informações de endereço do médico

    
    public Medico(DadosCadastroMedico dados) {
		this.nome = dados.nome();
		this.email = dados.email();
		this.telefone = dados.telefone();
		this.crm = dados.crm();
		this.especialidade = dados.especialidade();
		this.endereco = new Endereco(dados.endereco());
	}
}
