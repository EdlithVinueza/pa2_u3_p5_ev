package com.uce.edu.demo.ventas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.ventas.repository.IClienteRepository;
import com.uce.edu.demo.ventas.repository.modelo.Cliente;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;
@Service
public class ClienteSeviceImpl implements IClienteService{
	@Autowired
	private IClienteRepository iClienteRepository;

	@Override
	@Transactional(value = TxType.REQUIRES_NEW) //T2
	//begin
	public void guardar(Cliente cliente) {
		// TODO Auto-generated method stub
		try {
		this.iClienteRepository.insertar(cliente);
		}catch(RuntimeException e) {
			System.out.println(e.getClass());
		}
	}
	//commit --> da un error con el Requires new 
	//Requiate aprobecha la transaccion
	//Requiare_new crea una nueva transaccion 

}
