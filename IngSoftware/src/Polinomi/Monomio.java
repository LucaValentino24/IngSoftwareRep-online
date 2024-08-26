package Polinomi;

/**
 * 
 * 
 * 
 * La classe Monomio rappresenta dei monomi aventi forma {@code c*x^g}, dove
 * {@code c} &egrave; un coefficiente reale, {@code x} &egrave; l'indeterminata
 * e {@code g} &egrave; il grado del monomio.
 * 
 * <p>
 * La classe Monomio formisce metodi per effetuare le comuni operazioni
 * algebriche tra monomi: somma tra monomi simili, moltiplicazione di un monomio
 * per uno scalare e moltiplicazione tra due monomi.
 * </p>
 * 
 * @author Angelo Furfaro
 */

public final class Monomio implements Comparable<Monomio> {

	/**
	 * grado del monomio
	 */
	private final int grado;

	/**
	 * coefficiente del monomio
	 */
	private final double coeff;

	/**
	 * Costruisce un oggetto polinomio a partire dal coefficiente e dal grado
	 * 
	 * @param c
	 *            coefficiente del monomio
	 * @param g
	 *            grado del monomio
	 * @throws GradoNegativo
	 *             se {@code g<0}, ovvero se il grado specificato &egrave;
	 *             negativo
	 */
	public Monomio(double c, int g) {
		if (g < 0)
			throw new GradoNegativo(g);
		coeff = c;
		grado = g;

	}

	/**
	 * Costruttore per copia
	 * 
	 * @param m
	 *            monomio da copiare
	 */
	public Monomio(Monomio m) {
		coeff = m.coeff;
		grado = m.grado;

	}

	/**
	 * 
	 * Il Monomio this precede m se il suo grado &egrave; inferiore, lo segue se
	 * &egrave; superiore
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Monomio m) {

		return grado - m.grado;
	}

	/**
	 * Due monomi sono considerati uguali se hanno lo stesso grado e lo stesso
	 * coefficiente
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Monomio))
			return false;
		Monomio m = (Monomio) o;
		if (grado != m.grado)
			return false;
		return Double.compare(m.coeff, coeff) == 0;
	}

	/**
	 * retstituisce il coefficiente del monomio
	 * 
	 * @return il coefficiente del monomio
	 * 
	 */
	public double getCoeff() {
		return coeff;
	}

	/**
	 * restituisce il grado del monomio
	 * 
	 * @return il grado del monomio
	 */
	public int getGrado() {

		return grado;
	}

	/**
	 * Restituisce il monomio risultante dalla somma del monomio this e dal
	 * monomio specificato
	 * 
	 * @param m
	 *            monomio da sommare a this
	 * @return il monomio risultante
	 * @throws MonomiNonSimili
	 *             se il grado di {@code this} e quello di {@code m} sono
	 *             differenti
	 */
	public Monomio add(Monomio m) {
		if (m.grado != grado)
			throw new MonomiNonSimili(this.grado, m.grado);
		return new Monomio(coeff + m.coeff, grado);

	}

	/**
	 * Restituisce il monomio risultante dalla moltiplicazione del mononio this
	 * per lo scalare {@code s}
	 * 
	 * @param s
	 *            lo scalare per il quale moltiplicare
	 * @return il monomio risultante
	 */
	public Monomio mul(int s) {
		return new Monomio(s * coeff, grado);
	}

	/**
	 * Restituisce il monomio risultante dalla moltiplicazione del mononio this
	 * per il monomio {@code m}
	 * 
	 * @param m
	 *            il monomio per cui moltiplicare this
	 * @return il monomio risultante
	 * 
	 * 
	 */
	public Monomio mul(Monomio m) {
		return new Monomio(m.coeff * coeff, m.grado + grado);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (coeff < 0)
			sb.append('-');
		if (Math.abs(coeff) != 1 || grado == 0)
			sb.append(Math.abs(coeff));

		if (grado > 0)
			sb.append('x');

		if (grado > 1)
			sb.append('^').append(grado);
		return sb.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		int res = 17;
		res = 31 * res + grado;
		long c = Double.doubleToLongBits(coeff);
		res = 31 * res + (int) (c ^ (c >>> 32));
		return res;

	}

}
