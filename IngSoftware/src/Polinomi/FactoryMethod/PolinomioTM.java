package Polinomi.FactoryMethod;
import Polinomi.Monomio;

import java.util.Map;
import java.util.TreeMap;


/**
 * Fornisce un'implementazione dell'interfaccia {@link Polinomi.Polinomio} basata su una
 * mappa di tipo {@link TreeMap}.
 * 
 * @author Angelo Furfaro
 * 
 */
public class PolinomioTM extends PolinomioMap {

	@Override
	protected PolinomioTM create() {

		return new PolinomioTM();
	}

	@Override
	protected Map<Integer, Monomio> createMap() {

		return new TreeMap<>();
	}

}
