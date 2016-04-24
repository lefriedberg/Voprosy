
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Vopros {
	private JFrame frame;
	private JPanel searching;
	private JPanel adding;
	private JPanel addingbuttons;
	private JButton er;
	private JButton gram;
	private JFrame gramm;
	private JButton add;
	private JTextField query;
	private JTextField answer;
	private JTextField english;
	private JTextField larusse;
	private AVLTree<Word, Grammar> dictionaryer;
	private AVLNode<Word, Grammar> curr;
	private JButton Noun;
	private JButton Adjective;
	private JButton Preposition;
	private JButton Verb;
	private JTextField h;
	Grammar g;
	JPanel p = new JPanel();
	JTextField ya = new JTextField("Я");
	JTextField ty = new JTextField("Ты");
	JTextField oni = new JTextField("Они");
	JButton irregular = new JButton("Irregular Conjugation");
	JButton hard = new JButton("Hard");
	JButton soft = new JButton("Soft");
	JButton gen = new JButton("Genitive");
	JButton dat = new JButton("Dative");
	JButton acc = new JButton("Accusitave");
	JButton ins = new JButton("Instrumental");
	JButton pre = new JButton("Prepositional");
	JPanel awfulpanel = new JPanel();
	JButton submit = new JButton("Submit!");
	JButton first = new JButton("First");
	JButton second = new JButton("Second");
	JButton m1 = new JButton("1. Masculine");
	JButton f2 = new JButton("2. Feminine");
	private Word a;
	
	public Vopros(){
		searching = new JPanel();
		adding = new JPanel();
		addingbuttons = new JPanel();
		er = new JButton("Translate");
		gram = new JButton("Grammar!");
		gramm = new JFrame("Grammar");
		add = new JButton("Add to Dictionary");
		query = new JTextField("Вопрос");
		answer = new JTextField("Answer!");
		english = new JTextField("English");
		larusse = new JTextField("Русский");
		er.addMouseListener(new MouseHandle());
		gram.addMouseListener(new MouseHandle());
		add.addMouseListener(new MouseHandle());
		
		Word w = new Word("Question", "Вопрос");
		POSNoun wa = new POSNoun(w);
		wa.setGender(true);
		wa.setSign(true);
		dictionaryer = new AVLTree<Word, Grammar>(w, wa);
		
		
		Noun = new JButton("Noun");
		Adjective = new JButton("Adjective");
		Preposition = new JButton("Preposition");
		Verb = new JButton("Verb");
		Noun.addMouseListener(new MouseHandle());
		Adjective.addMouseListener(new MouseHandle());
		Preposition.addMouseListener(new MouseHandle());
		Verb.addMouseListener(new MouseHandle());
		g = null;
		irregular.addMouseListener(new MouseHandle());
		hard.addMouseListener(new MouseHandle());
		soft.addMouseListener(new MouseHandle());
		gen.addMouseListener(new MouseHandle());
		dat.addMouseListener(new MouseHandle());
		acc.addMouseListener(new MouseHandle());
		ins.addMouseListener(new MouseHandle());
		pre.addMouseListener(new MouseHandle());
		awfulpanel.setLayout(new GridLayout(3,1));
		awfulpanel.add(ya); awfulpanel.add(ty); awfulpanel.add(oni);
		submit.addMouseListener(new MouseHandle());
		first.addMouseListener(new MouseHandle());
		second.addMouseListener(new MouseHandle());
		m1.addMouseListener(new MouseHandle());
		f2.addMouseListener(new MouseHandle());
	}
	
	
	private JFrame createGUI(){
		frame = new JFrame();
		frame.setLayout(new GridLayout(2,1,10,10));;
		frame.add(searching);
			searching.setLayout(new BorderLayout());
			searching.add(query, BorderLayout.PAGE_START);
			searching.add(er, BorderLayout.CENTER);
			searching.add(gram, BorderLayout.LINE_END);
			searching.add(answer, BorderLayout.PAGE_END);
		frame.add(adding);
			adding.setLayout(new BorderLayout());
			adding.add(add, BorderLayout.PAGE_END);
			adding.add(addingbuttons, BorderLayout.CENTER);
			addingbuttons.setLayout(new GridLayout(1,2));
			addingbuttons.add(english);
			addingbuttons.add(larusse);
		return frame;
	}
	
	public void gwindow(boolean a){
		gramm = new JFrame();
		gramm.setSize(400,400);
		gramm.setVisible(true);
		if (a){
			gramm.setLayout(new GridLayout(2, 2));
			gramm.add(Noun);
			gramm.add(Adjective);
			gramm.add(Preposition);
			gramm.add(Verb);
		}else{
			gramm.add(h);
			h.setText(curr.element().display(curr.key().R() + ""));
		}
	}
	
	
	public static void main(String[] args){
		Vopros app = new Vopros();
		JFrame window = app.createGUI();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(400, 200);
		window.setVisible(true);
	}
	
	
	/*MouseListener implemented in part by Robo Moloso.
	 * Gridbaglayout suggested by Ruby Malusa to replace awful awful GUI
	 * And promptly dismissed
	 */
	private class MouseHandle implements MouseListener { 

		public void mouseClicked(MouseEvent e) {
			Object src = e.getSource();
			if (src instanceof JButton){
				JButton b = (JButton) src;
				
				
				
				if (b.equals(er)){
					System.out.println("ER");
					if(dictionaryer.find(new Word(query.getText(), null)) != null){
							System.out.println("ER2");
							g = dictionaryer.find(new Word(query.getText(), null));
							answer.setText(g.getWord().R());
					}		
				
				}else if(b.equals(gram)){
					gwindow(false);
				}
				else r: if(b.equals(add)){
					if(english.getText() == "" || larusse.getText() == ""){
						english.setText("Error! Empty Field!");
						break r;
					}
					a = new Word(english.getText(), larusse.getText());
					gwindow(true);
				}else if(b.equals(Noun)){
					gramm.setVisible(false);
					gramm = new JFrame();
					gramm.setSize(400,400);
					gramm.setVisible(true);
					g = new POSNoun(a);
					gramm.setLayout(new BorderLayout());
					gramm.add(p, BorderLayout.CENTER);
					gramm.add(submit, BorderLayout.PAGE_END);
					p.setLayout(new GridLayout(2, 2));
					p.add(hard);
					p.add(soft);
					p.add(m1);
					p.add(f2);
					gramm.repaint();
				}else if(b.equals(Adjective)){
					gramm.setVisible(false);
					gramm = new JFrame();
					gramm.setSize(400,400);
					gramm.setVisible(true);
					g = new POSNoun(a);
					gramm.setLayout(new BorderLayout());
					gramm.add(p, BorderLayout.CENTER);
					gramm.add(submit, BorderLayout.PAGE_END);
					p.setLayout(new GridLayout(2,1));
					p.add(hard);
					p.add(soft);
					gramm.repaint();
				}else if(b.equals(Verb)){
					gramm.setVisible(false);
					gramm = new JFrame();
					gramm.setSize(400,400);
					gramm.setVisible(true);
					gramm.setLayout(new BorderLayout());
					gramm.add(p, BorderLayout.CENTER);
					gramm.add(submit, BorderLayout.PAGE_END);
					g = new POSVerb(a);
					p.setLayout(new GridLayout(3,2));
					p.add(soft);
					p.add(hard);
					p.add(first);
					p.add(second);
					p.add(awfulpanel);
					p.add(irregular);
					gramm.repaint();
				}else if(b.equals(Preposition)){
					gramm.setVisible(false);
					gramm = new JFrame();
					gramm.setSize(400,400);
					gramm.setVisible(true);
					g = new POSPrep(a);
					gramm.setLayout(new BorderLayout());
					gramm.add(p, BorderLayout.CENTER);
					gramm.add(submit, BorderLayout.PAGE_END);
					p.setLayout(new GridLayout(5,1));
					p.add(gen);
					p.add(dat);
					p.add(acc);
					p.add(ins);
					p.add(pre);
					gramm.repaint();
				}else if(b.equals(hard) || b.equals(soft)){
					if(b.equals(hard))
						g.setSign(true);
					else
						g.setSign(false);
				}else if(b.equals(gen) || b.equals(dat) || b.equals(acc) || b.equals(ins) || b.equals(pre)){
					if(b.equals(gen)){
						g.setCase(1);
					}else if(b.equals(dat)){
						g.setCase(2);
					}else if(b.equals(acc)){
						g.setCase(3);
					}else if(b.equals(ins)){
						g.setCase(4);
					}else if(b.equals(pre)){
						g.setCase(5);
					}
				}else if(b.equals(first) || b.equals(second)|| b.equals(irregular)){
					if(b.equals(first)){
						g.conjugate(true, true);
					}else if(b.equals(second)){
						g.conjugate(true, false);
					}else{
						g.conjugate(false, false);
						g.irco(ya.getText(), ty.getText(), oni.getText());
					}
				}else if(b.equals(submit)){
					if(a == null || g == null){
						System.out.println("error!");
					}
					System.out.print("SUBMIT");
					dictionaryer.insert(a, g);
					a = null;
					g = null;
					//gramm.setVisible(false);
				}else if(b.equals(m1)){
					g.setGender(true); 
				}else if(b.equals(f2)){
					g.setGender(false); 
				}
			}
		}

		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {} 
	}
}
