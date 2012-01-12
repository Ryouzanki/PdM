public class Wargame {
	private Plateau plateau;

	// temp
	public Wargame() {
		this.plateau = new Plateau(5, 5);
	}

	// temp affichage pour debugging
	public void afficher() {
		System.out.println();



	public static void main(String[] args) {
		

		// Tout ce qui se trouve en bas sert a tester pour le moment...
		Wargame test = new Wargame();
		Unite tank = new Unite(20,3,50,90,1,6,"Tank");
		test.plateau.Ajouter(tank, true);
		test.plateau.Envoyer(test.plateau.Obtenir(0,true),2,2);
		System.out.println(test);
		System.out.println(test.plateau);
		test.afficher();

	}
}
