package web;

import java.util.ArrayList;
import java.util.List;

import metier.Inscription;

public class InscriptionModel {
	
	private List<Inscription> inscriptions = new ArrayList<Inscription>();
	private Inscription i = new Inscription();
	public List<Inscription> getInscriptions() {
		return inscriptions;
	}
	public void setInscriptions(List<Inscription> inscriptions) {
		this.inscriptions = inscriptions;
	}
	public Inscription getI() {
		return i;
	}
	public void setI(Inscription i) {
		this.i = i;
	}
	

}
