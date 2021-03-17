import java.sql.*;

public class MDAJDBC {

   public static void main(String[] args) {
     InterfataPoli policlinica=new InterfataPoli();
     policlinica.go();
      Connection connection = null;
      Statement selectStatement = null, insertStatement = null;
      ResultSet rs = null;
      ResultSetMetaData rsmd = null;
      String sq1;
      try {
          connection = DriverManager.getConnection("jdbc:mysql://localhost/policlinica?user=root&password=");
          insertStatement = connection.createStatement();
         // insertStatement.execute("insert into pacient(id_pacient,nume) values (200,'Agardinitei')");
         // sq1="select * from pacient";
         // doQuery(sq1);
      }
      catch(SQLException sqlex) {
          System.err.println("An SQL Exception occured. Details are provided below:");
          sqlex.printStackTrace(System.err);
      }
      finally {
         if (rs != null) { 
            try { 
                rs.close();  
            } 
            catch(SQLException e) {
            }  
            rs = null;  
         }
         if (selectStatement != null) { 
            try { 
                selectStatement.close();  
            } 
            catch(SQLException e) {}  
            selectStatement = null;  
         }
         if (insertStatement != null) { 
            try { 
                insertStatement.close();  
            } 
            catch(SQLException e) {}  
            insertStatement = null;  
         }
         if (connection != null) { 
            try { 
                connection.close();  
            } 
            catch(SQLException e) {}  
            connection = null;  
         }
      }
   }
   
	private static void doQuery(String queryStr)
	{Connection connection;
		
		try {
		    connection = DriverManager.getConnection("jdbc:mysql://localhost/policlinica?user=root&password=");
			Statement stmt = connection.createStatement();
			ResultSet rst = stmt.executeQuery(queryStr);
			ResultSetMetaData rsmd = rst.getMetaData();

			// Calculate column sizes (cut off large columns to 35)
			int colCount = rsmd.getColumnCount();
			int rowCount = 0;
			int colWidth[] = new int[colCount];
			for (int i=1; i <= colCount; i++)
			{	colWidth[i-1] = rsmd.getColumnDisplaySize(i);
				if (colWidth[i-1] > 35)
					colWidth[i-1] = 35;
			}

			System.out.println();
			// Print header
			for (int i=1; i <= colCount; i++)
			{	String colName = rsmd.getColumnName(i);
				System.out.print(colName+spaces(colWidth[i-1]-colName.length())+' ');
			}
			System.out.println("\n-----------------------------------------------------------------------");

			while (rst.next())
			{
				for (int i=1; i <= colCount; i++)
				{	Object obj = rst.getObject(i);
					if (obj == null)
						System.out.print(spaces(colWidth[i-1]));
					else
					{	String data = obj.toString();
						System.out.print(data+spaces(colWidth[i-1]-data.length())+' ');
					}
				}
				System.out.println();
				rowCount++;
			}
			if (rowCount == 0)
				System.out.println("No results.");

			rst.close();
		}
		catch (SQLException ex) {
			System.err.println("SQLException: " + ex);
		}
	}
	
	private static String spaces(int space)
	{
		String sp = "";
		for(int i=0;i<space;i++)
			sp = sp+" ";
		return sp;
	} 
	public void Viz_Utilizatori() {
		String x="Select * from utilizator";
		doQuery(x);
	}
	
	public void Viz_pacienti() {
		String x="Select * from pacient";
		doQuery(x);
	}
	public void Viz_User(String s) {
		String x="Select * from Utilizator inner join Orar on Orar.cnp='"+ s +"'and Utilizator.CNP='" + s +"';";
	doQuery(x);
	}
	
	public void Viz_Unitate(String s) {
		String x="Select * from Unitate_medicala inner join Orar on Orar.locatie_id='"+ s +"'and Unitate_medicala.id_unitate='" + s +"';";
		doQuery(x);
	}
	public void Viz_Salariu(String s) {
		String x="Select * from Utilizator inner join Angajat on Angajat.cnp='"+ s + "' and Utilizator.CNP='"+s+"';";
		doQuery(x);
	}
	public void Viz_Cheltuieli(String s) {
		String x="Select id_unitate,denumire, cheltuieli from Unitate_medicala where Unitate_medicala.id_unitate='"+ s + "';";
        doQuery(x);
	}
	public void Viz_Programari() {
		String x= "Select * from Programare";
		doQuery(x);
	}
}