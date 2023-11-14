package br.com.ge.gerenciadordeeventos.services;

import br.com.ge.gerenciadordeeventos.domain.entities.Evento;
import br.com.ge.gerenciadordeeventos.repositories.IEventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class EventoService{
    @Autowired
    IEventoRepository repository;

    public Evento cadastrar(Evento evento){
        //if(repository.findById(evento.getId()) != null) throw new RuntimeException("Este usuario já existe");

        return repository.save(evento);
    }
    public Evento atualizar(Evento eventoParaAtualizar){
        Evento eventoOriginal = repository.findById(eventoParaAtualizar.getId()).orElse(null);
        if(eventoOriginal == null) throw new RuntimeException("Este usuario não existe");
        eventoOriginal.setNome(eventoParaAtualizar.getNome());
        eventoOriginal.setData(eventoParaAtualizar.getData());
        eventoOriginal.setDescricao(eventoParaAtualizar.getDescricao());
        eventoOriginal.setHorarioDeChegada(eventoParaAtualizar.getHorarioDeChegada());
        eventoOriginal.setNumeroMaximoDeColaboradores(eventoParaAtualizar.getNumeroMaximoDeColaboradores());

        return repository.save(eventoOriginal);
    }
    public void deletarPorID(UUID id){
        Evento evento = repository.findById(id).orElse(null);
        if (evento == null) throw new RuntimeException("Usuario não encontrado");
        repository.delete(evento);
    }
    public List<Evento> buscarTodosOsEventos(){
        List<Evento> eventos = repository.findAll();
        if(eventos.isEmpty()) throw new RuntimeException("Nenhum evento foi encontrado");
        return eventos;
    }
    public Evento buscarPorID(UUID id){
        Evento evento = repository.findById(id).orElse(null);
        if (evento == null) throw new RuntimeException("Usuario não encontrado");
        return evento;
    }
    public List<Evento> buscarPorNome(String nome){
        List<Evento> eventos = repository.findByNome(nome);
        if(eventos.isEmpty()) throw new RuntimeException("Nenhum evento com o nome: " + nome + " foi encontrado");
        return eventos;
    }
    public List<Evento> buscarPorData(LocalDate data){
        List<Evento> eventos = repository.findByData(data);
        if(eventos.isEmpty()) throw new RuntimeException("Nenhum evento para a data: " + data + " foi encontrado");
        return eventos;
    }
}
