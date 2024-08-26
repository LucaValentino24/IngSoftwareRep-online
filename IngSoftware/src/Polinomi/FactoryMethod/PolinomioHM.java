package Polinomi.FactoryMethod;

import java.util.HashMap;

import Polinomi.Monomio;
import Polinomi.Polinomio;


/**
 * Fornisce un'implementazione dell'interfaccia {@link Polinomio} basata su una
 * mappa di tipo {@link HashMap}.
 * 
 * @author Angelo Furfaro
 */
public class PolinomioHM extends PolinomioMap {

	@Override
	protected HashMap<Integer, Monomio> createMap() {

		return new HashMap<>();
	}

	@Override
	protected PolinomioHM create() {

		return new PolinomioHM();
	}
}
