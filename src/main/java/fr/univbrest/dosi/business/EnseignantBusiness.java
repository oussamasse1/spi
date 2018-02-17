package fr.univbrest.dosi.business;

import java.util.List;

import fr.univbrest.dosi.bean.Enseignant;

public interface EnseignantBusiness {
	List<Enseignant> getEnseignants();
	List<Enseignant> getEnseignant(long noEnseignant);
	List<Enseignant> getEnseignantByEmail(String mail);
	List<Enseignant> getEnseignantByPays(String pays);
	Enseignant creerEnseignant(Enseignant E);
	void supprimerEnseignant(Enseignant E);
	void supprimerByNoEnseignant(long noE);
	//Enseignant updateEnseignant(Enseignant E, Enseignant nouveauE);
}
