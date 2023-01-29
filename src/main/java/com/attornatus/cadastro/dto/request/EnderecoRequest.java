package com.attornatus.cadastro.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import javax.validation.constraints.*;


@Data
@AllArgsConstructor
@Builder
public class EnderecoRequest {

    @NotNull(message = "Campo logradouro não pode ser nulo")
    @Size(min=4, max = 250, message = "Campo logradouro Ultrapassou o limite de caracteres")
    @JsonFormat(pattern = "Rua das flores", shape = JsonFormat.Shape.STRING)
    private String logradluro;

    @Size(max = 9, message = "Campo CEP Ultrapassou o limite de caracteres")
    @Pattern(regexp="^\\d{5}(-\\d{3})?$", message = "CEP inválido, usar a mascara 'xxxxx-xxx'")
    @Schema(description = "CEP", example = "90050-230")
    @JsonFormat(pattern = "90050-230", shape = JsonFormat.Shape.STRING)
    private String cep;

    @NotNull
    private Integer numero;

    @NotBlank
    @JsonFormat(pattern = "São Francisco", shape = JsonFormat.Shape.STRING)
    private String cidade;
}
