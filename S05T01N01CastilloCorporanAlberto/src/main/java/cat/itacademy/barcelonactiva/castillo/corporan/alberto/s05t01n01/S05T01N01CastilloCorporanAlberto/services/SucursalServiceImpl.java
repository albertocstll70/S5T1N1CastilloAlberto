package cat.itacademy.barcelonactiva.castillo.corporan.alberto.s05t01n01.S05T01N01CastilloCorporanAlberto.services;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cat.itacademy.barcelonactiva.castillo.corporan.alberto.s05t01n01.S05T01N01CastilloCorporanAlberto.domain.Sucursal;
import cat.itacademy.barcelonactiva.castillo.corporan.alberto.s05t01n01.S05T01N01CastilloCorporanAlberto.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.castillo.corporan.alberto.s05t01n01.S05T01N01CastilloCorporanAlberto.repository.SucursalRepository;

@Service
public class SucursalServiceImpl implements SucursalService {

	@Autowired
	private SucursalRepository repository;

	@Override
	public void add(Sucursal s) {
		repository.save(s);

	}

	@Override
	public List<SucursalDTO> getAll() {
		List<SucursalDTO> sDTO = new ArrayList<SucursalDTO>();
		List<Sucursal> sucursales = (List<Sucursal>) repository.findAll();
		for (Sucursal s : sucursales) {
			sDTO.add(pasarASDto(s));
		}

		return sDTO;
	}

	@Override
	public Sucursal getOne(Integer id) {
		Sucursal s = new Sucursal();
		s = repository.findById(id).orElse(null);
		return s;
	}

	@Override
	public void delete(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public void update(Sucursal s) {
		repository.save(s);

	}

	@Override
	public SucursalDTO pasarASDto(Sucursal s) {
		SucursalDTO sucursalDTO = new SucursalDTO();
		sucursalDTO.setPk_SucursalID(s.getPk_SucursalID());
		sucursalDTO.setNomSucursal(s.getNomSucursal());
		sucursalDTO.setPaisSucursal(s.getPaisSucursal());
		sucursalDTO.setTipusSucursal(sucursalDTO.addTipus());
		return sucursalDTO;

	}

}
