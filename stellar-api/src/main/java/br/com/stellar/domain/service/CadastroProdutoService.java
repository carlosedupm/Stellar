package br.com.stellar.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.stellar.domain.exception.EntidadeEmUsoException;
import br.com.stellar.domain.exception.ProdutoNaoEncontradoException;
import br.com.stellar.domain.model.entity.Produto;
import br.com.stellar.domain.repository.ProdutoRepository;
@Service
public class CadastroProdutoService {
	
	private static final String MSG_PRODUTO_EM_USO = "Produto de código %d não pode ser removido, pois está em uso!";
	@Autowired
    private ProdutoRepository produtoRepository;
    
    @Transactional
    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }
    
    @Transactional
	public void excluir(Long id) {
		try {
			produtoRepository.deleteById(id);
			produtoRepository.flush();
		} catch (EmptyResultDataAccessException e) {
			throw new ProdutoNaoEncontradoException(id);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format(MSG_PRODUTO_EM_USO, id));
		}
	}
    
    public Produto buscarOuFalhar( Long produtoId) {
        return produtoRepository.findById(produtoId)
            .orElseThrow(() -> new ProdutoNaoEncontradoException(produtoId));
    }  
}
