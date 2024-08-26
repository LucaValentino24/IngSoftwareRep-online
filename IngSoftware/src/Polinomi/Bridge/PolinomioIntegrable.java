package Polinomi.Bridge;

import Polinomi.Monomio;

public class PolinomioIntegrable extends PolinomioConcreto {

	public PolinomioIntegrable integrate(){
		PolinomioIntegrable ris= new PolinomioIntegrable();
		for(Monomio m:this){
			double c= m.getCoeff();
			int g=m.getGrado();
			
			Monomio mint= new Monomio(c/(g+1),g+1);
			ris.add(mint);
		}
		return ris;
	}
	
	
}
