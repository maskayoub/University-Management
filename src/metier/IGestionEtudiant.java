package metier;

import java.util.List;

public interface IGestionEtudiant {
	public void addEtudiant(Etudiant e);
	public void deleteEtudiant(String numEt);
	public void updateEtudiant(Etudiant e);
	public Etudiant getEtudiant(String numEt);
	public List<Etudiant> listEtudiants();
	public List<Etudiant> EtudiantsParMC(String mc);


}
