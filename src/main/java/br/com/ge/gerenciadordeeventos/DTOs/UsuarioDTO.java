package br.com.ge.gerenciadordeeventos.DTOs;

import br.com.ge.gerenciadordeeventos.domain.enums.UserFunction;
import br.com.ge.gerenciadordeeventos.domain.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
    private UUID id;
    private String login;
    private String email;
    private String CPF;
    private String nome;
    private String password;
    private UserRole role;
    private List<UserFunction> userFunctions;
}
