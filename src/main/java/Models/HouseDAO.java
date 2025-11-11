package Models;
import DataBase.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class HouseDAO {

    private Connection conn;

    public HouseDAO() {
        conn = DBConnection.getConnection();
    }

    public void create(House house) throws SQLException {
        String sql = "INSERT INTO house (name, founder) VALUES (?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, house.getName());
        ps.setString(2, house.getFounder());
        ps.executeUpdate();
        ps.close();
    }

    public List<House> getAll() throws SQLException {
        List<House> list = new ArrayList<>();
        Statement st = conn.createStatement();
        String sql = "SELECT * FROM house";
        ResultSet rs = st.executeQuery(sql);

        while(rs.next()){
            list.add(new House(rs.getInt("id"),(rs.getString("name")),(rs.getString("founder"))));
        }
        rs.close();

        return list;

    }

    public House getById(int id) throws SQLException {
        String sql = "SELECT * FROM house WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        House h = null;
        if(rs.next()){
            h = new House(rs.getInt("id"),(rs.getString("name")),(rs.getString("founder")));
        }
        rs.close();
        ps.close();
        return h;
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM house WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
    }
}
