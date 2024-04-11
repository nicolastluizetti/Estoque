package Estoque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Estoque.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
