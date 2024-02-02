package com.uce.edu.deberes.join.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido {
	
	 	@Id
	 	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pedido")
		@SequenceGenerator(name = "seq_pedido", sequenceName = "seq_pedido", allocationSize = 1)
	    @Column(name = "pedi_id")
	    private Long id;
	    
	    @Column(name = "pedi_descripcion")
	    private String descripcion;
	    
	    @Column(name = "pedi_costo")
	    private BigDecimal costo;
	    
	    @Column(name = "pedi_fecha")
	    private LocalDateTime fecha;
	    
	    @ManyToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "pedi_id_cliente")
	    private Cliente cliente;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		public BigDecimal getCosto() {
			return costo;
		}

		public void setCosto(BigDecimal costo) {
			this.costo = costo;
		}

		public LocalDateTime getFecha() {
			return fecha;
		}

		public void setFecha(LocalDateTime fecha) {
			this.fecha = fecha;
		}

		public Cliente getCliente() {
			return cliente;
		}

		public void setCliente(Cliente cliente) {
			this.cliente = cliente;
		}
	    
	    
	
}
