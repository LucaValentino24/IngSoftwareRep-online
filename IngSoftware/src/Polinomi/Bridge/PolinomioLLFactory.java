package Polinomi.Bridge;

public class PolinomioLLFactory implements PolinomioImplFactory {

	@Override
	public PolinomioImpl createPolinomioImpl() {

		return new PolinomioLL();
	}

}
