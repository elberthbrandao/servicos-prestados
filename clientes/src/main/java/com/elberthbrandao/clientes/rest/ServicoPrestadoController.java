package com.elberthbrandao.clientes.rest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.elberthbrandao.clientes.model.entity.Cliente;
import com.elberthbrandao.clientes.model.entity.ServicoPrestado;
import com.elberthbrandao.clientes.model.repository.ClienteRepository;
import com.elberthbrandao.clientes.model.repository.ServicoPrestadoRepository;
import com.elberthbrandao.clientes.rest.dto.ServicoPrestadoDTO;
import com.elberthbrandao.clientes.util.BigDecimalConverter;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/servicos-prestados")
@RequiredArgsConstructor
public class ServicoPrestadoController {
	
	private final ClienteRepository clienteRepository;
	private final ServicoPrestadoRepository servicoPrestadoRepository;
	private final BigDecimalConverter bigDecimalConverter;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ServicoPrestado salvar(@RequestBody @Valid ServicoPrestadoDTO dto) {
		LocalDate data = LocalDate.parse(dto.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		Cliente cliente = clienteRepository.findById(dto.getIdCliente())
												.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente inexistente."));
		BigDecimal valor = bigDecimalConverter.converter(dto.getPreco());
		
		ServicoPrestado servicoPrestado = new ServicoPrestado();
		servicoPrestado.setDescricao(dto.getDescricao());
		servicoPrestado.setData(data);
		servicoPrestado.setCliente(cliente);
		servicoPrestado.setValor(valor);
		
		return servicoPrestadoRepository.save(servicoPrestado);
	}

}
