package br.com.ge.gerenciadordeeventos.repositories;

import br.com.ge.gerenciadordeeventos.domain.entities.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface IEventoRepository extends JpaRepository<Evento, UUID> {
    List<Evento> findByNome(String nome);
    List<Evento> findByData(LocalDate data);
}
