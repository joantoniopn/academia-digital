package me.dio.academia.digital.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Matricula")
public class Matricula {

  @Id
  @Column(name = "Id_Matricula")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "Aluno_Id")
  private Aluno aluno;

  @Column(name = "Data_Matricula")
  private LocalDateTime dataMatricula = LocalDateTime.now();
}
