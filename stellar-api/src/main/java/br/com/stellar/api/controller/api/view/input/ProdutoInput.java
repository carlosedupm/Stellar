package br.com.stellar.api.controller.api.view.input;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoInput {

	
	private String nome;
	private String descricao;
	private BigDecimal preco;
	private Integer ativo;
}
