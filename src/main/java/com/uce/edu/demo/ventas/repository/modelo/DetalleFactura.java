package com.uce.edu.demo.ventas.repository.modelo;

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
@Table(name = "detalle_factura")
public class DetalleFactura {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_detalle_factura")
	@SequenceGenerator(name = "seq_detalle_factura", sequenceName = "seq_detalle_factura", allocationSize = 1)
	@Column(name="defa_id")
	private Integer id;
	
	@Column(name="defa_cantidad")
	private Integer cantidad;
	
	@Column(name="defa_codigo_barras")
	private String codigoBarras;
	
	@Column(name="defa_nombre")
	private String nombreProdcuto;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="defa_id_factura")
	private Factura factura;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public String getCodigoBarras() {
		return codigoBarras;
	}
	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
	public String getNombreProdcuto() {
		return nombreProdcuto;
	}
	public void setNombreProdcuto(String nombreProdcuto) {
		this.nombreProdcuto = nombreProdcuto;
	}
	public Factura getFactura() {
		return factura;
	}
	public void setFactura(Factura factura) {
		this.factura = factura;
	}
	@Override
	public String toString() {
		return "DetalleFactura [id=" + id + ", cantidad=" + cantidad + ", codigoBarras=" + codigoBarras
				+ ", nombreProdcuto=" + nombreProdcuto + "]";
	}
	
	
	
}
