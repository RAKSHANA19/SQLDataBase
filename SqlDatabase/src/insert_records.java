import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.SQLException;  
public class insert_records {
	 private Connection connect() {  
	        // SQLite connection string  
	        String url = "jdbc:sqlite:C:\\Users\\Windows 10 Pro\\Desktop\\SQLite\\MDB.db";  
	        Connection conn = null;  
	        try {  
	            conn = DriverManager.getConnection(url);  
	        } catch (SQLException e) {  
	            System.out.println(e.getMessage());  
	        }  
	        return conn;  
	    }  
	   
	  
	    public void insert(String actor_name, String movie_name, String actress_name, int year) {  
	        String sql = "INSERT INTO movies(actor_name,movie_name,actress_name,year ) VALUES(?,?,?,?)";  
	   
	        try{  
	            Connection conn = this.connect();  
	            PreparedStatement pstmt = conn.prepareStatement(sql);  
	            pstmt.setString(1, actor_name);  
	            pstmt.setString(2, movie_name);
	            pstmt.setString(3, actress_name);
	            pstmt.setInt(4, year);
	            pstmt.executeUpdate();
	            System.out.println("Value Inserted...");
	        } catch (SQLException e) {  
	            System.out.println(e.getMessage());  
	        }  
	    }  


	public static void main(String[] args) {
		 insert_records app = new insert_records();  
		 app.insert("Ashokselvan","OhMyKadavule","      RitikaSingh",2020);  
		 app.insert("Suriya","SooraraiPottru","      Aparna",2020);
		 app.insert("Suriya","Anjaan","      Samantha",2014);
		 app.insert("Vijay Sethupathi","96","Trisha",2018);
		 
         

	}

}