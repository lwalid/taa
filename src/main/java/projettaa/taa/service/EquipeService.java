package projettaa.taa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import projettaa.taa.model.Equipe;
import projettaa.taa.repository.EquipeRepository;

@Service
@Transactional
public class EquipeService {

	@Autowired
	EquipeRepository equipeRepository; 


	public List<Equipe>  findAll( ) {
		return equipeRepository.findAll();
	}

	public Equipe findOne(int id) {
		return equipeRepository.findOne(id);
	}


	public void addEquipe (Equipe Equipe) {
		equipeRepository.save(Equipe);
	}

	public void deleteEquipe ( int id) {
		equipeRepository.delete(id);
	}

	public void deleteAllEquipe () {
		equipeRepository.deleteAllInBatch();
	}

	public  void updateEquipe(Equipe  Equipe){
		equipeRepository.saveAndFlush(Equipe); 
	}
}


