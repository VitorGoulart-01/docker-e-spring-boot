package com.javaspringatt.atividadebancodedados.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import com.javaspringatt.atividadebancodedados.models.AttBancoModel;
import com.javaspringatt.atividadebancodedados.services.AttBancoService;

import java.util.List;


@RestController
@RequestMapping("/api/produtos")
public class AttBancoController {

    @Autowired
    private AttBancoService attBancoService;

 
    
    @GetMapping
    public ResponseEntity<List<AttBancoModel>> listarTodos(){
        List<AttBancoModel> produtos = attBancoService.listarTodos();
        return ResponseEntity.ok(produtos);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<AttBancoModel> buscarPorid(@PathVariable int id){
        AttBancoModel produto = attBancoService.buscarPorId(id);
        if(produto != null){
            return ResponseEntity.ok(produto);
        }
        return ResponseEntity.notFound().build();

    }
    @PostMapping
    public ResponseEntity<AttBancoModel> adicionarProduto(@RequestBody AttBancoModel produto){
        AttBancoModel produtoSalvo = attBancoService.adicionarProduto(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoSalvo);


    }
    
    
    @PutMapping("/{id}")
    public ResponseEntity<AttBancoModel> atualizarProduto(@PathVariable int id, @RequestBody AttBancoModel produto){

        AttBancoModel produtoAtualizar = attBancoService.atualizarProduto(id, produto);
        if(produtoAtualizar != null){
            return ResponseEntity.ok(produtoAtualizar);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorduto(@PathVariable int id){
        AttBancoModel produto = attBancoService.buscarPorId(id);
        if(produto != null){
            attBancoService.deletarProduto(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/total")
    public ResponseEntity<Double> calcularTotal(){
        double total = attBancoService.calcularValorTotal();
        return ResponseEntity.ok(total);
    }





}
