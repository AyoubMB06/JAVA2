package miniprojet_calculatrice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class CalculConvert extends JFrame implements ActionListener{
	
		//Initialisation des différents composants:
		JFrame frame = new JFrame();
		
		JTextField res = new JTextField();
		
		JRadioButton hex = new JRadioButton("Hex");
		JRadioButton dec = new JRadioButton("Déc");
		JRadioButton bin = new JRadioButton("Bin");
		ButtonGroup genre = new ButtonGroup();
		
		JButton n0 = new JButton("0");
		JButton n1 = new JButton("1");
		JButton n2 = new JButton("2");
		JButton n3 = new JButton("3");
		JButton n4 = new JButton("4");
		JButton n5 = new JButton("5");
		JButton n6 = new JButton("6");
		JButton n7 = new JButton("7");
		JButton n8 = new JButton("8");
		JButton n9 = new JButton("9");
		JButton virgule = new JButton(",");
		JButton egale = new JButton("=");
		JButton mult = new JButton("*");
		JButton div = new JButton("/");
		JButton add = new JButton("+");
		JButton del = new JButton("-");
		JButton clear = new JButton("C");
		JButton back = new JButton("←");
		JButton A = new JButton("A");
		JButton B = new JButton("B");
		JButton C = new JButton("C");
		JButton D = new JButton("D");
		JButton E = new JButton("E");
		JButton F = new JButton("F");
		JButton vide = new JButton();
				
		public CalculConvert() {
			
			
			this.setLayout(new FlowLayout());
			
			//Conteneur 1 
			JPanel p1 = new JPanel();
			this.getContentPane().add(p1);
			res.setPreferredSize( new Dimension( 250, 35 )); //Ajuster la largeur "250" à celle des boutons au dessous
			p1.add(res);
			res.setEditable(false);
			res.setBackground(Color.white);
			//Modification du "Font" du text Field:
		    Font font1 = new Font("SansSerif", Font.TRUETYPE_FONT, 20);
		    res.setFont(font1);
			res.setHorizontalAlignment(JTextField.RIGHT);
			
			//Conteneur 2
			JPanel p2 = new JPanel();
			genre.add(hex); //Ajout des 3boutons au ButtonGroup "genre"
			genre.add(dec);
			genre.add(bin);
			this.getContentPane().add(p2);
			p2.add(hex);
			p2.add(dec);
			p2.add(bin);
			
			//Conteneur 3
			JPanel p3 = new JPanel();
			this.getContentPane().add(p3);
			p3.setPreferredSize(new Dimension(250, 200)); //Même largeur que p1
			p3.setLayout(new GridLayout(5, 5, 5, 5));
			p3.add(A);
			p3.add(vide);
			p3.add(back);
			p3.add(clear);
			p3.add(div);
			p3.add(B);
			p3.add(n7);
			p3.add(n8);
			p3.add(n9);
			p3.add(mult);
			p3.add(C);
			p3.add(n4);
			p3.add(n5);
			p3.add(n6);
			p3.add(del);
			p3.add(D);
			p3.add(n1);
			p3.add(n2);
			p3.add(n3);
			p3.add(add);
			p3.add(E);
			p3.add(F);
			p3.add(n0);
			p3.add(virgule);
			p3.add(egale);
			
			//Ajout des ActionListener des différents boutons
			hex.addActionListener(this);
			dec.addActionListener(this);
			bin.addActionListener(this);

			n0.addActionListener(this);
			n1.addActionListener(this);
			n2.addActionListener(this);
			n3.addActionListener(this);
			n4.addActionListener(this);
			n5.addActionListener(this);
			n6.addActionListener(this);
			n7.addActionListener(this);
			n8.addActionListener(this);
			n9.addActionListener(this);
			A.addActionListener(this);
			B.addActionListener(this);
			C.addActionListener(this);
			D.addActionListener(this);
			E.addActionListener(this);
			F.addActionListener(this);
			clear.addActionListener(this);
			back.addActionListener(this);
			egale.addActionListener(this);
			mult.addActionListener(this);
			div.addActionListener(this);
			add.addActionListener(this);
			del.addActionListener(this);
			virgule.setEnabled(false);
			
			hex.setActionCommand("hex");
			dec.setActionCommand("dec");
			bin.setActionCommand("bin");
		}		
		
		int valeur1, valeur2;
		int Total;
		//Declaration des booléens pour savoir dans quelle direction on est
		boolean FLagAdd=false, FLagDel=false, FLagMult=false, FLagDiv=false;
		boolean FlagHex=false, FlagDec=false, FlagBin=false; 
		
		//Fonction qui gère les différents boutons des différentes opérations pour les décimaux
		private void OperationDec(String op) {
				valeur1=Integer.parseInt(res.getText()); //Conversion du getText() du String au INT
				res.setText("");
			if(op=="+") 
				FLagAdd=true;
			else if(op=="-") 
				FLagDel=true;
			else if(op=="*") 
				FLagMult=true;
			else if(op=="/") 
				FLagDiv=true;
		}
		
		//Fonction qui gère les différents boutons des différentes opérations pour les binaires
		private void OperationBin(String op) {
			valeur1=Integer.parseInt(res.getText(),2); //Conversion du getText() du Binaire en Décimal
			res.setText("");
		if(op=="+") 
			FLagAdd=true;
		else if(op=="-") 
			FLagDel=true;
		else if(op=="*") 
			FLagMult=true;
		else if(op=="/") 
			FLagDiv=true;
		}
		
		//Fonction qui gère les différents boutons des différentes opérations pour les hexadécimaux
		private void OperationHex(String op) {
			valeur1=Integer.parseInt(res.getText(),16); //Conversion du getText() du Hexadecimal en Décimal
			res.setText("");
		if(op=="+") 
			FLagAdd=true;
		else if(op=="-") 
			FLagDel=true;
		else if(op=="*") 
			FLagMult=true;
		else if(op=="/") 
			FLagDiv=true;
		}
		
		//Fonction du bouton "=" des nombres décimaux selon les opérations
		private void EqualDec(String op) {
			if(op=="+") {
				Total = valeur1 + valeur2;
				res.setText(Total+"");
				FLagAdd=false; //Désactivation de "FlagAdd" pour le réutiliser si on clique sur "+" une autre fois 
			}
			else if(op=="-") {
				Total = valeur1 - valeur2;
				res.setText(Total+"");
				FLagDel=false;
			}
			else if(op=="*") {
				Total = valeur1 * valeur2;
				res.setText(Total+"");
				FLagMult=false;
			}
			else if(op=="/") {
				if(valeur2!=0) {
					Total = (int)(valeur1/valeur2);
					res.setText(Total+"");
					FLagDiv=false;					
				}
				else {
					res.setText("Maths Error"); //gérer l'erreur de la division par 0!
					FLagDiv=false;
				}
			}
		}
		
		//Fonction du bouton "=" des nombres binaires selon les opérations
		private void EqualBin(String op) {
			if(op=="+") {
				Total = valeur1 + valeur2;
				res.setText(Integer.toBinaryString(Total)); //Affichage du résultat convertit du INT au Binaire
				FLagAdd=false; //Idem que pour EqualDec
			}
			else if(op=="-") {
				Total = valeur1 - valeur2;
				res.setText(Integer.toBinaryString(Total));
				FLagDel=false;
			}
			else if(op=="*") {
				Total = valeur1 * valeur2;
				res.setText(Integer.toBinaryString(Total));
				FLagMult=false;
			}
			else if(op=="/") {
				if(valeur2!=0) {
					Total = (int)(valeur1/valeur2);
					res.setText(Integer.toBinaryString(Total));
					FLagDiv=false;					
				}
				else {
					res.setText("Maths Error"); //Idem pour EqualDec
					FLagDiv=false;
				}
			}
		}

		//Fonction du bouton "=" des nombres hexadécimaux selon les opérations
		private void EqualHex(String op) {
			if(op=="+") {
				Total = valeur1 + valeur2;
				res.setText((Integer.toHexString(Total)).toUpperCase()); //Affichage convertit du INT au Hex
				FLagAdd=false; //IDem que pour EqualDec
			}
			else if(op=="-") {
				Total = valeur1 - valeur2;
				res.setText((Integer.toHexString(Total)).toUpperCase());
				FLagDel=false;
			}
			else if(op=="*") {
				Total = valeur1 * valeur2;
				res.setText((Integer.toHexString(Total)).toUpperCase());
				FLagMult=false;
			}
			else if(op=="/") {
				if(valeur2!=0) {
					Total = (int)(valeur1/valeur2);
					res.setText((Integer.toHexString(Total)).toUpperCase());
					FLagDiv=false;					
				}
				else {
					res.setText("Maths Error");
					FLagDiv=false;
				}
			}
		}
		
		//Génération des boutons pour les nombres décimaux
		public void ButtonDecimal() {
			n0.setEnabled(true);
			n1.setEnabled(true);
			n2.setEnabled(true);
			n3.setEnabled(true);
			n4.setEnabled(true);
			n5.setEnabled(true);
			n6.setEnabled(true);
			n7.setEnabled(true);
			n8.setEnabled(true);
			n9.setEnabled(true);
			A.setEnabled(false);
			B.setEnabled(false);
			C.setEnabled(false);
			D.setEnabled(false);
			E.setEnabled(false);
			F.setEnabled(false);
		}
		//Génération des boutons pour les nombres binaires
		public void ButtonBinaire() {
			n0.setEnabled(true);
			n1.setEnabled(true);
			n2.setEnabled(false);
			n3.setEnabled(false);
			n4.setEnabled(false);
			n5.setEnabled(false);
			n6.setEnabled(false);
			n7.setEnabled(false);
			n8.setEnabled(false);
			n9.setEnabled(false);
			A.setEnabled(false);
			B.setEnabled(false);
			C.setEnabled(false);
			D.setEnabled(false);
			E.setEnabled(false);
			F.setEnabled(false);
		}
		//Génération des boutons pour les nombres hexadécimaux
		public void ButtonHexadecimal() {
			n0.setEnabled(true);
			n1.setEnabled(true);
			n2.setEnabled(true);
			n3.setEnabled(true);
			n4.setEnabled(true);
			n5.setEnabled(true);
			n6.setEnabled(true);
			n7.setEnabled(true);
			n8.setEnabled(true);
			n9.setEnabled(true);
			A.setEnabled(true);
			B.setEnabled(true);
			C.setEnabled(true);
			D.setEnabled(true);
			E.setEnabled(true);
			F.setEnabled(true);
		}
		
		//Déclaration des variables qu'on va utiliser pour les différentes conversions
		int ConvertDec;
		String convertHex;
	
		public void actionPerformed(ActionEvent e) {
		
		if(genre.getSelection().getActionCommand().equals("dec")){ 
			ButtonDecimal(); //Affichage des boutons appropriés
			FlagDec=true; //Activation du drapeau Déc pour savoir qu'on est au "Décimaux"
			if(e.getSource()==n0) res.setText(res.getText()+"0"); //Affichage
			if(e.getSource()==n1) res.setText(res.getText()+"1");
			if(e.getSource()==n2) res.setText(res.getText()+"2");
			if(e.getSource()==n3) res.setText(res.getText()+"3");
			if(e.getSource()==n4) res.setText(res.getText()+"4");
			if(e.getSource()==n5) res.setText(res.getText()+"5");
			if(e.getSource()==n6) res.setText(res.getText()+"6");
			if(e.getSource()==n7) res.setText(res.getText()+"7");
			if(e.getSource()==n8) res.setText(res.getText()+"8");
			if(e.getSource()==n9) res.setText(res.getText()+"9");
			if(e.getSource()==clear) {
				res.setText("");
				Total=0; //Initialiser avec Clear "c"
			}
			if(e.getSource()==back) {
				res.setText(res.getText().substring(0, res.getText().length() - 1)); //Supression du dernier carac
			}
			if(e.getSource()==add) {
				OperationDec("+"); //Appel aux différentes fonctions
			}
			if(e.getSource()==del) {	
				OperationDec("-");		
			}
			if(e.getSource()==mult) {
				OperationDec("*");
			}
			if(e.getSource()==div) {
				OperationDec("/");
			}	
			if(e.getSource()==egale) {
				valeur2=Integer.parseInt(res.getText()); //Convertir le getText() (String -> INT) et l'affecter à valeur2
				if(FLagAdd)
					EqualDec("+"); //Appel aux fonctions EqualDec
				else if(FLagDel)
					EqualDec("-");
				else if(FLagMult)
					EqualDec("*");
				else if(FLagDiv)
					EqualDec("/");
			}	
			
			//Bloc pour la conversion du Déc aux Hex ou Bin
			if(FlagBin) //Pour savoir qui est le dernier bouton "genre" activé
			{
				ConvertDec=Integer.parseInt(res.getText(),2);
				res.setText(String.valueOf(ConvertDec)); //Conversion du Binaire en Décimal
				FlagBin=false; //Désactivation du drapeau 
			}		
			if(FlagHex) //Idem pour Hex -> Déc
			{
				convertHex=res.getText(); //récupération de la chaine en héx
				ConvertDec=Integer.parseInt(res.getText(),16);
				res.setText(String.valueOf(ConvertDec));
				FlagHex=false;
			}
	    }
					
		else if(genre.getSelection().getActionCommand().equals("bin")){
				ButtonBinaire(); //Appel aux boutons des Binaires
				FlagBin=true; //Lever le drapeau Binaire et marquer da présence
				if(e.getSource()==n0) res.setText(res.getText()+"0");
				if(e.getSource()==n1) res.setText(res.getText()+"1");
				if(e.getSource()==clear) {
					res.setText("");
					Total=0;
				}
				if(e.getSource()==back) {
					res.setText(res.getText().substring(0, res.getText().length() - 1));
				}
				if(e.getSource()==add) {
					OperationBin("+");
				}
				if(e.getSource()==del) {	
					OperationBin("-");
				}
				if(e.getSource()==mult) {
					OperationBin("*");
				}
				if(e.getSource()==div) {
					OperationBin("/");
				}	
				if(e.getSource()==egale) {
					valeur2=Integer.parseInt(res.getText(),2); //Conversion du getText() du Bin -> INT pour pouvoir l'utiliser aux diff opérations 
					if(FLagAdd)
						EqualBin("+");
					else if(FLagDel)
						EqualBin("-");
					else if(FLagMult)
						EqualBin("*");
					else if(FLagDiv)
						EqualBin("/");
				}	
				
				//IDem que pour la conversion Déc
				if(FlagDec) {
					ConvertDec=Integer.parseInt(res.getText());
					res.setText(Integer.toBinaryString(ConvertDec));
					FlagDec=false;
				}
				else if(FlagHex) {
					ConvertDec=Integer.parseInt(res.getText(),16); 
					res.setText(Integer.toBinaryString(ConvertDec));
					FlagHex=false;
				}
			}
		
		//IDem que pour Déc & Bin
		else if(genre.getSelection().getActionCommand().equals("hex")){
			FlagHex=true;
			ButtonHexadecimal();
			if(e.getSource()==A) res.setText(res.getText()+"A");
			if(e.getSource()==B) res.setText(res.getText()+"B");
			if(e.getSource()==C) res.setText(res.getText()+"C");
			if(e.getSource()==D) res.setText(res.getText()+"D");
			if(e.getSource()==E) res.setText(res.getText()+"E");
			if(e.getSource()==F) res.setText(res.getText()+"F");
			if(e.getSource()==n0) res.setText(res.getText()+"0");
			if(e.getSource()==n1) res.setText(res.getText()+"1");
			if(e.getSource()==n2) res.setText(res.getText()+"2");
			if(e.getSource()==n3) res.setText(res.getText()+"3");
			if(e.getSource()==n4) res.setText(res.getText()+"4");
			if(e.getSource()==n5) res.setText(res.getText()+"5");
			if(e.getSource()==n6) res.setText(res.getText()+"6");
			if(e.getSource()==n7) res.setText(res.getText()+"7");
			if(e.getSource()==n8) res.setText(res.getText()+"8");
			if(e.getSource()==n9) res.setText(res.getText()+"9");
			if(e.getSource()==clear) {
				res.setText("");
				Total=0;
			}
			if(e.getSource()==back) {
				res.setText(res.getText().substring(0, res.getText().length() - 1));
			}
			if(e.getSource()==add) {
				OperationHex("+");
			}
			if(e.getSource()==del) {	
				OperationHex("-");
			}
			if(e.getSource()==mult) {
				OperationHex("*");
			}
			if(e.getSource()==div) {
				OperationHex("/");
			}	
			if(e.getSource()==egale) {
				valeur2=Integer.parseInt(res.getText(),16);  //Conversion du getText() du Hex -> INT
				if(FLagAdd)
					EqualHex("+");
				else if(FLagDel)
					EqualHex("-");
				else if(FLagMult)
					EqualHex("*");
				else if(FLagDiv)
					EqualHex("/");
			}		
			//Idem pour l'Hex
			if(FlagDec) {
				ConvertDec=Integer.parseInt(res.getText());
				res.setText((Integer.toHexString(ConvertDec)).toUpperCase());
				FlagDec=false;
			}
			else if(FlagBin) {
				ConvertDec=Integer.parseInt(res.getText(),2);
				res.setText((Integer.toHexString(ConvertDec)).toUpperCase());
				FlagBin=false;
			}
		}
		
		
			
	}
		
		
		
		
		//Appel à la fonction main et l'utilisation des différentes fonctions IHM pour la gestion de la fenêtre
		public static void main(String[] args) {
			CalculConvert c = new CalculConvert();
			c.setVisible(true);
			c.setTitle("Calcultrice");
			c.setSize(330, 350);
			c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			c.setLocationRelativeTo(null);
		}

	
	
	
	
	
}
