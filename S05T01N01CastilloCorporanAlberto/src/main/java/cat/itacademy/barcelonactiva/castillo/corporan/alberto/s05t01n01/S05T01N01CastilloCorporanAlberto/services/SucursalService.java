package cat.itacademy.barcelonactiva.castillo.corporan.alberto.s05t01n01.S05T01N01CastilloCorporanAlberto.services;

import java.util.List;

import cat.itacademy.barcelonactiva.castillo.corporan.alberto.s05t01n01.S05T01N01CastilloCorporanAlberto.domain.Sucursal;
import cat.itacademy.barcelonactiva.castillo.corporan.alberto.s05t01n01.S05T01N01CastilloCorporanAlberto.dto.SucursalDTO;

public interface SucursalService {
	void add( Sucursal sucursal);
	List<SucursalDTO>getAll();
	Sucursal getOne(Integer id);
	void delete(Integer id);
	void update(Sucursal s);
	SucursalDTO pasarASDto(Sucursal s);

}
