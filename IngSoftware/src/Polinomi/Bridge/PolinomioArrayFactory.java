package Polinomi.Bridge;

public class PolinomioArrayFactory implements PolinomioImplFactory {

	@Override
	public PolinomioImpl createPolinomioImpl() {

		return new PolinomioArray();
	}

}