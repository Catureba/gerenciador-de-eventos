package br.com.ge.gerenciadordeeventos.DTOs;

import br.com.ge.gerenciadordeeventos.domain.enums.UserFunction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumoUsuarioDTO {
    private UUID id;
    private String nome;
    private List<UserFunction> userFunctions;
}
