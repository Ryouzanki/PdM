import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Fenetre extends JFrame {

        private JPanel container = new JPanel();
        private JTextField jtf1 = new JTextField("Nom du joueur 1");
        private JTextField jtf2 = new JTextField("Nom du joueur 2");
        private JComboBox combo1 = new JComboBox();
	private JComboBox combo2 = new JComboBox();
        private JLabel label1 = new JLabel("Armée du joueur 1");
        private JLabel label2 = new JLabel("Armée du joueur 2");
        private JButton validation = new JButton ("Valider");
             
        public static void main(String args[]) {
        	Fenetre test = new Fenetre();
        }
        
        public Fenetre(){
        
        this.setTitle("Wargame");
        this.setSize(800, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);	
        
        clavier clav = new clavier();
	this.addKeyListener(clav);
 
        container.setBackground(Color.white);
        container.setLayout(new BorderLayout());  
        
        String[] liste_des_choix = {
        	"Faction Puriste",
        	"Parti Impérial",
        	"Confrérie du Monolithe",
        	"Inquisition Eden Vitalus"};
        
        combo1 = new JComboBox(liste_des_choix);
        combo2 = new JComboBox(liste_des_choix);
        
        combo1.setPreferredSize(new Dimension(100,20));
        combo1.setForeground(Color.blue);
        
        combo2.setPreferredSize(new Dimension(100,20));
        combo2.setForeground(Color.red);
        
        JMenuBar menu = new JMenuBar();
	JMenu fichier = new JMenu("Fichier");
	JMenuItem nouveau = new JMenuItem("Nouvelle partie");
	gestnouveau Gnouv = new gestnouveau();
	nouveau.addActionListener(Gnouv);
	JMenuItem quitter = new JMenuItem("Quitter le jeu");
	fichier.add(nouveau);
	fichier.addSeparator();
	fichier.add(quitter);
	menu.add(fichier);
	this.setJMenuBar(menu);             
        validation.addActionListener(new valider());
        
        
        JPanel top = new JPanel();
        top.add(label1);
        top.add(combo1);
        top.add(jtf1);
        top.add(label2);
        top.add(combo2);
        top.add(jtf2);
        top.add(validation);
        container.add(top, BorderLayout.EAST);
        this.setContentPane(container);
        this.setVisible(true); 
        this.setEnabled(true);
        this.setFocusable(true);           
        }
        
        public class clavier extends KeyAdapter{
public clavier(){}
public void keyPressed(KeyEvent e){
if (e.isControlDown() && (e.getKeyCode() == KeyEvent.VK_Q)) {
System.exit(0);}
}
}
        //pas encore utilisé
public class souris extends MouseAdapter{
public souris(){}
public void mouseClicked(MouseEvent e){
System.out.println("POUR LA " + e.getClickCount() + "ème FOIS !!");}
}

public class gestnouveau implements ActionListener{
public gestnouveau(){}
public void actionPerformed(ActionEvent e){//lancer new game
System.out.println("Nouvelle partie");}
}

             class valider implements ActionListener{
 
                public void actionPerformed(ActionEvent e) {
                                                
                                                
                   JOptionPane jop = new JOptionPane();			
			int option = jop.showConfirmDialog(null, "Commencer une partie avec : \n\n-" + jtf1.getText()+" jouant "+combo1.getSelectedItem()+"\n-"+jtf2.getText()+" jouant "+combo2.getSelectedItem(), "Lancement de l'animation", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
			
			if(option == JOptionPane.OK_OPTION)
			{
				System.out.println("jeu lancé");	
			}
                }
                
        }   
}


