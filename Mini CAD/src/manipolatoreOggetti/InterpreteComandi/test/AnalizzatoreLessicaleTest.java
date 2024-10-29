package manipolatoreOggetti.InterpreteComandi.test;

import manipolatoreOggetti.InterpreteComandi.AnalizzatoreLessicale;
import manipolatoreOggetti.InterpreteComandi.Simboli;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class AnalizzatoreLessicaleTest {

    AnalizzatoreLessicale analizzatoreLessicale;
    Reader in;
    String daLeggere;

    @BeforeAll
    public static void setUpAll(){
        System.out.println("Should Print Before All Tests");
    }

    @BeforeEach
    public void setUp() throws FileNotFoundException {
        System.out.println("Should Print Before Each Test");
    }

    @Test
    @DisplayName("deve leggere i simboli NEW CIRCLE (20.1)")
    public void creazioneCerchio(){
        daLeggere = "new circle (20.1)";
        in = new StringReader(daLeggere);
        analizzatoreLessicale = new AnalizzatoreLessicale(in);
        assertEquals(Simboli.NEW,analizzatoreLessicale.prossimoSimbolo());
        assertEquals(Simboli.CIRCLE,analizzatoreLessicale.prossimoSimbolo());
        assertEquals(Simboli.TONDA_APERTA, analizzatoreLessicale.prossimoSimbolo());
        assertEquals(Simboli.NUMERO, analizzatoreLessicale.prossimoSimbolo());
        assertEquals(Simboli.TONDA_CHIUSA,analizzatoreLessicale.prossimoSimbolo());
        assertEquals(20.1,analizzatoreLessicale.getNumero());
    } //questo test fallisce per un minimo errore dovuto alla traduzione da stringa a float del metodo getNumero()

    @ParameterizedTest
    @DisplayName("deve leggere i numeri 1,2,3,4")
    @ValueSource(strings = {"1","2","3","4"})
    public void provaNumeroInt(String numero){
        in = new StringReader(numero);
        analizzatoreLessicale = new AnalizzatoreLessicale(in);
        assertEquals(Simboli.NUMERO, analizzatoreLessicale.prossimoSimbolo());
        assertEquals(Integer.parseInt(numero), analizzatoreLessicale.getNumeroInt());
    }

    @Test
    @DisplayName("gli passo il path di un'immagine")
    public void provaPathImmagine(){
        in = new StringReader("src/manipolatoreOggetti/immagini/a.jpg");
        analizzatoreLessicale = new AnalizzatoreLessicale(in);
        assertEquals(Simboli.PATH,analizzatoreLessicale.prossimoSimbolo());
        assertEquals(Simboli.PATH,analizzatoreLessicale.prossimoSimbolo());
        assertEquals(Simboli.PATH,analizzatoreLessicale.prossimoSimbolo());
        assertEquals(Simboli.PATH,analizzatoreLessicale.prossimoSimbolo());
        assertEquals(Simboli.PATH,analizzatoreLessicale.prossimoSimbolo());
        assertEquals(Simboli.PATH,analizzatoreLessicale.prossimoSimbolo());
        assertEquals(Simboli.PATH,analizzatoreLessicale.prossimoSimbolo());
        assertEquals(Simboli.PUNTO,analizzatoreLessicale.prossimoSimbolo());
        assertEquals(Simboli.PATH,analizzatoreLessicale.prossimoSimbolo());
        assertEquals("src/manipolatoreOggetti/immagini/a.jpg", analizzatoreLessicale.getPath());
    }

    @Test
    @DisplayName("Prova di numeri negativi")
    public void provaNumeroNegativi(){
        in = new StringReader("-150");
        analizzatoreLessicale = new AnalizzatoreLessicale(in);
        assertNotSame(Simboli.NUMERO, analizzatoreLessicale.prossimoSimbolo());
    } //ho registrato il simbolo - come parte di PATH quindi viene escluso dai numeri

    @AfterEach
    public void tearDown() {
        System.out.println("Should Execute After Each Test");
    }

    @AfterAll
    public static void tearDownAll(){
        System.out.println("Should be executed at the end of the Test");
    }
}