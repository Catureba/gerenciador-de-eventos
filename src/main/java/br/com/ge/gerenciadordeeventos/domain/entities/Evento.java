package br.com.ge.gerenciadordeeventos.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "eventos")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String nome;
    private String descricao;
    private LocalDate data;
    @Column(name = "numero_maximo_de_colaboradores")
    private int numeroMaximoDeColaboradores;
    @Column(name = "horario_de_chegada")
    private LocalTime horarioDeChegada;

}
