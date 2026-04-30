package it.uniroma3.comandi;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPrendi;

public class ComandoPrendiTest {

	private ComandoPrendi c;
	private Partita p;
	private Attrezzo a;
	private Stanza s;
	private Attrezzo b;
	
	@BeforeEach
	void setUp() {
		s = new Stanza("s");
		c = new ComandoPrendi();
		p = new Partita();
		a = new Attrezzo("a",2);
		c.setIo(new IOConsole());
		b = new Attrezzo("b",1);
	}
	
	@Test
	void testComandoPrendi1() {
		p.setStanzaCorrente(s);
		s.addAttrezzo(a);
		c.setParametro("a");
		c.esegui(p);
		assertFalse(s.hasAttrezzo("a"));
	}
	@Test
	void testComandoPrendi2() {
		p.setStanzaCorrente(s);
		s.addAttrezzo(b);
		s.addAttrezzo(a);
		c.setParametro("b");
		c.esegui(p);
		assertTrue(s.hasAttrezzo("a"));
	}
	
}
