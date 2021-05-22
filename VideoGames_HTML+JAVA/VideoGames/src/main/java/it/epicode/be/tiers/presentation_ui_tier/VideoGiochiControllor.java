package it.epicode.be.tiers.presentation_ui_tier;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import it.epicode.be.model.Games;
import it.epicode.be.tiers.logic_business_tier.GamesService;

@Controller
public class VideoGiochiControllor {

	@Autowired
	private GamesService servizioGame;

	@GetMapping("/")
	public String listaVideoGiochi(Map<String, Object> modello) {
		modello.put("videoGioco", servizioGame.getListaVideogiochi());
		System.out.println(servizioGame.getListaVideogiochi().size());
		return "listaVideoGiochi";
	}

	@GetMapping("/aggiungiVideoGiochi")
	public String aggiungiVideoGiochi(Model model) {
		model.addAttribute("giocoSingolo", new Games());
		return "schermataGioco";
	}

	@GetMapping("/modifica")
	public String modificaAuto(@RequestParam int idGame, Map<String, Object> modello) {

		Games daModificare = null;
		for (Games game : servizioGame.getListaVideogiochi()) {
			if (game.getId() == idGame)
				daModificare = game;
		}

		modello.put("giocoSingolo", daModificare);

		return "schermataGioco";
	}

	@GetMapping("/elimina")
	public String eliminaAuto(@RequestParam int idGame, Map<String, Object> modello) {

		Games daEliminare = null;
		for (Games games : servizioGame.getListaVideogiochi()) {
			if (games.getId() == idGame)
				daEliminare = games;
		}

		if (daEliminare != null)
			servizioGame.rimuoviVideogioco(daEliminare);

		modello.put("videoGioco", servizioGame.getListaVideogiochi());

		return "listaVideoGiochi";
	}

	@GetMapping("/salva")
	public String salvaAuto(@ModelAttribute("giocoSingolo") Games idGame, Map<String, Object> modello) {

		Games daModificare = null;

		for (Games games : servizioGame.getListaVideogiochi()) {
			if (games.getId() == idGame.getId())
				daModificare = games;
		}
		if (daModificare != null) {
			servizioGame.rimuoviVideogioco(daModificare);
		}
		servizioGame.aggiungiVideogioco(idGame);

		modello.put("videoGioco", servizioGame.getListaVideogiochi());

		return "listaVideoGiochi";
	}

}
