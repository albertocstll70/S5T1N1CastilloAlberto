package cat.itacademy.barcelonactiva.castillo.corporan.alberto.s05t01n01.S05T01N01CastilloCorporanAlberto.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SucursalDTO {

	private int pk_SucursalID;
	private String nomSucursal;
	private String paisSucursal;
	private String tipusSucursal;
	private List<String> listPais = new ArrayList<String>(Arrays.asList("Alemania", "Asutria", "Bélgica", "Chipre",
			"Croacia", "Dinamarca", "España", "Eslovaquia", "Eslovenia", "Estonia", "Firlandia", "Francia", "Grecia",
			"Hungría", "Irlanda", "Italia", "Letonia", "Lituania", "Luxemburgo", "Malta", "Países Bajos", "Polonia",
			"Portugal", "República Checa", "Rumania", "Suecia"));

	@Override
	public String toString() {
		return " " + pk_SucursalID + " " + nomSucursal + " " + paisSucursal + " " + tipusSucursal + " ";
	}

	public SucursalDTO() {

	}

	public SucursalDTO(String nomSucursal, String paisSucursal) {

		this.nomSucursal = nomSucursal;
		this.paisSucursal = paisSucursal;

	}

	public String addTipus() {
		boolean encontrado = false;
		String resultado = null;

		for (String i : this.listPais) {

			if (i.equalsIgnoreCase(this.paisSucursal)) {
				encontrado = true;

			}

		}

		if (encontrado) {

			resultado = "UE";
		} else {
			resultado = "Fora EU";
		}

		return resultado;
	}

	public int getPk_SucursalID() {
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

	public String getTipusSucursal() {
		return tipusSucursal;
	}

	public void setTipusSucursal(String tipusSucursal) {
		this.tipusSucursal = tipusSucursal;
	}

	public List<String> getPais() {
		return listPais;
	}

	public void setPais(List<String> pais) {
		this.listPais = pais;
	}

}
