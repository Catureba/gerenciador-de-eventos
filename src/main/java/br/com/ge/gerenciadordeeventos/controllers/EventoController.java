package br.com.ge.gerenciadordeeventos.controllers;

import br.com.ge.gerenciadordeeventos.domain.entities.Evento;
import br.com.ge.gerenciadordeeventos.services.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/V1/eventos")
public class EventoController {
    @Autowired
    EventoService service;

    @PostMapping
    public ResponseEntity<Evento> cadastrarEvento(@RequestBody Evento evento){
        try {
            Evento eventoCadastrado = service.cadastrar(evento);
            return ResponseEntity.status(HttpStatus.CREATED).body(eventoCadastrado);
        }catch (RuntimeException exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @PutMapping
    public ResponseEntity<Evento> atualizararEvento(@RequestBody Evento evento){
        try {
            Evento eventoCadastrado = service.atualizar(evento);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(eventoCadastrado);
        }catch (RuntimeException exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @GetMapping("/buscarPorID/{id}")
    public ResponseEntity<Evento> buscarEventoPorID(@PathVariable UUID id){
        try {
            Evento eventoCadastrado = service.buscarPorID(id);
            return ResponseEntity.status(HttpStatus.OK).body(eventoCadastrado);
        }catch (RuntimeException exception){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }
    @DeleteMapping("/deletarPorID/{id}")
    public ResponseEntity deletarEventoPorID(@PathVariable UUID id){
        try {
            service.deletarPorID(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch (RuntimeException exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @GetMapping("/buscarPorNome/{nome}")
    public ResponseEntity<List<Evento>> buscarEventoPorNome(@PathVariable String nome){
        try {
            List<Evento> listaDeEventos = service.buscarPorNome(nome);
            return ResponseEntity.status(HttpStatus.OK).body(listaDeEventos);
        }catch (RuntimeException exception){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }
    @GetMapping("/buscarPorData/{data}")
    public ResponseEntity<List<Evento>> buscarEventoPorData(@PathVariable LocalDate data){
        try {
            List<Evento> listaDeEventos = service.buscarPorData(data);
            return ResponseEntity.status(HttpStatus.OK).body(listaDeEventos);
        }catch (RuntimeException exception){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }
    @GetMapping("/buscarTodosOsEventos")
    public ResponseEntity<List<Evento>> buscarTodosOsEvento(){
        try {
            List<Evento> listaDeEventos = service.buscarTodosOsEventos();
            return ResponseEntity.status(HttpStatus.OK).body(listaDeEventos);
        }catch (RuntimeException exception){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }
}
