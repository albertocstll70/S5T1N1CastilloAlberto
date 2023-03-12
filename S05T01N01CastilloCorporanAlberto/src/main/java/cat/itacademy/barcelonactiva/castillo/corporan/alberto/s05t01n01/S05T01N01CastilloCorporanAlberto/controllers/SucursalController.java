package cat.itacademy.barcelonactiva.castillo.corporan.alberto.s05t01n01.S05T01N01CastilloCorporanAlberto.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cat.itacademy.barcelonactiva.castillo.corporan.alberto.s05t01n01.S05T01N01CastilloCorporanAlberto.domain.Sucursal;
import cat.itacademy.barcelonactiva.castillo.corporan.alberto.s05t01n01.S05T01N01CastilloCorporanAlberto.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.castillo.corporan.alberto.s05t01n01.S05T01N01CastilloCorporanAlberto.exception.EntityNoEncontradaException;
import cat.itacademy.barcelonactiva.castillo.corporan.alberto.s05t01n01.S05T01N01CastilloCorporanAlberto.services.SucursalService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class SucursalController {

	@Autowired
	private SucursalService service;

	@GetMapping("/")
	public String welcome() {
		return "index";
	}

	@GetMapping(value = "/sucursal/add")
	public String addSucursal(Model model) {
		try {
			model.addAttribute("sucursal", new Sucursal());

		} catch (DataAccessException e) {

		}
		return "introducirDatos";

	}

	@PostMapping(value = "/sucursal/guardar")
	public String guardarSucursal(@ModelAttribute @Valid Sucursal sucursal, BindingResult result) {
		if (result.hasErrors()) {
			return "introducirDatos";

		}

		service.add(sucursal);
		return "guardado";

	}

	@GetMapping(value = "/sucursal/getAll")
	public String getAll(Model model) {
		ArrayList<SucursalDTO> sDTO = (ArrayList<SucursalDTO>) service.getAll();
		model.addAttribute("sucursales", sDTO);
		return "vistaGetAll";

	}

	@GetMapping(value = "/sucursal/getOne")
	public String getOneFormulario(@RequestParam("id") Optional<Integer> id, Model model) {
		int idBuscado = id.orElse(0);
		model.addAttribute("id", idBuscado);
		return "buscar";
	}

	@GetMapping(value = "/sucursal/getOne/{id}")
	public String getOne(@RequestParam("id") Integer id, Model model) throws  EntityNoEncontradaException{

		SucursalDTO sucursalDTO = new SucursalDTO();
		Sucursal sucursal = new Sucursal();
		sucursal = service.getOne(id);		
		
			
			try{
				if(sucursal==null) {
					throw new EntityNoEncontradaException("No se encontró ninguna entidad con el ID " + id);	
					
				}
				sucursalDTO = service.pasarASDto(sucursal);
				model.addAttribute("sucursalDTO", sucursalDTO);
				return "vistaOneSucursal";	
			
			}catch(EntityNoEncontradaException e) {
				
				
				model.addAttribute("mensaje", e.getMessage());
				 return "sucursalNoEncontrada";
			
				
		}
			
			
			
			 
			
		
		
		

	}

	@GetMapping(value = "sucursal/update/{pk_SucursalID}")
	public String update(@ModelAttribute SucursalDTO sucursalDTO, Model model) {

		Sucursal sucursal = service.getOne(sucursalDTO.getPk_SucursalID());

		model.addAttribute("sucursal", sucursal);
		return "introducirDatos";
	}

	@GetMapping("/sucursal/delete/{pk_SucursalID}")
	public String delete(@ModelAttribute SucursalDTO sucursalDTO) {
		service.delete(sucursalDTO.getPk_SucursalID());
		return "redirect:/sucursal/getAll";
	}

}
