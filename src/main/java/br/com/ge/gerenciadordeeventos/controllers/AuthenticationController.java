package br.com.ge.gerenciadordeeventos.controllers;

import br.com.ge.gerenciadordeeventos.DTOs.AuthenticationDTO;
import br.com.ge.gerenciadordeeventos.DTOs.RegisterDTO;

import br.com.ge.gerenciadordeeventos.DTOs.UsuarioDTO;
import br.com.ge.gerenciadordeeventos.domain.entities.Usuario;

import br.com.ge.gerenciadordeeventos.domain.enums.LoginResponseDTO;
import br.com.ge.gerenciadordeeventos.repositories.IUsuarioRepository;
import br.com.ge.gerenciadordeeventos.security.TokenService;
import br.com.ge.gerenciadordeeventos.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    UsuarioService service;
    @Autowired
    TokenService tokenService;
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((Usuario) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid UsuarioDTO usuarioDTO){

        try{
            String encryptedPassword = new BCryptPasswordEncoder().encode(usuarioDTO.getPassword());
            usuarioDTO.setPassword(encryptedPassword);
            UsuarioDTO novoUsuarioDTO = service.cadastrar(usuarioDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuarioDTO);
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
