package com.uce.edu.demo.ventas.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.edu.demo.ventas.repository.IFacturaRepository;
import com.uce.edu.demo.ventas.repository.modelo.Cliente;
import com.uce.edu.demo.ventas.repository.modelo.Factura;
import com.uce.edu.demo.ventas.repository.modelo.dto.FacturaDTO;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;


@Service
public class FacturaServiceImpl implements IFacturaService {

	@Autowired
	private IFacturaRepository iFacturaRepository;
	
	@Autowired
	private IClienteService iClienteService;

	@Override
	public Factura buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.seleccionarPorNumero(numero);
	}

	@Override
	@Transactional (value = TxType.REQUIRED)
	public void guardar(Factura factura,Cliente cliente) {
		// TODO Auto-generated method stub
		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
		System.out.println("PAso el insert de factura");
		this.iFacturaRepository.insertar(factura);
		System.out.println("PAso el insert de cliente");
		this.iClienteService.guardar(cliente);

	}

	@Override
	public List<Factura> buscarFacturaInnerJoin() {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.seleccionarFacturaInnerJoin();
	}

	@Override
	public List<Factura> buscarFacturaRightJoin() {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.seleccionarFacturaRightJoin();
	}

	@Override
	public List<Factura> buscarFacturaLeftJoin() {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.seleccionarFacturaLeftJoin();
	}

	@Override
	public List<Factura> buscarFacturaFullJoin() {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.seleccionarFacturaFullJoin();
	}

	@Override
	public List<Factura> buscarFacturaWhereJoin() {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.seleccionarFacturaWhereJoin();
	}

	@Override
	public List<Factura> buscarFacturaFetchJoin() {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.seleccionarFacturaFetchJoin();
	}

	@Override
	public void actualizar(Factura factura) {
		// TODO Auto-generated method stub
		this.iFacturaRepository.actualizar(factura);

	}

	@Override
	public int actualizarFechas(LocalDateTime fechaNueva, LocalDateTime fechaActual) {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.actualizarFechas(fechaNueva, fechaActual);

	}
	
	@Override
	public Factura buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.seleccionar(id);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.iFacturaRepository.eliminar(id);

	}

	@Override
	public int borrarPorNumero(String numero) {
		// TODO Auto-generated method stub
		
		return this.iFacturaRepository.eliminarPorNumero(numero);
	}

	@Override
	public List<FacturaDTO> buscarFacturaDTO() {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.seleccionarFacturaDTO();
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void prueba() {
		// TODO Auto-generated method stub
		System.out.println("Este metod es de prueba");
		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
		
	}



}
