package it.epicode.be.tiers.logic_business_tier;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import it.epicode.be.model.Games;
import it.epicode.be.tiers.data_persistence_tier.GamesRepo;


@Component
public class GamesService {

	@Autowired
	private GamesRepo repo;

	public void aggiungiVideogioco(Games game) {
		repo.addGame(game);
	}

	public void rimuoviVideogioco(Games game) {
		repo.removeGame(game);
	}

	public List<Games> getListaVideogiochi() {
		return repo.getGames();
	}
}
