package com.elberthbrandao.clientes.rest.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ServicoPrestadoDTO {
	
	private String descricao;
	private String data;
	private String preco;
	private Integer idCliente;
}
