import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.sql.*;

import javax.swing.*;



public class InterfataPoli extends MDAJDBC{
	
	Connection connection= null;
	//Frame-ul principal, Policlinica
	private JFrame Poli = new JFrame("Policlinica");
	private JFrame Medic = new JFrame("Medic");
	private JFrame Asistent = new JFrame("Asistent");
	private JFrame RUmane = new JFrame("Resurse Umane");
	private JFrame Financiar = new JFrame("Contabil Financiar");
	private JFrame Receptioner = new JFrame("Receptioner");
	private JFrame Admin = new JFrame("Administrator");
	private JFrame SuperAdmin = new JFrame("SuperAdministrator");
	private JPanel pan_poli = new JPanel();
	private JLabel user = new JLabel("Utilizator");
	private JLabel pass = new JLabel("Parola");
	private JTextField poli_user = new JTextField(30);
	private JTextField poli_pass = new JTextField(30);
	private JButton Autentificare = new JButton("Autentificare");
	
	//Asistent
	private JPanel pan_asistenta=new JPanel();
	private JButton Delogare = new JButton("Delogare");
	private JButton Viz_pacienti_prog = new JButton("Vizualizare Pacienti Programati");
	private JButton Scriere_Rap_Medical = new JButton("Vizualizare Programari");
	
	//Medic
	private JPanel pan_medic=new JPanel();
	//private JButton Viz_pacienti_prog = new JButton("Vizualizare Pacienti Programati");
	//private JButton Scriere_Rap_Medical = new JButton("Intocmire Raport");

	//Receptioner
	private JPanel pan_receptioner=new JPanel();
    private JButton Adaugare_Pacient=new JButton("Inregistrare Pacient");
    private JPanel pan_inregistrare_pacient=new JPanel();
	private JFrame Inregistrare_pac=new JFrame();
    private JButton Inregistreaza= new JButton("Inregistreaza!");	   
    private JLabel Nume_pac=new JLabel("Nume pacient: ");
    private JLabel Prenume_pac= new JLabel("Prenume pacient: ");
    private JTextField Nume_pacient= new JTextField(20);
    private JTextField Prenume_pacient= new JTextField(20);
    private JButton Creare_Prog=new JButton("Creare Programare");
    private JFrame Creeaza_prog=new JFrame();
    private JPanel pan_creeaza_pacient=new JPanel();
    private JButton Creeaza= new JButton("Finalizare!");
    private JLabel Id_rec=new JLabel("Id receptioner: ");
    private JLabel Id_pacient= new JLabel("Id pacient: ");
    private JLabel Data_calendaristica=new JLabel("Data calendaristica: ");
    private JLabel Nume_medic= new JLabel("Nume medic: ");
    private JLabel Durata_consul=new JLabel("Durata consultatiei: ");
    private JLabel Ora_consul= new JLabel("Ora programarii: ");
    private JTextField Id_rec_text= new JTextField(10);
    private JTextField Id_pacient_text= new JTextField(10);
    private JTextField Data_calendaristica_text= new JTextField(10);
    private JTextField  Nume_medic_text= new JTextField(10);
    private JTextField Durata_consul_text= new JTextField(10);
    private JTextField Ora_consul_text= new JTextField(10);
    
