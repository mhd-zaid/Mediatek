package document;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import persistantdata.DBConnection;

public class Document implements mediatek2021.Document{
	int type;
	String titre;
	String id;
	
	public Document(int type, String titre) {
		this.type = type;
		this.titre = titre;
	}
	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	private String getId(String titre) {
		Connection db = DBConnection.getConnection();
		String query = "SELECT iddocuments FROM documents WHERE titreDoc = ? ";
		PreparedStatement prepare = null;
		id ="";
		try {
			prepare = db.prepareStatement(query);
			prepare.setString(1, titre);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        try {
        	ResultSet set =  prepare.executeQuery();
        	if (set.next()) {
                do {
                   id = set.getString("iddocuments");
                    
                } while (set.next());
        	}
            
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return id;
	}	
	@Override
	public Object[] data() {
		Object[] data = null ;
		data[0] = this.titre;
		
		return data;
	}
	@Override
	public String toString() {
        return "Document n° : "+ getId(this.titre)+", Titre du document : " + this.titre + ", type : " + this.type+"\n";
    }
	
}
