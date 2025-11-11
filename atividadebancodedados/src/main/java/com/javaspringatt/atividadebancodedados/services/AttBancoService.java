package com.javaspringatt.atividadebancodedados.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaspringatt.atividadebancodedados.models.AttBancoModel;
import com.javaspringatt.atividadebancodedados.repository.AttBancoRepository;

@Service
public class AttBancoService {

    @Autowired
    private AttBancoRepository attBancoRepository;

    public List<AttBancoModel> listarTodos(){
        return attBancoRepository.findAll();
    }

    public AttBancoModel BuscarPorId(int id){
        Optional<AttBancoModel> produto = attBancoRepository.findById(id);
        return produto.orElse(null);
    }

    public AttBancoModel adicionarProduto(AttBancoModel produto){
        return attBancoRepository.save(produto);
    }


}
