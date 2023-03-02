package metier;

public class Main {

	public static void main(String[] args) {
	
		GestionInscription gi = new GestionInscription();
		Inscription i = new Inscription();
		i.setCodeFil("GI");
		i.setDateInscription("25/11/2007");
		i.setGroupe("b");
		i.setNumEt("D881466");
		i.setSemestre("S1");
		gi.ajouterInscription(i);


	}

}
