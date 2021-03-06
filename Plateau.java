/** Fichier de la classe Plateau qui gerera le plateau de jeu ainqi que 
 * les positions des unités
 * @author Dernières modif par Ryou
 * @version 120111
 */

public class Plateau {

	private int haut, large;	// Dimensions du plateau
	private Unite[][] carreaux;	// Matrice des cases du tableau et leur contenu (occupe ou pas)
	private Unite[] armee1;		// Unites composant l'armee 1 pas encore sur le terrain avec un nombre max par défaut temporaire
	private Unite[] armee2;		// Unites composant l'armee 1 pas encore sur le terrain avec un nombre max par défaut temporaire
	public int nb1=0, nb2=0; // Nombre d'unite dans l'armee 1 et 2 deja envoyee

	public Plateau(int _haut, int _large) {
		this.haut = _haut;
		this.large = _large;
		carreaux = new Unite[_large][_haut];

		// temp
		armee1 = new Unite[20];
		armee2 = new Unite[20];

		for(int i=0; i<_large; i++) {
			for(int j=0; j<_haut; j++) {
				carreaux[i][j] = null;
			}
		}
	}

	// Choix des armees
	public void choix_armee(int n, boolean b) {
		if (b) {
			armee2 = Faction.choix_faction(n);
		}
		else {
			armee1 = Faction.choix_faction(n);
		}
	}
		
		

	// Actualise le tableau (efface les cadavres)
	public void crocmort() {
		for(int i=0; i<large; i++) {
			for(int j=0; j<haut; j++) {
				// debogage 
				// System.out.println("check case ["+i+","+j+"]");
				if ((carreaux[i][j]!=null)&&(carreaux[i][j].GetPV()<1)) {
					System.out.println(carreaux[i][j].GetLabel()+"a été détruit.");
					carreaux[i][j]=null;
				}
			}
		}
	}

/*
	// Sert a initialiser les armees
	public void Ajouter(Unite U, boolean b) { // Boolean foireux pour déterminer l'armee 1 ou 2) 
		if (b) {
			armee1[nb1]=U;
			nb1++;
		}
		else {
			armee2[nb2]=U;
			nb2++;
		}
	}
*/

	// Fonction qui déplace une unite selon de nouvelle coordonnee si c'est a
	// portee de MVT et que la case n'est pas occupee. pas de gestion de
	// collision pour le moment. Indique aussi que l'unite a bouge mais pas
	// tire
	public void Deplacer(Unite U, int x, int y) {
		if (((Math.abs(U.GetX()-x)+Math.abs(U.GetY()-y))<=U.GetMVT())&&(!U.GetA_bouge())&&(carreaux[x][y]==null)) {
			U.SetA_bouge(true);
			carreaux[x][y]=U;
			carreaux[U.GetX()][U.GetY()]=null;
			U.SetX(x);
			U.SetY(y);
		}
		else {System.out.println(U.GetLabel()+ "BOUGE PAS WTF");} // Debogage
	}

	// Fonction pour déplacer une unite d'une armee sur le plateau
	// L'unite ne doit pas etre deja sur le plateau et la case doit etre libre
	public void Envoyer(Unite U, int x, int y) {	// x et y seront plus ou moins imposés bord de table
		if ((!U.GetEst_la())&&(carreaux[x][y]==null)) {
			U.SetEst_la(true);
			carreaux[x][y]=U;
			U.SetX(x);
			U.SetY(y);	
		}

	}

	// Obtenir une unite d'une armee
	public Unite Obtenir(int i, boolean b) { // Encore une boolean foireuse pour déterminer de quelle armee
		if(b) {
			nb1++;
			return armee1[i];
		}
		else {
			nb2++;
			return armee2[i];
		}
	}

	public int getHaut() {
		return this.haut;
	}
	public int getLarge() {
		return this.large;
	}

	public Unite occupant(int x, int y) {
		return this.carreaux[x][y];
	}
}
