/** Fichier de la classe Unite qui servira a créer les types d'unité
 * @author Dernières modification par Ryouzanki
 * @version 120111
 */

public class Unite{	// Classe gerant les differentes unites du jeu

	private int PV;		// Point de vie de l'unite qui est supprimee quand PV<1
	private int MVT;	// Nombre de case que l'unite peut parcourir
	private int DEF;	// Point que l'on retire a l'attaque subie
	private int ATQ;	// Degats brut d'une attaque. Avec un Q.
	private int NBA;	// Nombre d'attaque pour les anti-infanteries
	private boolean A_joue;	// Savoir si l'unite a deja bouge
	private int Portee;	// Distance d'engagement maximale d'un ennemi
	private String Label;	// Nom de l'unite... Useless ?
	private int x, y;	// Coordonnee de l'unite sur le plateau
	private boolean Joueur;	// Appartient au joueur 1 sinon au joueur 2
	private boolean Est_la;	// Presence sur le plateau
	private boolean A_bouge;	// Si l'unite a bouge
	
	// Constructeur d'unité
	public Unite(int _PV, int _MVT, int _DEF, int _ATQ, int _NBA, int _Portee, String _Label) {
		this.PV = _PV;
		this.MVT = _MVT;
		this.DEF = _DEF;
		this.ATQ = _ATQ;
		this.NBA = _NBA;
		this.Portee = _Portee;
		this.Label = _Label;
		this.Est_la = false;
		this.A_bouge = true;
	}
	
	// Get
	public int GetPV() {
		return this.PV ;
	}
	public int GetMVT() {
		return this.MVT ;
	}
	public int GetDEF() {
		return this.DEF ;
	}
	public int GetATQ() {
		return this.ATQ ;
	}
	public int GetNBA() {
		return this.NBA ;
	}
	public boolean GetA_joue() {
		return this.A_joue ;
	}
	public int Getportee() {
		return this.Portee ;
	}
	public String GetLabel() {
		return this.Label ;
	}
	public int GetX() {
		return this.x ;
	}
	public int GetY() {
		return this.y ;
	}
	public boolean GetJoueur() {
		return this.Joueur ;
	}
	public boolean GetEst_la() {
		return this.Est_la ;
	}
	public boolean GetA_bouge() {
		return this.A_bouge ;
	}
	
	// Set
	public void SetPV(int n) {
		this.PV=n;
	}
	public void SetMVT(int n) {
		this.MVT=n;
	}
	public void SetDEF(int n) {
		this.DEF=n;
	}
	public void SetATQ(int n) {
		this.ATQ=n;
	}
	public void SetNBA(int n) {
		this.NBA=n;
	}
	public void SetA_joue(boolean n) {
		this.A_joue=n;
	}
	public void Setportee(int n) {
		this.Portee=n;
	}
	public void SetLabel(String n) {
		this.Label=n;
	}
	public void SetX(int n) {
		this.x=n;
	}
	public void SetY(int n) {
		this.y=n;
	}
	public void SetJoueur(boolean n) {
		this.Joueur=n;
	}
	public void SetEst_la(boolean n) {
		this.Est_la=n;
	}
	public void SetA_bouge(boolean n) {
		this.A_bouge=n;
	}
	
	// Les 'vraies' fonctions
	
	// Fonction qui fait attendre une unite que le joueur ne veut pas utiliser
	public void Attendre() {
		this.A_joue=true;
	}


	// Fonction d'attaque temporaire pour le moment car chaque unite n'aura
	// qu'une unique attaque pour le moment
	public void Attaque(Unite Def) {
		if (((Math.abs(this.x-Def.x)+Math.abs(this.y-Def.y))<=this.Portee)&&(!this.A_joue)) { // XXX distance()
			this.A_joue = true;
			for (int i=0; i<this.NBA; i++) {
				Def.Subit(this.ATQ);
			}
		}
	}
	
	// Fonction pour infliger des degats a l'unite qui prend le coup
	public void Subit(int dgt_brut) {
		int dgt_reel = dgt_brut-this.DEF;
		if (dgt_reel < 0) {
			dgt_reel=0;
		}
		this.PV = this.PV-dgt_reel;
	}
}
