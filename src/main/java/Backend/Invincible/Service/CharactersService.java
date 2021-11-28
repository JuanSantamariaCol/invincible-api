package Backend.Invincible.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Backend.Invincible.ModelDao.ICharactersDao;
import Backend.Invincible.ModelEntity.Characters;

@Service
public class CharactersService implements ICharactersService {

	@Autowired
	private ICharactersDao charactersdao;
	
	@Override
	public List<Characters> listar(){
		// TODO Auto-generated method stub
		return charactersdao.findAll();
	}

	@Override
	public Characters guardar(Characters character) {
		// TODO Auto-generated method stub
		return  charactersdao.save(character);
	}

	@Override
	public void borrar(Long id) {
		// TODO Auto-generated method stub
		charactersdao.deleteById(id);
	}

	@Override
	public Characters findById(Long id) {
		// TODO Auto-generated method stub
		return charactersdao.findById(id).orElse(null);
	}

}
