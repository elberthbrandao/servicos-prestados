package com.elberthbrandao.clientes.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elberthbrandao.clientes.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