   //ResurseUmane
    private JPanel pan_resurse_umane=new JPanel();
    private JButton Vizualizare_Orar_Angajat= new JButton("Vizualizare Orar Angajat");
    private JButton Vizualizare_Utilizatori= new JButton("Listare Utilizatori");
    private JButton Vizualizare_Orar_Unitate= new JButton("Vizualizare Orar Unitate");
    private JFrame Orar_Angajat = new JFrame();
    private JFrame Orar_Unitate= new JFrame();
    private JPanel pan_orar_angajat=new JPanel();
    private JPanel pan_orar_unitate=new JPanel();
    private JLabel Orar_Angajat_label=new JLabel("CNP Utilizator:");
    private JLabel Orar_Unitate_label= new JLabel("Id unitate: ");
    private JTextField Orar_Angajat_text= new JTextField(20);
    private JTextField Orar_Unitate_text= new JTextField(20);
    private JButton Cauta_Util= new JButton("Cauta Utilizator ");
    private JButton Cauta_Unitate= new JButton("Cauta Unitate ");
    
    
    // Financiar
    private JPanel pan_financiar=new JPanel();
    private JButton Vizualizare_Cheltuieli=new JButton("Vizualizare Cheltuieli Unitate");
    private JButton Vizualizare_Salarii=new JButton("Vizualizare Salariu Angajat");
    private JFrame Vizualizare_Cheltuieli_frame = new JFrame();
    private JFrame Vizualizare_Salarii_frame = new JFrame();
    private JPanel pan_Vizualizare_Cheltuieli=new JPanel();
    private JPanel pan_Vizualizare_Salarii=new JPanel();
    private JLabel Vizualizare_Cheltuieli_label=new JLabel("Id unitate: ");
    private JLabel Vizualizare_Salarii_label= new JLabel("CNP Utilizator: ");
    private JTextField Vizualizare_Cheltuieli_text= new JTextField(20);
    private JTextField Vizualizare_Salarii_text= new JTextField(20);
    private JButton Cauta_Cheltuiala= new JButton("Cautare ");
    private JButton Cauta_Salariu= new JButton("Cautare ");
    
     //Admin, SuperAdmin
    private JPanel pan_admin=new JPanel();
    private JPanel pan_super_admin= new JPanel();
   //private JButton Vizualizare_Utilizatori= new JButton("Listare Utilizatori");
	public static void main(String[] args) {
		 try {
		        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/policlinica?user=root&password=");
		         //insertStatement = connection.createStatement();
		        // insertStatement.execute("insert into pacient(id_pacient,nume) values (200,'Agardinitei')");
		         //sq1="insert into pacient(id_pacient,nume) values (201,'Agardinitei')";
		         //doQuery(sq1);
		     }
		     catch(SQLException sqlex) {
		         System.err.println("An SQL Exception occured. Details are provided below:");
		         sqlex.printStackTrace(System.err);
		     }
			 
	}

	public void go() {
		Poli.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Poli.setSize(400, 400);
		Poli.setVisible(true);
		Adaugare_Pacient.addActionListener(new InregistrarePacientListener());
		Delogare.addActionListener(new DelogareListener());
		Autentificare.addActionListener(new LogareListener());
		Inregistreaza.addActionListener(new InregistreazaListener());
		Creare_Prog.addActionListener(new CreeazaProgramareListener());
		Creeaza.addActionListener(new CreeazaListener());
		Vizualizare_Utilizatori.addActionListener(new ListareUtilizatoriListener());
		Vizualizare_Orar_Angajat.addActionListener(new CautareUtilizatorListener());
		Vizualizare_Orar_Unitate.addActionListener(new CautareUnitateListener());
		Cauta_Util.addActionListener(new CautaUtilizatorListener());
		Cauta_Unitate.addActionListener(new CautaUnitateListener());
		Viz_pacienti_prog.addActionListener(new VizualizarePacientiListener());
		Vizualizare_Cheltuieli.addActionListener(new VizualizareCheltuieliListener());
		Vizualizare_Salarii.addActionListener(new VizualizareSalariiListener());
		Cauta_Cheltuiala.addActionListener(new VizualizareCheltuialaListener());
		Cauta_Salariu.addActionListener(new VizualizareSalariuListener());
		Scriere_Rap_Medical.addActionListener(new VizualizareProgramareListener());
		pan_poli.setLayout(new FlowLayout());
		pan_poli.setBackground(Color.RED);
		pan_poli.add(user);
		pan_poli.add(poli_user);
		pan_poli.add(pass);
		pan_poli.add(poli_pass);
		pan_poli.add(Autentificare);
		Poli.setContentPane(pan_poli);
		Poli.pack();
	}

	private String getUserInput() {
		return poli_user.getText();
	}

	private String getPassInput() {
		return poli_pass.getText();
	}
	
	
	private String getNumeInput() {
		return Nume_pacient.getText();
	}

