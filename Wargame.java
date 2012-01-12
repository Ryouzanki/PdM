public class Wargame {
	private Plateau plateau;

	// temp
	public Wargame() {
		this.plateau = new Plateau(5, 5);
	}

	// temp affichage pour debugging
	public void afficher() {
		System.out.println();
		for(int i=0; i<this.plateau.getHaut(); i++) {
			System.out.println();
			for(int j=0; j<this.plateau.getLarge(); j++) {
				if (this.plateau.occupant(i,j)==null) {
					System.out.print(" - ");
				}
				else { 
					System.out.print(" + ");
				}
			}
			System.out.println();
		}
	}



	public static void main(String[] args) {
	
		// phase de démarage

		// Tout ce qui se trouve en bas sert a tester pour le moment...
		Wargame test = new Wargame();
		//Unite tank = new Unite(20,3,50,90,1,6,"Tank");
		//Unite DIEU = new Unite(99,99,99,99,99,99,"DIEU");
		test.plateau.choix_armee(2,true);
		test.plateau.choix_armee(1,false);
		//test.plateau.Ajouter(plateau.armee[nb, true);
		//test.plateau.Ajouter(plateau.nb1, false);
		test.plateau.Envoyer(test.plateau.Obtenir(test.plateau.nb2,true),2,2);
		test.plateau.Envoyer(test.plateau.Obtenir(test.plateau.nb1,false),1,2);
		//System.out.println(test);
		//System.out.println(test.plateau);
		test.afficher();
		test.plateau.occupant(2,2).SetA_bouge(false);
		test.plateau.occupant(1,2).SetA_joue(false);
		test.plateau.Deplacer(test.plateau.occupant(2,2),1,1);
		test.afficher();
		test.plateau.occupant(1,2).Attaque(test.plateau.occupant(1,1));
		test.plateau.crocmort();
		test.afficher();

	}
}
