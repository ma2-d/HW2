package it.uniroma3.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPosa;

public class ComandoPosaTest {
	private Stanza s1;
	private Attrezzo a1;
	private Partita p;
	private ComandoPosa c;

	
	@BeforeEach
	void setUp() {
		s1 = new Stanza("s1");
		a1 = new Attrezzo("a1",2);
		p = new Partita();
		c = new ComandoPosa();
		c.setIo(new IOConsole());
		p.getGiocatore().getBorsa().addAttrezzo(a1);
		p.setStanzaCorrente(s1);
	}
	
	@Test
	void testComandoPosa1() {
		c.setParametro("a1");
		c.esegui(p);
		assertTrue(s1.hasAttrezzo("a1"));
	}
	@Test
	void testComandoPosa2() {
		c.setParametro("a2");
		c.esegui(p);
		assertFalse(s1.hasAttrezzo("a2"));
	}
	
}
