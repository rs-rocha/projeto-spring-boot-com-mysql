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

    //@PutMapping


    //@DeleteMapping

}
