package garages;

import java.io.PrintStream;
import java.util.*;

public class Voiture {

	private final String immatriculation;
	private final List<Stationnement> myStationnements = new LinkedList<>();
        private List<Garage> mygarages = new LinkedList<>();

	public Voiture(String i) {
		if (null == i) {
			throw new IllegalArgumentException("Une voiture doit avoir une immatriculation");
		}

		immatriculation = i;
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	/**
	 * Fait rentrer la voiture au garage 
         * Précondition : la voiture ne doit pas être déjà dans un garage
	 *
	 * @param g le garage où la voiture va stationner
	 * @throws java.lang.Exception Si déjà dans un garage
	 */
	public void entreAuGarage(Garage g) throws Exception {
            if (estDansUnGarage()) {
                throw new Exception("La voiture est déjà garée");
            }
            else{
		// Et si la voiture est déjà dans un garage ?
		Stationnement s = new Stationnement(this, g);
		myStationnements.add(s);
	}
        }

	/**
	 * Fait sortir la voiture du garage 
         * Précondition : la voiture doit être dans un garage
	 *
	 * @throws java.lang.Exception si la voiture n'est pas dans un garage
	 */
	public void sortDuGarage() throws Exception  {
             if (!estDansUnGarage()){
                 throw new Exception("La voiture n'as pas de garage.");
             }
             else {
                 Stationnement lastStatio = myStationnements.get(myStationnements.size()-1);
                 lastStatio.terminer();
             }
            
		//throw new UnsupportedOperationException("Pas encore implémenté");
		// TODO: Implémenter cette méthode
		// Trouver le dernier stationnement de la voiture
		// Terminer ce stationnement
	}

	/**
	 * @return l'ensemble des garages visités par cette voiture
	 */
	public List<Garage> garagesVisites() {
		// TODO: Implémenter cette méthode
		//throw new UnsupportedOperationException("Pas encore implémenté");
           return mygarages;
        }

	/**
	 * @return vrai si la voiture est dans un garage, faux sinon
	 */
	public boolean estDansUnGarage() {
		// TODO: Implémenter cette méthode
		//throw new UnsupportedOperationException("Pas encore implémenté");
		// Vrai si le dernier stationnement est en cours
                if (myStationnements.size() > 0){
            Stationnement lastStatio = myStationnements.get(myStationnements.size()-1);
            return lastStatio.estEnCours();
        }
                return false;
	}

	/**
	 * Pour chaque garage visité, imprime le nom de ce garage suivi de la liste des dates d'entrée / sortie dans ce
	 * garage
	 * <br>Exemple :
	 * <pre>
	 * Garage Castres:
	 *		Stationnement{ entree=28/01/2019, sortie=28/01/2019 }
	 *		Stationnement{ entree=28/01/2019, en cours }
	 *  Garage Albi:
	 *		Stationnement{ entree=28/01/2019, sortie=28/01/2019 }
	 * </pre>
	 *
	 * @param out l'endroit où imprimer (ex: System.out)
	 */
	public void imprimeStationnements(PrintStream out) {
		// TODO: Implémenter cette méthode
		//throw new UnsupportedOperationException("Pas encore implémenté");
                
                HashMap<Garage, List<Stationnement>> hashMap = new HashMap<>();
                myStationnements.stream().forEach((stationnement) -> {
            if (!hashMap.containsKey(stationnement.getGarage())){
                List<Stationnement> list = new ArrayList<>();
                list.add(stationnement);
                
                hashMap.put(stationnement.getGarage(), list);
                
            }
            else{
                hashMap.get(stationnement.getGarage()).add(stationnement);
            }
            
            garagesVisites().stream().forEach((garage) -> {
                out.println(garage);
                out.println(hashMap.get(garage));
            });
        });
                
	}

}
