package med.voll.api.domain.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroMedico(
		
		@NotBlank(message = "nome é obrigatório")
		String nome,
		@NotBlank(message = "email é obrigatório")
		@Email
		String email,
		@NotBlank(message = "telefone é obrigatório")
		String telefone,
		@NotBlank(message = "cpf é obrigatório")
		@Pattern(regexp= "\\d{4,6}")
		String crm,
		@NotNull(message = "especialista é obrigatório")
		Especialidade especialista,
		@NotNull(message = "Dados do endereço é obrigatório")
		@Valid
		DadosEndereco  endereco) {
	
	
}
