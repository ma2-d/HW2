package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza {
	

	private String direzioneBloccata;
	private String nomeAttrezzosbloccante;
	
	public StanzaBloccata(String nome,String direzione,String nomeAttrezzo) {
		super(nome);
		this.direzioneBloccata = direzione;
		this.nomeAttrezzosbloccante = nomeAttrezzo;
	}
	
	@Override
	public Stanza getStanzaAdiacente(String direzione) {

		if(direzione.equals(direzioneBloccata) && !this.hasAttrezzo(this.nomeAttrezzosbloccante)) {
			return this;	
		}
		return super.getStanzaAdiacente(direzione);
    }
	
	@Override
    public String getDescrizione() {
		if(this.hasAttrezzo(nomeAttrezzosbloccante)) {
			return super.getDescrizione();
		}
		return "Stanza e' bloccata nella direzione" + this.direzioneBloccata + "\n bisogna di avere di" + this.nomeAttrezzosbloccante;
    }
}
