package com.javaspringatt.atividadebancodedados.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import java.util.List;



@RestController
@RequestMapping("/api/")
public class AttBancoController {

    @GetMapping
    public ResponseEntity<AttBancoModel> listarTidis(){
        List<AttBancoModel> produtos = attService.listarTodos();
        return ResponseEntity.ok(produtos);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<AttBancoModel> buscarPorid(@PathVariable int id){

    }
    @PutMapping("/{id}")
    public ResponseEntity<> atualizarProduto(@PathVariable int id, @RequestBody produto){

    }

    public 


}
