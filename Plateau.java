/** Fichier de la classe Plateau qui gerera le plateau de jeu ainqi que 
 * les positions des unités
 * @author Dernières modif par Ryou
 * @version 120111
 */

public class Plateau {
	private int haut, large;	// Dimensions du plateau
	private Unite[][] carreaux;	// Matrice des cases du tableau et leur statut (occupe ou pas)

	public Plateau(int _haut, int _large) {
		this.haut = _haut;
		this.large = _large;
		carreaux = new Unite[_large][_haut];

		for(int i=0; i<_large; i++) {
			for(int j=0; j<_haut; j++) {
				carreaux[i][j] = null;
			}
		}
	}
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
	}
}


