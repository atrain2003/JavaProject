import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.sql.*;



public class Main {

    public static void main(String[] args) {
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:C:/Users/rimoc/mydatabase.db");
            Statement stmt = conn.createStatement();
            System.out.println("Connection successful...");
            ResultSet rs = stmt.executeQuery("SELECT * FROM mytable1");
            List<ClothingItem> allClothingItems = new ArrayList<>();
            Map<String, List<ClothingItem>> clothingItemsBySize = new HashMap<>();
            while (rs.next()) {
                String name = rs.getString("name");
                int quantity = rs.getInt("quantity");
                String size = rs.getString("size");
                String color = rs.getString("color");
                ClothingItem item;
                if(rs.getString("lengthSize")!=null){
                    double lengthSize = rs.getDouble("lengthSize");
                    double sleeveLength = rs.getDouble("sleeveLength");
                    item = new Shirt(name,quantity,size,color,lengthSize,sleeveLength);
                }else{
                    double waistSize = rs.getDouble("waistSize");
                    double inseamLength = rs.getDouble("inseamLength");
                    item = new Pant(name,quantity,size,color,waistSize,inseamLength);
                }
                allClothingItems.add(item);
                if (!clothingItemsBySize.containsKey(size)) {
                    clothingItemsBySize.put(size, new ArrayList<>());
                }
                clothingItemsBySize.get(size).add(item);
            }
            String sql = "INSERT INTO mytable1 (name, quantity, size, color, lengthSize, sleeveLength) VALUES (?,?,?,?,?,?)";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, "T-Shirt");
            stm.setInt(2, 1);
            stm.setString(3, "M");
            stm.setString(4, "Black");
            stm.setDouble(5, 32.4);
            stm.setDouble(6, 7.3);
            stm.executeUpdate();
            String sql1 = "INSERT INTO mytable1 (name, quantity, size, color, waistSize, inseamLength) VALUES (?,?,?,?,?,?)";
            PreparedStatement stmnt = conn.prepareStatement(sql1);
            stmnt.setString(1, "Sweatpants");
            stmnt.setInt(2, 2);
            stmnt.setString(3, "28/29");
            stmnt.setString(4, "Blue");
            stmnt.setDouble(5, 28);
            stmnt.setDouble(6, 29);
            stmnt.executeUpdate();


            System.out.println("All clothing items:");
            for (ClothingItem item : allClothingItems) {
                System.out.println(item);
            }

            System.out.println("\nClothing items by size:");
            for (Map.Entry<String, List<ClothingItem>> entry : clothingItemsBySize.entrySet()) {
                System.out.println(entry.getKey()    + ": " + entry.getValue()+System.lineSeparator());
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                    System.out.println("Connection ended...");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}