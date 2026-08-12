package com.example.projetospringbootcommysql.controller;

import com.example.projetospringbootcommysql.entity.AlunoEntity;
import com.example.projetospringbootcommysql.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
@CrossOrigin(origins = "*")
public class AlunoController {

    @Autowired
    private AlunoRepository repository;

    @PostMapping
    public AlunoEntity salvaAlunoEntity(@RequestBody AlunoEntity aluno){
        return repository.save(aluno);
    }
    @GetMapping
    public List<AlunoEntity> listarAlunos(){
        return repository.findAll();
    }

    @PutMapping("/{id}")
    public AlunoEntity atualizarAlunoEntity(
            @PathVariable Integer id,
            @RequestBody AlunoEntity alunoAtualizado
    ){
        AlunoEntity alunoAtual = repository.findById(id).orElseThrow();
        alunoAtual.setNome(alunoAtualizado.getNome());
        alunoAtual.setIdade(alunoAtualizado.getIdade());
        alunoAtual.setRegistroAluno(alunoAtualizado.getRegistroAluno());
        alunoAtual.setEmailInstitucional(alunoAtualizado.getEmailInstitucional());
        alunoAtual.setTurma(alunoAtualizado.getTurma());
        alunoAtual.setPeriodo(alunoAtualizado.getPeriodo());
        alunoAtual.setApresentacao(alunoAtualizado.getApresentacao());

        return repository.save(alunoAtual);
    }

    @DeleteMapping("/{id}")
    public String apagarAlunoEntity(
            @PathVariable Integer id
    ){
        AlunoEntity aluno = repository.findById(id).orElseThrow();
        String nome = aluno.getNome();
        repository.deleteById(id);
        return "Aluno " + nome + "deletado com sucesso!";
    }
}
