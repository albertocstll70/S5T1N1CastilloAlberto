package cat.itacademy.barcelonactiva.castillo.corporan.alberto.s05t01n01.S05T01N01CastilloCorporanAlberto.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name="sucursal")
public class Sucursal {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pk_SucursalID;
	
	@Column(name = "Nombre", nullable=false, length = 45)
	@NotEmpty
	private String nomSucursal;
	
	@Column(name = "Pais",nullable=false, length = 45)
	@NotEmpty
	private String paisSucursal;
	
	
	
	public Sucursal() {
		
	}



	public Sucursal(String nomSucursal, String paisSucursal) {
		
		this.nomSucursal = nomSucursal;
		this.paisSucursal = paisSucursal;
	}



	public Integer getPk_SucursalID() {
		return pk_SucursalID;
	}



	public void setPk_SucursalID(Integer pk_SucursalID) {
		this.pk_SucursalID = pk_SucursalID;
	}



	public String getNomSucursal() {
		return nomSucursal;
	}



	public void setNomSucursal(String nomSucursal) {
		this.nomSucursal = nomSucursal;
	}



	public String getPaisSucursal() {
		return paisSucursal;
	}



	public void setPaisSucursal(String paisSucursal) {
		this.paisSucursal = paisSucursal;
	}



	@Override
	public String toString() {
		return "Sucursal [pk_SucursalID=" + pk_SucursalID + ", nomSucursal=" + nomSucursal + ", paisSucursal="
				+ paisSucursal + "]";
	}
	

	
	
}
