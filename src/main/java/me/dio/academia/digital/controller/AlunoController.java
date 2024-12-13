package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;
import me.dio.academia.digital.service.impl.AlunoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    @Autowired
    private AlunoServiceImpl service;

    @GetMapping
    public List<Aluno> getAll(@RequestParam(value = "dataDeNascimento", required = false) String dataDeNascimento) {
        return service.getAll(dataDeNascimento);
    }

    @PostMapping
    public Aluno create(@RequestBody @Valid AlunoForm form) {
        return service.create(form);
    }

    @GetMapping("/avaliacoes/{id}")
    public List<AvaliacaoFisica> getAllAvaliacaoFisicaDoAluno(@PathVariable Long id) {
        return service.getAllAvaliacaoFisicaPorIdAluno(id);
    }

    @PutMapping("/{id}")
    public Aluno update(@PathVariable Long id, @RequestBody @Valid AlunoUpdateForm form) {
        return service.update(id, form);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Long id) {
        service.delete(id);
        Map<String, String> retorno = new HashMap<>();
        retorno.put("message", "Aluno excluído com sucesso!");
        return ResponseEntity.ok(retorno);
    }

    @GetMapping("/{id}")
    public Aluno getById(@PathVariable Long id) {
        return service.getById(id);
    }
}
