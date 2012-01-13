public class Wargame {
	private Plateau plateau;
	private Fenetre fenetre;


	// temp
	public Wargame() {
		this.plateau = new Plateau(5, 5);
		this.fenetre = new Fenetre();
	}

	// temp affichage pour debugging
	public void afficher() { // XXX dans plateau
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
	
		Wargame test = new Wargame();
		
		boolean game_over=false;
		System.out.println("Armée du joueur 1 :");
		int choix1 = 1;// TODO
		System.out.println("Armée du joueur 2 :");
		int choix2 = 2;// TODO
		test.plateau.choix_armee(choix2,true);
		test.plateau.choix_armee(choix1,false);
		while(!game_over) {

			// normalment :
			// J1 place une unité qui ne pourra pas etre utilisée à ce tour si
			// il a envie et s'il lui en reste. l'ordre des unités sera imposé
			// tant qu'il reste des unités de J1 avec A_joué = false 
			// 		faire jouer J1
			// 			s'il attaque
			// 				faire l'attaque et rafraichir
			// 				afficher après chaque manoeuvre avec un annonceur
			// Puis faire jouer l'autre et checker si c'est le gg
			//
			// ce qui suit fait office de test
			test.afficher();
			test.plateau.Envoyer(test.plateau.Obtenir(test.plateau.nb2,true),2,2);
			System.out.println("Un "+test.plateau.nb2+" est arrivé sur le terrain !");
			test.plateau.occupant(2,2).SetA_bouge(false);
			test.afficher();
			test.plateau.Deplacer(test.plateau.occupant(2,2),1,1);
			System.out.println(test.plateau.nb2+" : En route !");
			test.afficher();


			test.plateau.Envoyer(test.plateau.Obtenir(test.plateau.nb1,false),1,2);
			System.out.println("Un "+test.plateau.nb1+" est arrivé sur le terrain !");
			test.plateau.occupant(1,2).SetA_joue(false);
			test.afficher();
			test.plateau.occupant(1,2).Attaque(test.plateau.occupant(1,1));
			test.plateau.crocmort();
			test.afficher();
			game_over=true;

		}	
	}
}
