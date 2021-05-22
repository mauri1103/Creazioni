package it.epicode.be.tiers.data_persistence_tier;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import it.epicode.be.model.Games;
import lombok.Getter;


@Component
public class GamesRepo {

	@Getter
	private List<Games> games;

	public GamesRepo() {
		games = new ArrayList<>();
		games.add(new Games(1, "Sparatutto", "Call of Duty: Battaglia di Sassi", "Bugtivision", 18));
		games.add(new Games(2, "Corse", "Asetto Corsa", "known", 10));
		games.add(new Games(3, "GDR", "Fallout 6", "Bethesda", 18));
		games.add(new Games(4, "Carte", "Solitario", "Microsoft", 0));
		games.add(new Games(5, "Horror", "Resident of Evil", "Capcon", 18));
	}

	 public void addGame(Games game ) {
		 games.add(game);
	    }

	public void removeGame(Games game) {
		games.remove(game);
	}
}
