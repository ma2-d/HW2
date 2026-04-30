package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai implements Comando {
	
	private String direzione;
	private IO io;
	static final private String name = "vai";
	
	public ComandoVai() {
		
	}
	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */

	@Override
	public void esegui(Partita partita) {
		if(direzione==null)
			this.io.mostraMessaggio("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			this.io.mostraMessaggio("Direzione inesistente");
		else {
			partita.getGiocatore().setCfu(partita.getGiocatore().getCfu() - 1);
			partita.getLabirinto().setStanzaCorrente(prossimaStanza);
		}
		this.io.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
	
	}

	@Override
	public void setParametro(String parametro) {
		this.direzione = parametro;
		
	}
	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return name;
	}
	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return this.direzione;
	}
	@Override
	public void setIo(IO io) {
		// TODO Auto-generated method stub
		this.io = io;
	}


}
