package me.dio.academia.digital.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Avaliacao_Fisica")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AvaliacaoFisica {
  @Id
  @Column(name = "Id_Avaliacao_Fisica")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "Aluno_Id")
  private Aluno aluno;

  private LocalDateTime dataDaAvaliacao = LocalDateTime.now();

  @Column(name = "Peso_Atual")
  private double peso;

  @Column(name = "Altura_Atual")
  private double altura;

}
