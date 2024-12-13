package me.dio.academia.digital.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvaliacaoFisicaUpdateForm {

  @NotNull(message = "Informe um peso.")
  @Positive(message = "O peso do aluno precisa ser positivo.")
  private double peso;

  @NotNull(message = "A altura tem que ser informada.")
  @Positive(message = "A altura deve ser positiva.")
  private double altura;
}
