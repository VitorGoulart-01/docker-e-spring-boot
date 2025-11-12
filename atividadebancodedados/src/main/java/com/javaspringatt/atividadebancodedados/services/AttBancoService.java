package com.javaspringatt.atividadebancodedados.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaspringatt.atividadebancodedados.models.AttBancoModel;
import com.javaspringatt.atividadebancodedados.repository.AttBancoRepository;

@Service
public class AttBancoService {

    @Autowired
    private AttBancoRepository attBancoRepository;

    public  List<AttBancoModel> listarTodos(){
        return attBancoRepository.findAll();

    }

    public  AttBancoModel buscarPorId(int id){

        Optional<AttBancoModel> produto = attBancoRepository.findById(id);
        return produto.orElse(null);
    }

    public AttBancoModel adicionarProduto(AttBancoModel produto){
        return attBancoRepository.save(produto);
    }               

    public AttBancoModel atualizarProduto(int id, AttBancoModel produtoAtualizado){
        Optional<AttBancoModel> produtoExiste = attBancoRepository.findById(id);
        if(produtoExiste.isPresent()){
            AttBancoModel produto = produtoExiste.get();
            produto.setNome(produtoAtualizado.getNome());
            produto.setPreco(produtoAtualizado.getPreco());
            return attBancoRepository.save(produto);
        }
        return null;
    }

    public void deletarProduto(int id){
        attBancoRepository.deleteById(id);

    }

    public double calcularValorTotal(){
        List<AttBancoModel> produto = attBancoRepository.findAll();
        double total = 0;
        for(AttBancoModel b : produto){
            total += b.getPreco();

        }
        return total;

    }


}
