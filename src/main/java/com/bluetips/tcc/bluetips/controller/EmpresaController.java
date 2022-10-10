package com.bluetips.tcc.bluetips.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluetips.tcc.bluetips.domain.CriaEmpresaRequest;
import com.bluetips.tcc.bluetips.domain.CriaEmpresaResponse;
import com.bluetips.tcc.bluetips.entity.EmpresaEntity;
import com.bluetips.tcc.bluetips.service.EmpresaService;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

	@Autowired
	private EmpresaService empresaService;
	
	@PostMapping
	public CriaEmpresaResponse criaEmpesa(@RequestBody CriaEmpresaRequest request) {
		
		CriaEmpresaResponse response = empresaService.criaEmpesa(request);
		
		return response;
	}

	@GetMapping
	public List<EmpresaEntity> listaTodasEmpresas() {
		
		List<EmpresaEntity> response = empresaService.listaTodasEmpresas();
		return response;
	}
	
	@GetMapping("/{id}")
	public EmpresaEntity buscaEmpesaPorId(@PathVariable String id) {
		
		EmpresaEntity response = empresaService.buscaEmpesaPorId(id);
		return response;
	}

	@PutMapping("/{id}")
	public EmpresaEntity atualizaEmpresa(@PathVariable String id, @RequestBody CriaEmpresaRequest request) {
		
		EmpresaEntity response = empresaService.atualizaEmpresa(id, request);
		return response;
	}

	@DeleteMapping("/{id}")
	public String removeEmpresa(@PathVariable String id) {
		
		String response = empresaService.removeEmpresa(id);
		return response;
	}

}