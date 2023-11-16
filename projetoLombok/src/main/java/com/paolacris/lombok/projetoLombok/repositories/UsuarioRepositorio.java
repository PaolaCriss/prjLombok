package com.paolacris.lombok.projetoLombok.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paolacris.lombok.projetoLombok.entities.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{

	}

