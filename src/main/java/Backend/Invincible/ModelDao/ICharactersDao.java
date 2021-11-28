package Backend.Invincible.ModelDao;

import org.springframework.data.jpa.repository.JpaRepository;

import Backend.Invincible.ModelEntity.Characters;

public interface ICharactersDao extends JpaRepository<Characters, Long> {

}
