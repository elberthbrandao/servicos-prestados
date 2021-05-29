package com.elberthbrandao.clientes.rest.dto;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ServicoPrestadoDTO {
	
	@NotEmpty(message = "{campo.descricao.obrigatorio}")
	private String descricao;
	
	@NotEmpty(message = "{campo.data.obrigatorio}")
	private String data;
	
	@NotEmpty(message = "{campo.preco.obrigatorio}")
	private String preco;
	private Integer idCliente;
}
