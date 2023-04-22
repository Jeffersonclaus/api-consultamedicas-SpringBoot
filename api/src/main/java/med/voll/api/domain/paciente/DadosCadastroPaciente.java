package med.voll.api.domain.paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.medico.DadosEndereco;

public record DadosCadastroPaciente(@NotBlank
        String nome,
        @NotBlank(message = "Nome é obrigatório")
        @Email
        String email,

        @NotBlank(message = "telefone é obrigatório")
        String telefone,
        @NotBlank(message = "cpf é obrigatório")
        @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")
        String cpf,

        @NotNull @Valid DadosEndereco endereco) {
}
