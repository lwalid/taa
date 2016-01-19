package projettaa.taa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import projettaa.taa.model.Equipe;


public interface EquipeRepository extends JpaRepository<Equipe,Integer>{

	@Query( "DELET t FROM Tache t WHERE t.id=:t_id")
	void delete(int id);



}
