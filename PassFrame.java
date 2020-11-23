package Projekt;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

//-------------your next frame after you signed-in-------------------
class AfterSign extends Frame {

	AfterSign(String string) {
		super(string);
		setLayout(null);
		setSize(750,1050);	//width,height
		setFont(new Font("serif",Font.BOLD,30));

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	}
}
//----------sign-in page/frame------------------------
class Pass extends Frame implements ActionListener {
	Image profilePic;
	Button loginB;
	Label UserL, PassL;
	TextField ta1, ta2;
	AfterSign as;
	Pass(String s, Image profilePic){
		
		super(s);
		setLayout(null);
		setSize(750,1050);	//width,height
		setFont(new Font("serif",Font.BOLD,30));

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		this.profilePic = profilePic;
		
		UserL = new Label("Username:");
		UserL.setBounds(100, 500, 150, 40);
		ta1 = new TextField();
		ta1.setBounds(250, 500, 300, 40);
		
		PassL = new Label("Password:");
		PassL.setBounds(100, 550, 150, 40);
		ta2 = new TextField();
		ta2.setEchoChar('*');
		ta2.setBounds(250, 550, 300, 40);
				
		loginB = new Button("LOGIN");
		loginB.setBounds(250, 650, 200, 40);
		
		
		add(UserL);
		add(ta1);
		
		add(PassL);
		add(ta2);
		
		add(loginB);
		
		loginB.addActionListener(this);
	}
	public void paint(Graphics g) {
		
		g.drawImage(profilePic,200, 100,this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String username, password;

		username = "YourName";
		password = "YourPassword";
		String u, p;
		u = ta1.getText();
		p = ta2.getText();
		
		as =  new AfterSign("Successful Login"); 
		if(e.getSource() == loginB) {
			if(ta1.getText().isEmpty() || ta2.getText().isEmpty()){
				JOptionPane.showMessageDialog(null, "Fill Empty Fields!");
			}
			else if(u.contains(username) && p.contains(password)) {
				JOptionPane.showMessageDialog(null,"Successful Login!");
				dispose();
				as.setVisible(true);	
			}else {
				JOptionPane.showMessageDialog(null,"Failed Login!");
			}
		}		
	}
}
//-------------Applet-------------------
//---------------start-------------
public class PassFrame extends Applet implements ActionListener {
	
	Image profilePic;
	Button signB;
	Pass p;
	public void init() {
		
		signB = new Button("Open");
		
		//profile-pic scaled 
		profilePic = getImage(getDocumentBase(),"login.jpg").getScaledInstance(300, 300, Image.SCALE_AREA_AVERAGING);
		
		add(signB);
		
		signB.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		p = new Pass("Sign-in", profilePic);
		if(e.getSource() == signB) {
			p.setVisible(true);
		}
	}
}
