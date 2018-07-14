package com.fabricah.projetoCadastro;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fabricah.projetoCadastro.domain.Categoria;
import com.fabricah.projetoCadastro.domain.Produto;
import com.fabricah.projetoCadastro.repositories.CategoriaRepository;
import com.fabricah.projetoCadastro.repositories.ProdutoRepository;

@SpringBootApplication
public class ProjetoCadastroApplication implements CommandLineRunner {

	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetoCadastroApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto prod1 = new Produto(null, "Computador", 2000.00);
		Produto prod2 = new Produto(null, "Impressora", 800.00);
		Produto prod3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getListaProdutos().addAll(Arrays.asList(prod1, prod2, prod3));
		cat2.getListaProdutos().add(prod2);
		
		prod1.getListaCategorias().add(cat1);
		prod2.getListaCategorias().addAll(Arrays.asList(cat1, cat2));
		prod3.getListaCategorias().add(cat1);
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(prod1, prod2, prod3));
	}
}
