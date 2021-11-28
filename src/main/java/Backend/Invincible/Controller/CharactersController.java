package Backend.Invincible.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import Backend.Invincible.ModelEntity.Characters;
import Backend.Invincible.Service.CharactersService;


@CrossOrigin(origins = "*", allowedHeaders = "*") // se pone la direccion del donde estara
@RestController
@RequestMapping("/api")
public class CharactersController {
	
	@Autowired
	private CharactersService charactersService;
	
	@GetMapping("/characters")
	public List<Characters> listar(){
		return charactersService.listar();
	}
	
	@GetMapping("/characters/{id}")
	public Characters buscar(@PathVariable Long id) {
		return charactersService.findById(id);
	}
	
	@PostMapping("/characters")
	public Characters guardar(@RequestBody Characters character) {
		return charactersService.guardar(character);
	}
		
	@DeleteMapping("/characters/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void borrar(@PathVariable Long id) {
		charactersService.borrar(id);
	}
	
	@PutMapping("/characters/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Characters update(@RequestBody Characters character, @PathVariable Long id) {
		Characters actual = charactersService.findById(id);
		actual.setName(character.getName());
		actual.setAge(character.getAge());
		actual.setLinkPhoto(character.getLinkPhoto());
		actual.setGender(character.getGender());
		actual.setPowers(character.getPowers());
		actual.setOccupation(character.getOccupation());
		actual.setRelations(character.getRelations());
		actual.setPlaceOfBirth(character.getPlaceOfBirth());
		actual.setItinerary(character.getItinerary());
		actual.setDescription(character.getDescription());
		actual.setAlias(character.getAlias());
		return charactersService.guardar(actual);
	}
	
	
}
