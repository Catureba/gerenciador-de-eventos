package br.com.ge.gerenciadordeeventos.controllers;

import br.com.ge.gerenciadordeeventos.DTOs.UsuarioDTO;
import br.com.ge.gerenciadordeeventos.domain.enums.UserFunction;
import br.com.ge.gerenciadordeeventos.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/V1/users")
public class UsuarioController {
    @Autowired
    UsuarioService service;
    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listarTodosOsUsuarios() {
        try{
            List<UsuarioDTO> todosOsUsuarios = service.buscarTodosOsUsuarios();
            return ResponseEntity.status(HttpStatus.OK).body(todosOsUsuarios);
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }

    @PutMapping
    public ResponseEntity<UsuarioDTO> editarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        try{
            usuarioDTO = service.atualizar(usuarioDTO);
            return ResponseEntity.status(HttpStatus.OK).body(usuarioDTO);
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarUsuarioPorID(@PathVariable UUID id) {
        try{
            service.deletar(id);
            return  ResponseEntity.status(HttpStatus.NO_CONTENT).body("Usuario deletado: " + id);
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }
    @GetMapping("/buscarUsuariosPorFuncao/{function}")
    public ResponseEntity<List<UsuarioDTO>> buscarTodosOsUsuariosPorFuncao(@PathVariable UserFunction function) {
        try{
            List<UsuarioDTO> usuarios = service.buscarTodosOsUsuariosPorFuncao(function);
           return ResponseEntity.status(HttpStatus.OK).body(usuarios);
        }catch (RuntimeException e){
           return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }
    @GetMapping("/buscarUsuarioPorID/{id}")
    public ResponseEntity buscarUsuarioPorID(@PathVariable UUID id) {
        try{
            UsuarioDTO usuario = service.buscarUsuarioPorID(id);
            return ResponseEntity.status(HttpStatus.OK).body(usuario);
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }
    @GetMapping("/buscarUsuarioPorNome/{nome}")
    public ResponseEntity buscarUsuarioPorNome(@PathVariable String nome) {

        try{
            UsuarioDTO usuario = service.buscarUsuarioPorNome(nome);
            return ResponseEntity.status(HttpStatus.OK).body(usuario);
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }
    @GetMapping("/buscarUsuarioPorCPFe/{cpf}")
    public ResponseEntity buscarUsuarioPorCPF(@PathVariable String cpf) {
        try{
            UsuarioDTO usuario = service.buscarUsuarioPorCPF(cpf);
            return ResponseEntity.status(HttpStatus.OK).body(usuario);
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }
    @GetMapping("/buscarUsuarioPorEmail/{email}")
    public ResponseEntity buscarUsuarioPorEmail(@PathVariable String email) {
        try{
            UsuarioDTO usuario = service.buscarUsuarioPorEmail(email);
            return ResponseEntity.status(HttpStatus.OK).body(usuario);
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }
}
