/**
 * 
 */
package fr.diginamic.pizzeria.services;

import java.util.List;
import java.util.Scanner;

import fr.diginamic.pizzeria.dao.IPizzaDao;
import fr.diginamic.pizzeria.exception.DeletePizzaException;
import fr.diginamic.pizzeria.model.Pizza;

/**
 * Classe pour la suppression de pizzas de la liste.
 * 
 * @author Jean-Baptiste
 *
 */
public class SupprimerPizzaService extends MenuService {

	@Override
	public void executeUC(Scanner scanner, IPizzaDao dao) throws DeletePizzaException {
		System.out.println("*** Suppression d'une pizza ***");
		// affichage des pizzas
		List<Pizza> listeDesPizzas = dao.findAllPizzas();
		for (int i = 0; i < listeDesPizzas.size(); i++) {
			System.out.println(listeDesPizzas.get(i).toString());
		}
		//
		System.out.println("Veuillez choisir le code de la pizza à supprimer.");
		String choixCode = scanner.nextLine().toUpperCase();
		if (!dao.pizzaExists(choixCode)) {
			throw new DeletePizzaException("Ce code n'existe pas.");
		}
		dao.deletePizza(choixCode);
	}

}
