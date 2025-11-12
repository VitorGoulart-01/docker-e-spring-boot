package com.javaspringatt.atividadebancodedados.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaspringatt.atividadebancodedados.models.AttBancoModel;

@Repository
public interface AttBancoRepository extends JpaRepository<AttBancoModel, Integer> {

}
