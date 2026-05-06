package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;

class PartitaTest {
	private Partita game;
	private Labirinto lab;
	
	@BeforeEach
	void setUp() {
		game = new Partita();
		lab = game.getLabirinto();
	}
	
	@Test
	void testVintaTrue() {
		lab.setStanzaCorrente(lab.getStanzaVincente());
		assertTrue(game.vinta());
	}
	
	@Test
	void testVintaFalse() {
		assertFalse(game.vinta());
	}
	
	@Test
	void testSetFinita() {
		assertFalse(game.isFinita());
		game.setFinita();
		assertTrue(game.isFinita());
	}
	
	@Test
	void testIsFinitaFalse() {
		assertFalse(game.isFinita());
	}
	
	@Test
	void testIsFinitaTrueFinita() {
		game.setFinita();
		assertTrue(game.isFinita());
	}
	
	@Test
	void testIsFinitaTrueVinta() {
		lab.setStanzaCorrente(lab.getStanzaVincente());
		assertTrue(game.isFinita());
	}
	
	@Test
	void testIsFinitaTrueCfuEqualZero() {
		game.getGiocatore().setCfu(0);
		assertTrue(game.isFinita());
	}
	
	@Test
	void testDiAccettazione() {
		String[] s = {"fine"};
		IOSimulator io = new IOSimulator(s);
		DiaDia d = new DiaDia(io);
		d.gioca();
		assertEquals("Grazie di aver giocato!",io.getUltimoMessaggio());
	}
	
	@Test
	void testDiAccettazione1() {
		String[] s = {"vai nord"};
		IOSimulator io = new IOSimulator(s);
		DiaDia d = new DiaDia(io);
		d.gioca();
		assertEquals("Grazie di aver giocato!",io.getUltimoMessaggio());
		assertTrue(java.util.Arrays.asList(io.getOutput()).contains("Hai vinto!"));
	}
	@Test
	void testDiAccettazione2() {
	    String[] s = {"vai fff"};
	    IOSimulator io = new IOSimulator(s);
	    DiaDia d = new DiaDia(io);
	    d.gioca();
	   assertTrue(java.util.Arrays.asList(io.getOutput()).contains("Direzione inesistente"));
	}
	
	@Test 
	void testDiAccettazione3() {
	    String[] s = {"vai"};
	    IOSimulator io = new IOSimulator(s);
	    DiaDia d = new DiaDia(io);
	    d.gioca();
	    assertTrue(java.util.Arrays.asList(io.getOutput()).contains("Dove vuoi andare ?"));
	}
}
