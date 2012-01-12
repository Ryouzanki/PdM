public class Faction{
	public static Unite[] choix_faction(int n) {
		Unite[] faction;
		faction = new Unite[20];
		switch (n) {
			case 1:
				faction[0] = new Unite(10,3,0,5,1,1,"Paysan a la con ");
				faction[1] = new Unite(10,3,0,5,1,1,"Paysan a la con ");
				faction[2] = new Unite(10,3,0,5,1,1,"Paysan a la con ");
				faction[3] = new Unite(10,3,0,5,1,1,"Paysan a la con ");
				faction[4] = new Unite(20,4,5,10,1,1,"Milice a la con ");
				faction[5] = new Unite(20,4,5,10,1,1,"Milice a la con ");
				break;
			case 2:
				faction[0] = new Unite(20,4,5,10,1,1,"Milice a la con ");
				faction[1] = new Unite(20,4,5,10,1,1,"Milice a la con ");
				faction[2] = new Unite(20,4,5,10,1,1,"Milice a la con ");
				faction[3] = new Unite(20,4,5,10,1,1,"Milice a la con ");
				break;
			default:
				faction[0] = new Unite(99,9,9,99,9,9,"Gros Bill ");
				break;
		}
		return faction;
	}
}