	private String getPrenumeInput() {
		return Prenume_pacient.getText();
	}
	
	
	private String getIdRecInput() {
		return Id_rec_text.getText();
	}

	private String getIdPacInput() {
		return Id_pacient_text.getText();
	}
	
	
	private String getDataCalInput() {
		return Data_calendaristica_text.getText();
	}

	private String getNumeMedicInput() {
		return Nume_medic_text.getText();
	}
	
	
	private String getDurataConInput() {
		return Durata_consul_text.getText();
	}

	private String getOraConInput() {
		return  Ora_consul_text.getText();
	}

	private String getOrarUtilizator() {
		return Orar_Angajat_text.getText();
	}
	
	private String getOrarUnitate() {
		return Orar_Unitate_text.getText();
	}
	
	private String getCheltuialaUnitate() {
		return Vizualizare_Cheltuieli_text.getText();
	}
	
	private String getSalariuAngajat() {
		return Vizualizare_Salarii_text.getText();
	}
	
	
	public class LogareListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String userInput = "";
			String passInput = "";
			userInput = getUserInput();
			passInput = getPassInput();
			// System.out.println(userInput+ " " + passInput);
			if (userInput.equals("Asistent") && passInput.equals("nurse")) {

		Asistent.setSize(400, 400);
		Asistent.setVisible(true);
		Poli.setVisible(false);
				pan_asistenta.setLayout(new BoxLayout(pan_asistenta, BoxLayout.Y_AXIS));
				pan_asistenta.setBackground(Color.YELLOW);
		Viz_pacienti_prog.setAlignmentX(Component.CENTER_ALIGNMENT);
				pan_asistenta.add( Box.createRigidArea(new Dimension(0,50)) );
				pan_asistenta.add(Viz_pacienti_prog);
		Scriere_Rap_Medical.setAlignmentX(Component.CENTER_ALIGNMENT);
				pan_asistenta.add( Box.createRigidArea(new Dimension(0,20)) );
				pan_asistenta.add(Scriere_Rap_Medical);
		Delogare.setAlignmentX(Component.CENTER_ALIGNMENT);
				pan_asistenta.add( Box.createRigidArea(new Dimension(0,200)) );
				pan_asistenta.add(Delogare);
		Asistent.add(pan_asistenta);

			} else if (userInput.equals("Medic") && passInput.equals("doc")) {

		Medic.setSize(400, 400);
		Medic.setVisible(true);
		Poli.setVisible(false);
				pan_medic.setLayout(new BoxLayout(pan_medic, BoxLayout.Y_AXIS));
				pan_medic.setBackground(Color.YELLOW);
		Viz_pacienti_prog.setAlignmentX(Component.CENTER_ALIGNMENT);
				pan_medic.add( Box.createRigidArea(new Dimension(0,50)) );
				pan_medic.add(Viz_pacienti_prog);
		Scriere_Rap_Medical.setAlignmentX(Component.CENTER_ALIGNMENT);
				pan_medic.add( Box.createRigidArea(new Dimension(0,20)) );
				pan_medic.add(Scriere_Rap_Medical);
		Delogare.setAlignmentX(Component.CENTER_ALIGNMENT);
				pan_medic.add( Box.createRigidArea(new Dimension(0,200)) );
				pan_medic.add(Delogare);
		Medic.add(pan_medic);
				
			} else if (userInput.equals("RUmane") && passInput.equals("hr")) {

		RUmane.setSize(400,500);
		RUmane.setVisible(true);
		Poli.setVisible(false);
				pan_resurse_umane.setLayout(new BoxLayout(pan_resurse_umane, BoxLayout.Y_AXIS));
				pan_resurse_umane.setBackground(Color.BLUE);
		Vizualizare_Orar_Angajat.setAlignmentX(Component.CENTER_ALIGNMENT);
				pan_resurse_umane.add( Box.createRigidArea(new Dimension(0,50)) );
				pan_resurse_umane.add(Vizualizare_Orar_Angajat);
		Vizualizare_Utilizatori.setAlignmentX(Component.CENTER_ALIGNMENT);
				pan_resurse_umane.add( Box.createRigidArea(new Dimension(0,20)) );
				pan_resurse_umane.add(Vizualizare_Utilizatori);
		Vizualizare_Orar_Unitate.setAlignmentX(Component.CENTER_ALIGNMENT);
				pan_resurse_umane.add( Box.createRigidArea(new Dimension(0,20)) );
				pan_resurse_umane.add(Vizualizare_Orar_Unitate);
		Delogare.setAlignmentX(Component.CENTER_ALIGNMENT);
				pan_resurse_umane.add( Box.createRigidArea(new Dimension(0,200)) );
				pan_resurse_umane.add(Delogare);
		RUmane.add(pan_resurse_umane);
				

			} else if (userInput.equals("Financiar") && passInput.equals("money")) {

		Financiar.setSize(400, 400);
		Financiar.setVisible(true);
		Poli.setVisible(false);
		        pan_financiar.setBackground(Color.GREEN);
				pan_financiar.setLayout(new BoxLayout(pan_financiar, BoxLayout.Y_AXIS));
		Vizualizare_Cheltuieli.setAlignmentX(Component.CENTER_ALIGNMENT);
				pan_financiar.add( Box.createRigidArea(new Dimension(0,50)) );
				pan_financiar.add(Vizualizare_Cheltuieli);
		Vizualizare_Salarii.setAlignmentX(Component.CENTER_ALIGNMENT);
				pan_financiar.add( Box.createRigidArea(new Dimension(0,20)) );
				pan_financiar.add( Vizualizare_Salarii);
		Delogare.setAlignmentX(Component.CENTER_ALIGNMENT);
				pan_financiar.add( Box.createRigidArea(new Dimension(0,200)) );
				pan_financiar.add(Delogare);
		Financiar.add(pan_financiar);
				
				
			} else if (userInput.equals("Receptioner") && passInput.equals("hello")) {

				Receptioner.setSize(400, 400);
				Receptioner.setVisible(true);
				Poli.setVisible(false);
                    pan_receptioner.setBackground(Color.DARK_GRAY);
					pan_receptioner.setLayout(new BoxLayout(pan_receptioner, BoxLayout.Y_AXIS));
		Creare_Prog.setAlignmentX(Component.CENTER_ALIGNMENT);
					pan_receptioner.add( Box.createRigidArea(new Dimension(0,50)) );
					pan_receptioner.add(Creare_Prog);
		Adaugare_Pacient.setAlignmentX(Component.CENTER_ALIGNMENT);
					pan_receptioner.add( Box.createRigidArea(new Dimension(0,20)) );
					pan_receptioner.add(Adaugare_Pacient);
		Delogare.setAlignmentX(Component.CENTER_ALIGNMENT);
			        pan_receptioner.add( Box.createRigidArea(new Dimension(0,200)) );
			        pan_receptioner.add(Delogare);
		Receptioner.add(pan_receptioner);
				
			} else if (userInput.equals("Admin") && passInput.equals("Admin")) {
		Admin.setSize(400, 400);
		Admin.setVisible(true);
		Poli.setVisible(false);
		pan_admin.setBackground(Color.BLACK);
		// private JButton Vizualizare_Utilizatori= new JButton("Listare Utilizatori");
				pan_admin.setLayout(new BoxLayout(pan_admin, BoxLayout.Y_AXIS));
		Vizualizare_Utilizatori.setAlignmentX(Component.CENTER_ALIGNMENT);
				pan_admin.add( Box.createRigidArea(new Dimension(0,50)) );
				pan_admin.add(Vizualizare_Utilizatori);
		Delogare.setAlignmentX(Component.CENTER_ALIGNMENT);
				pan_admin.add( Box.createRigidArea(new Dimension(0,200)) );
				pan_admin.add(Delogare);
		Admin.add(pan_admin);
				
				
			} else if (userInput.equals("SuperAdmin") && passInput.equals("SuperAdmin")) {
				
		SuperAdmin.setSize(400, 400);
		SuperAdmin.setVisible(true);
		Poli.setVisible(false);
		        pan_super_admin.setBackground(Color.BLACK);
				pan_super_admin.setLayout(new BoxLayout(pan_super_admin, BoxLayout.Y_AXIS));
		Vizualizare_Utilizatori.setAlignmentX(Component.CENTER_ALIGNMENT);
				pan_super_admin.add( Box.createRigidArea(new Dimension(0,50)) );
				pan_super_admin.add(Vizualizare_Utilizatori);
		Delogare.setAlignmentX(Component.CENTER_ALIGNMENT);
				pan_super_admin.add( Box.createRigidArea(new Dimension(0,200)) );
				pan_super_admin.add(Delogare);
		SuperAdmin.add(pan_super_admin);
			}
			else {
				JOptionPane.showMessageDialog(null, "Invalid Login Details");
			}
		}
	}
	public class DelogareListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
		Poli.setVisible(true);
		SuperAdmin.setVisible(false);
		Receptioner.setVisible(false);
		Financiar.setVisible(false);
		RUmane.setVisible(false);
		Medic.setVisible(false);
		Asistent.setVisible(false);
		Admin.setVisible(false);
		}
	}
	
	public class InregistrarePacientListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//Receptioner.setVisible(false);
			Inregistrare_pac.setSize(400,400);
			Inregistrare_pac.setVisible(true);
		//pan_inregistrare_pacient.setLayout(new BoxLayout(pan_inregistrare_pacient, BoxLayout.Y_AXIS));
			pan_inregistrare_pacient.setBackground(Color.LIGHT_GRAY);
			pan_inregistrare_pacient.setLayout(new FlowLayout());
			pan_inregistrare_pacient.add(Nume_pac);
			pan_inregistrare_pacient.add(Nume_pacient);
			pan_inregistrare_pacient.add(Prenume_pac);
			pan_inregistrare_pacient.add(Prenume_pacient);
			pan_inregistrare_pacient.add(Inregistreaza);
			Inregistrare_pac.setContentPane(pan_inregistrare_pacient);
			Inregistrare_pac.pack();
		}
}
	public class InregistreazaListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			/*Statement call=null;*/
		try {
	        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/policlinica?user=root&password=");
			Statement call = connection.createStatement();
			String numePacInput = "";
			String prenumePacInput = "";
			numePacInput = getNumeInput();
			prenumePacInput = getPrenumeInput();
			call.execute("call Adauga_pacient('"+ numePacInput + "','" + prenumePacInput + "');");
			JOptionPane.showMessageDialog(null, "S-a inregistrat");
		}
		catch(SQLException e1){
			JOptionPane.showMessageDialog(null, "Nu s-a inregistrat");
		}
		}
}
	public class CreeazaProgramareListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//Receptioner.setVisible(false);
			Creeaza_prog.setSize(450,450);
			Creeaza_prog.setVisible(true);	
			pan_creeaza_pacient.setLayout(new GridLayout(0,2,10,10));
			pan_creeaza_pacient.setBackground(Color.LIGHT_GRAY);
			pan_creeaza_pacient.add(Id_rec);
			pan_creeaza_pacient.add(Id_rec_text);
			pan_creeaza_pacient.add(Id_pacient);
			pan_creeaza_pacient.add(Id_pacient_text);
			pan_creeaza_pacient.add(Data_calendaristica);
			pan_creeaza_pacient.add(Data_calendaristica_text);
			pan_creeaza_pacient.add(Nume_medic);
			pan_creeaza_pacient.add(Nume_medic_text);
			pan_creeaza_pacient.add(Durata_consul);
			pan_creeaza_pacient.add(Durata_consul_text);
			pan_creeaza_pacient.add(Ora_consul);
			pan_creeaza_pacient.add(Ora_consul_text);
			pan_creeaza_pacient.add(Creeaza);
			Creeaza_prog.setContentPane(pan_creeaza_pacient);
		}
}
	public class CreeazaListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
		try {
	        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/policlinica?user=root&password=");
			Statement call = connection.createStatement();
			String[] input = new String[6];
			input[0]=getIdRecInput();
			input[1]=getIdPacInput();
			input[2]=getDataCalInput();
			input[3]=getNumeMedicInput();
			input[4]=getDurataConInput();
			input[5]=getOraConInput();
			call.execute("call Adauga_programare2('" + input[0] + "','" + input[1] + "','" + input[2] + "" + "','" + input[3]
					+ "','" + input[4] + "','" + input[5] +  "');");
			JOptionPane.showMessageDialog(null, "S-a programat");
		}
		catch(SQLException e1){
			JOptionPane.showMessageDialog(null, "Nu s-a programat");
		}
		}
	}
		public class ListareUtilizatoriListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				try {
				Viz_Utilizatori();
				JOptionPane.showMessageDialog(null, "S-a realizat cautarea");
				}
				catch(Exception e1){
					JOptionPane.showMessageDialog(null, "Nu s-a realizat cautarea");
				}
			}
		}
		/*
		 *     private JFrame Orar_Angajat = new JFrame();
    private JFrame Orar_Unitate= new JFrame();
    private JPanel pan_orar_angajat=new JPanel();
    private JPanel pan_orar_unitate=new JPanel();
    private JLabel Orar_Angajat_label=new JLabel("CNP Utilizator:");
    private JLabel Orar_Unitate_label= new JLabel("Id unitate: ");
    private JTextField Orar_Angajat_text= new JTextField(20);
    private JTextField Orar_Unitate_text= new JTextField(20);
    private JButton Cauta_Util= new JButton("Cauta Utilizator ");
    private JButton Cauta_Unitate= new JButton("Cauta Unitate ");
		 */
		public class CautareUtilizatorListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				//Receptioner.setVisible(false);
				Orar_Angajat.setSize(400,400);
				Orar_Angajat.setVisible(true);
			//pan_inregistrare_pacient.setLayout(new BoxLayout(pan_inregistrare_pacient, BoxLayout.Y_AXIS));
				pan_orar_angajat.setBackground(Color.BLUE);
				pan_orar_angajat.setLayout(new FlowLayout());
				pan_orar_angajat.add(Orar_Angajat_label);
				pan_orar_angajat.add(Orar_Angajat_text);
				pan_orar_angajat.add(Cauta_Util);
				Orar_Angajat.setContentPane(pan_orar_angajat);
				Orar_Angajat.pack();
			}
	}
		
		public class CautareUnitateListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				//Receptioner.setVisible(false);
				Orar_Unitate.setSize(400,400);
				Orar_Unitate.setVisible(true);
			//pan_inregistrare_pacient.setLayout(new BoxLayout(pan_inregistrare_pacient, BoxLayout.Y_AXIS));
				pan_orar_unitate.setBackground(Color.BLUE);
				pan_orar_unitate.setLayout(new FlowLayout());
				pan_orar_unitate.add(Orar_Unitate_label);
				pan_orar_unitate.add(Orar_Unitate_text);
				pan_orar_unitate.add(Cauta_Unitate);
				Orar_Unitate.setContentPane(pan_orar_unitate);
				Orar_Unitate.pack();
			}
	}
		public class CautaUtilizatorListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
			try {
		        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/policlinica?user=root&password=");
				Statement call = connection.createStatement();
				String cnp_Utilizator="";
				cnp_Utilizator=getOrarUtilizator();
				//call.execute("call Orar_Utilizator('" + cnp_Utilizator +  "');");
				Viz_User(cnp_Utilizator);
				JOptionPane.showMessageDialog(null, "S-a efectuat cautarea!");
			}
			catch(SQLException e1){
				JOptionPane.showMessageDialog(null, "Nu s-a efectuat cautarea!");
			}
			}
		}
		
		public class CautaUnitateListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
			try {
		        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/policlinica?user=root&password=");
				Statement call = connection.createStatement();
				String id_Unitate="";
				id_Unitate=getOrarUnitate();
				//call.execute("call Orar_Utilizator('" + cnp_Utilizator +  "');");
				Viz_Unitate(id_Unitate);
				JOptionPane.showMessageDialog(null, "S-a efectuat cautarea!");
			}
			catch(SQLException e1){
				JOptionPane.showMessageDialog(null, "Nu s-a efectuat cautarea!");
			}
			}
		}
		public class VizualizarePacientiListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				try {
				Viz_pacienti();
				JOptionPane.showMessageDialog(null, "S-a realizat cautarea");
				}
				catch(Exception e1){
					JOptionPane.showMessageDialog(null, "Nu s-a realizat cautarea");
				}
			}
		}
		
		public class VizualizareSalariuListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				try {
					String salariu_ang="";
					salariu_ang=getSalariuAngajat();
				Viz_Salariu(salariu_ang);
				JOptionPane.showMessageDialog(null, "S-a realizat cautarea");
				}
				catch(Exception e1){
					JOptionPane.showMessageDialog(null, "Nu s-a realizat cautarea");
				}
			}
		}
		
		public class VizualizareCheltuialaListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				try {
					String cheltuieli_unitate="";
					cheltuieli_unitate=getCheltuialaUnitate();
				Viz_Cheltuieli(cheltuieli_unitate);
				JOptionPane.showMessageDialog(null, "S-a realizat cautarea");
				}
				catch(Exception e1){
					JOptionPane.showMessageDialog(null, "Nu s-a realizat cautarea");
				}
			}
		}
		/*
    private JFrame Vizualizare_Cheltuieli_frame = new JFrame();
    private JFrame Vizualizare_Salarii_frame = new JFrame();
    private JPanel pan_Vizualizare_Cheltuieli=new JPanel();
    private JPanel pan_Vizualizare_Salarii=new JPanel();
    private JLabel Vizualizare_Cheltuieli_label=new JLabel("CNP Utilizator:");
    private JLabel Vizualizare_Salarii_label= new JLabel("Id unitate: ");
    private JTextField Vizualizare_Cheltuieli_text= new JTextField(20);
    private JTextField Vizualizare_Salarii_text= new JTextField(20);
    private JButton Cauta_Cheltuiala= new JButton("Cautare ");
    private JButton Cauta_Salariu= new JButton("Cautare ");
		 */
		
		
		public class VizualizareCheltuieliListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				//Receptioner.setVisible(false);
				Vizualizare_Cheltuieli_frame.setSize(400,400);
				Vizualizare_Cheltuieli_frame.setVisible(true);
			//pan_inregistrare_pacient.setLayout(new BoxLayout(pan_inregistrare_pacient, BoxLayout.Y_AXIS));
				pan_Vizualizare_Cheltuieli.setBackground(Color.GREEN);
				pan_Vizualizare_Cheltuieli.setLayout(new FlowLayout());
				pan_Vizualizare_Cheltuieli.add(Vizualizare_Cheltuieli_label);
				pan_Vizualizare_Cheltuieli.add(Vizualizare_Cheltuieli_text);
				pan_Vizualizare_Cheltuieli.add(Cauta_Cheltuiala);
				Vizualizare_Cheltuieli_frame.setContentPane(pan_Vizualizare_Cheltuieli);
				Vizualizare_Cheltuieli_frame.pack();
			}
	}
		
		public class VizualizareSalariiListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				//Receptioner.setVisible(false);
				Vizualizare_Salarii_frame.setSize(400,400);
				Vizualizare_Salarii_frame.setVisible(true);
			//pan_inregistrare_pacient.setLayout(new BoxLayout(pan_inregistrare_pacient, BoxLayout.Y_AXIS));
				pan_Vizualizare_Salarii.setBackground(Color.GREEN);
				pan_Vizualizare_Salarii.setLayout(new FlowLayout());
				pan_Vizualizare_Salarii.add( Vizualizare_Salarii_label);
				pan_Vizualizare_Salarii.add( Vizualizare_Salarii_text);
				pan_Vizualizare_Salarii.add( Cauta_Salariu);
				Vizualizare_Salarii_frame.setContentPane(pan_Vizualizare_Salarii);
				Vizualizare_Salarii_frame.pack();
			}
	}
		public class VizualizareProgramareListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				try {
				Viz_Programari();
				JOptionPane.showMessageDialog(null, "S-a realizat cautarea");
				}
				catch(Exception e1){
					JOptionPane.showMessageDialog(null, "Nu s-a realizat cautarea");
				}
			}
		}
		
}
