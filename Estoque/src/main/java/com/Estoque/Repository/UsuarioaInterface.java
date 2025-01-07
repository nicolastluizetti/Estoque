package com.Estoque.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.Estoque.Model.Usuario;

@Service
public interface UsuarioaInterface extends JpaRepository<Usuario, Long> {

}
