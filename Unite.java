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
	
	// Constructeur d'unité
	public Unite(int _PV, int _MVT, int _DEF, int ATQ, int NBA, int _portee, String _label) {
		this.PV=_PV;
		this.MVT=_MVT;
		this.DEF=_DEF;
		this.ATQ=_ATQ;
		this.NBA=_NBA;
		this.portee=_portee;
		this.label=_label
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
	public boolean SetA_joue(boolean n) {
		this.A_joue=n;
	}
	public void Setportee(int n) {
		this.Portee=n;
	}
	public String SetLabel(String n) {
		this.Label=n;
	}
	public void SetX(int n) {
		this.x=n;
	}
	public void SetY(int n) {
		this.y=n;
	}
	public boolean GetJoueur(boolean n) {
		this.Joueur=n;
	}
}
