package projettaa.taa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import projettaa.taa.model.Tache;
import projettaa.taa.repository.TacheRepository;

@Service
@Transactional
public class TacheService {

	@Autowired
	TacheRepository tacheRepository; 


	public List<Tache>  findAll( ) {
		return tacheRepository.findAll();
	}

	public Tache findOne(int id) {
		return tacheRepository.findOne(id);
	}

	public void addTache(Tache Tache) {
		tacheRepository.save(Tache);
	}

	public List<Tache> findTache(int idSprint) {
		return tacheRepository.findTaches(idSprint);
	}

	public void deleteTache( int id) {
		tacheRepository.delete(id);
	}

	public void deleteAllTaches() {
		tacheRepository.deleteAllInBatch();
	}

	public  void updateTache(Tache tache){
		tacheRepository.saveAndFlush(tache); 
	}
}


