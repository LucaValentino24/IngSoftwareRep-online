package Polinomi.Bridge;

import Polinomi.Monomio;

interface PolinomioImpl extends Iterable<Monomio> {
	void addMonomio(Monomio m);
	default int size(){
		int k = 0;
		for (@SuppressWarnings("unused") Monomio m : this) {
			++k;
		}
		return k;
	}

}
