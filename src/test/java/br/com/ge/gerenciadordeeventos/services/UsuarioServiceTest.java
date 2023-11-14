package br.com.ge.gerenciadordeeventos.services;

import br.com.ge.gerenciadordeeventos.DTOs.UsuarioDTO;
import br.com.ge.gerenciadordeeventos.domain.entities.Usuario;
import br.com.ge.gerenciadordeeventos.domain.enums.UserFunction;
import br.com.ge.gerenciadordeeventos.domain.enums.UserRole;
import br.com.ge.gerenciadordeeventos.repositories.IUsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class UsuarioServiceTest {

    @InjectMocks
    UsuarioService service;

    @Mock
    IUsuarioRepository repository;

    Usuario usuario = new Usuario();
    Usuario usuario01 = new Usuario();
    UsuarioDTO usuarioDTO = new UsuarioDTO();
    UsuarioDTO usuarioDTO01 = new UsuarioDTO();

    @BeforeEach
    public void  setUp(){
        // setando um usuario
        usuario.setId(UUID.randomUUID());
        usuario.setLogin("Bianca");
        usuario.setEmail("bianca@example.com");
        usuario.setCPF("123.456.789-01");
        usuario.setNome("Bianca");
        usuario.setPassword("senha123");
        usuario.setRole(UserRole.USER);
        usuario.setUser_functions(List.of(UserFunction.STAND, UserFunction.VOLANTE));

        // setando um usuarioDTO
        usuarioDTO.setId(UUID.randomUUID());
        usuarioDTO.setLogin("Alexandre");
        usuarioDTO.setEmail("alexandre@example.com");
        usuarioDTO.setCPF("123.456.789-01");
        usuarioDTO.setNome("Alexandre");
        usuarioDTO.setPassword("senhaUsuarioDTO");
        usuarioDTO.setRole(UserRole.USER);
        usuarioDTO.setUserFunctions(List.of(UserFunction.EXTERNO, UserFunction.SUPERVISAO));
    }
    @Test
    void buscarUsuarioPorID() {
        //ARRANGE
        usuario01.setId(UUID.randomUUID());
        usuario01.setLogin("Bianca");
        usuario01.setEmail("bianca@example.com");
        usuario01.setCPF("123.456.789-01");
        usuario01.setNome("Bianca");
        usuario01.setPassword("senha123");
        usuario01.setRole(UserRole.USER);
        usuario01.setUser_functions(List.of(UserFunction.STAND, UserFunction.VOLANTE));

        usuarioDTO01.setId(usuario01.getId());
        usuarioDTO01.setLogin("Bianca");
        usuarioDTO01.setEmail("bianca@example.com");
        usuarioDTO01.setCPF("123.456.789-01");
        usuarioDTO01.setNome("Bianca");
        usuarioDTO01.setPassword("senha123");
        usuarioDTO01.setRole(UserRole.USER);
        usuarioDTO01.setUserFunctions(List.of(UserFunction.STAND, UserFunction.VOLANTE));

        when(repository.findById(usuario01.getId())).thenReturn(Optional.of(usuario01));

        //ACT
        UsuarioDTO response = service.buscarUsuarioPorID(usuario.getId());

        //ASSERT
        assertEquals(response, usuarioDTO01);
    }

    @Test
    void buscarUsuarioPorEmail() {
    }

    @Test
    void buscarUsuarioPorNome() {
    }

    @Test
    void buscarUsuarioPorCPF() {
    }

    @Test
    void buscarTodosOsUsuarios() {
    }

    @Test
    void cadastrar() {
    }

    @Test
    void deletar() {
    }

    @Test
    void atualizar() {
    }

    @Test
    void buscarTodosOsUsuariosPorFuncao() {
    }
}