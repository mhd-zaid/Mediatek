package persistantdata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import utilisateur.Utilisateur;
import mediatek2021.*;
import document.Document;

// classe mono-instance : l'unique instance est connue de la bibliotheque
// via une injection de dépendance dans son bloc static

public class MediatekData implements PersistentMediatek {
// Jean-François Brette 01/01/2018
	private List<mediatek2021.Document> catalogue = new ArrayList<>();
	static {
		// injection dynamique de la dépendance dans le package stable mediatek2021
		Mediatek.getInstance().setData(new MediatekData());
	}

	private MediatekData() {
	}


	// va récupérer le User dans la BD et le renvoie
	// si pas trouvé, renvoie null
	@Override
	public Utilisateur getUser(String login, String password) {
		Connection db = null;
		db = DBConnection.getConnection();
		Utilisateur user = null;
		String query = "SELECT * FROM users WHERE login = ? and password = ?";
		PreparedStatement prepare = null;
		try {
			prepare = db.prepareStatement(query);
			prepare.setString(1, login);
			prepare.setString(2, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        try {
            ResultSet set =  prepare.executeQuery();
            if (set.next ()){
                 user = new Utilisateur(set.getString("login"),set.getString("password"));
                 return user;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
		return user;

	}

	// va récupérer le document de numéro numDocument dans la BD
	// et le renvoie
	// si pas trouvé, renvoie null
	@Override
	public Document getDocument(int numDocument) {
		Connection db = null;
		db = DBConnection.getConnection();
		Document doc = null;
		String type;

		String query = "SELECT * FROM documents WHERE iddocuments = ?";
		PreparedStatement prepare = null;
		try {
			prepare = db.prepareStatement(query);
			prepare.setInt(1, numDocument);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        try {
            ResultSet set =  prepare.executeQuery();
            while (set.next ()){
                 doc = new Document(set.getInt("typeDoc"), set.getString("titreDoc"));
                 return doc;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
				
		return doc;
	}

	// ajoute un nouveau document - exception à définir
	@Override
	public void newDocument(int type, Object... args) throws NewDocException {
		Connection db = null;
		db = DBConnection.getConnection();
		Document doc = null;
		PreparedStatement prepare = null;
		String query = "INSERT INTO documents(typeDoc,titreDoc,emprunt) values(?,?,'NON')";
		String titre = args[0].toString();
		try {
			prepare = db.prepareStatement(query);
			prepare.setInt(1, type);
			prepare.setString(2, titre);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
            int resultat =  prepare.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
	}

	// supprime un document - exception à définir
	@Override
	public void suppressDoc(int numDoc) throws SuppressException {
		Connection db = null;
		db = DBConnection.getConnection();
		String query = "DELETE FROM documents WHERE iddocuments = ? AND emprunt <> 'YES' ";
		PreparedStatement prepare = null;
		try {
			prepare = db.prepareStatement(query);
			prepare.setInt(1, numDoc);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        try {
            int set =  prepare.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
	}


	@Override
	public List<mediatek2021.Document> catalogue(int type) {
		Connection db = DBConnection.getConnection();
		PreparedStatement prepare = null;
		String query = "SELECT typeDoc,titreDoc FROM documents WHERE typeDoc = ? "; 
	            try {
	            	prepare = db.prepareStatement(query);
	    			prepare.setInt(1, type);
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	            
	            try {
	                ResultSet res = prepare.executeQuery();
	                if (res.next()) {
	                    do {
	                        Document doc = new Document(res.getInt("typeDoc"), res.getString("titreDoc"));
	                        catalogue.add(doc);
	                        
	                    } while (res.next());
	                } else {
	                    prepare.close();
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
		return catalogue;
	}

}
