package com.lojaGreice.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.lojaGreice.spring.model.Login;
import com.lojaGreice.spring.model.Usuario;


public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    List<Usuario> findByNome(String nome);

    Usuario findByLogin(Login login);

}
