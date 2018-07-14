package com.fabricah.projetoCadastro.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabricah.projetoCadastro.domain.Categoria;
import com.fabricah.projetoCadastro.repositories.CategoriaRepository;
import com.fabricah.projetoCadastro.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepo;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> objCat = categoriaRepo.findById(id);
		
		return objCat.orElseThrow( () -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()) );
	}
}
