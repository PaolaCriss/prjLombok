package com.paolacris.lombok.projetoLombok.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paolacris.lombok.projetoLombok.entities.Usuario;
import com.paolacris.lombok.projetoLombok.repositories.UsuarioRepositorio;

@Service
public class UsuarioService {

	private final UsuarioRepositorio userRepositorio;

	@Autowired
	public UsuarioService (UsuarioRepositorio userRepositorio) {
		this.userRepositorio = userRepositorio;
	}

	// preparando as buscas por id
	public Usuario findUsuarioById(Long id) {
		Optional<Usuario> Usuario = userRepositorio.findById(id);
		return Usuario.orElse(null);
	}

	// preparando a busca geral
	public List<Usuario> findAllUsuario() {
		return userRepositorio.findAll();
	}

	// salvando o Jogo
	public Usuario insertUsuario(Usuario usuario) {
		return userRepositorio.save(usuario);
	}

	// fazendo o update do jogo com o optional
	public Usuario updateUsuario(Long id, Usuario novoUsuario) {
		Optional<Usuario> usuarioOptional = userRepositorio.findById(id);
		if (usuarioOptional.isPresent()) {
			Usuario usuarioExistente = usuarioOptional.get();
			usuarioExistente.setNome(novoUsuario.getNome());
			usuarioExistente.setEmail(novoUsuario.getEmail());
			return userRepositorio.save(usuarioExistente);
		} else {
			return null;
		}
	}

	// deletando o update do usuario com o optional
	public boolean deleteUsuario(Long id) {
		Optional<Usuario> usuarioExistente = userRepositorio.findById(id);
		if (usuarioExistente.isPresent()) {
			userRepositorio.deleteById(id);
			return true;
		} else {
			return false;
		}
	}


}
