package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {
	private IO io;
	private String nomeAttrezzo;
	static final private String name = "prendi";
	
	public ComandoPrendi() {
		
	}
	
	/*
	 * Comando "Prendi" che toglie un oggetto dalla stanza
	 * corrente e lo inserisce nella borsa del giocatore
	 */
	
	@Override
	public void esegui(Partita partita) {
		if(partita.getLabirinto().getStanzaCorrente().hasAttrezzo(nomeAttrezzo)) {
			Attrezzo attrezzoPreso;
			attrezzoPreso = partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
			if(partita.getStanzaCorrente().removeAttrezzo(nomeAttrezzo) && 
			   partita.getGiocatore().getBorsa().addAttrezzo(attrezzoPreso))
				this.io.mostraMessaggio("Oggetto aggiunto alla borsa");
			else {
				partita.getStanzaCorrente().addAttrezzo(attrezzoPreso);
				this.io.mostraMessaggio("raggiunto massimo peso o numero oggetti");
			}
		}
		else
			this.io.mostraMessaggio(nomeAttrezzo + " non e' presente nella stanza");
	
		
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setIo(IO io) {
		// TODO Auto-generated method stub
		this.io = io;
	}
	

}
