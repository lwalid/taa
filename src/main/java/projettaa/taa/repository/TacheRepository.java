package projettaa.taa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projettaa.taa.model.Tache;

public interface TacheRepository extends JpaRepository<Tache, Integer>{
	
	

	@Query( "SELECT t FROM Tache t WHERE t.employee.id=:t_id")
    public List<Tache> findTaches(@Param("t_id") int id);
	
	@Query( "DELET t FROM Tache t WHERE t.id=:t_id")
	public void delete(int id);

	
}
