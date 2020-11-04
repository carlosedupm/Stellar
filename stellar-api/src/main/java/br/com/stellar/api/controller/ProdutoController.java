package br.com.stellar.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.stellar.domain.model.entity.Produto;
import br.com.stellar.domain.repository.ProdutoRepository;
import br.com.stellar.domain.service.CadastroProdutoService;

@RestController
@RequestMapping(path="/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private CadastroProdutoService produtoService;
	
	//@Autowired
	//private ProdutoModelAssembler produtoModelAssembler;

	/*
	 * @Autowired private ProdutoInputDisassembler produtoInputDisassembler;
	 */
	
	@GetMapping
	public List<Produto> listar() {
		return produtoRepository.findAll();
	}
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	//public Produto adicionar(@RequestBody @Valid ProdutoInput produtoInput) {
		public Produto adicionar(@RequestBody @Valid Produto produtoInput) {
	        //Cidade cidade = cidadeInputDisassembler.toDomainObject(cidadeInput);
	        
	       return  produtoService.salvar(produtoInput);
	        
	}
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long id) {
		produtoService.excluir(id);
	}
}
