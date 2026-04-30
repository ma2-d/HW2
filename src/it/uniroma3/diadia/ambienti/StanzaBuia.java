package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza {
	private  String nomeAttrezzo;
	
	public StanzaBuia(String nome,String nomeAttezzo ) {
		super(nome);
		this.nomeAttrezzo = nomeAttezzo;
	}
	
	@Override
    public String getDescrizione() {
		if(this.hasAttrezzo(nomeAttrezzo)) {
        	 return super.getDescrizione();
        }
		else {
		String s = "qui c'è buio pesto";
			return s;
		}
	}
}
