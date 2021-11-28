package Backend.Invincible.Service;

import java.util.List;

import Backend.Invincible.ModelEntity.Characters;

public interface ICharactersService {
	public List<Characters> listar();
	public Characters guardar(Characters character);
	public void borrar(Long id);
	public Characters findById(Long id);
	
}
