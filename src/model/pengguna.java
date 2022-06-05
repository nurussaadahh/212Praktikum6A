package model;

import helper.MyConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class pengguna {

    private int id;
    private String username;
    private String password;
    private String namaLengkap;
    private String level;

    private Connection connection;
    public pengguna() {
    }

    public pengguna(int id, String username, String password, String namaLengkap, String level) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.namaLengkap = namaLengkap;
        this.level = level;
    }

    //CRUD create read update delete
    public void create(){
        String createSQL = "INSERT INTO `pengguna` (`id`, `username`, `password`, `namaLengkap`, `level`) " +
                "VALUES " +
                "(NULL, '"+this.username+"', MD5('"+this.password+"'), '"+this.namaLengkap+"', '"+this.level+"')";

        MyConnection m = new MyConnection();
        this.connection = m.getConnection();
        try {
            Statement statement = this.connection.createStatement();
            statement.execute(createSQL);
            System.out.println("Berhasil Create Data");
        } catch (SQLException e) {
            System.out.println("Error Create Data");
        }
    }
    public ArrayList<> read(){
        MyConnection m = new MyConnection();
        this.connection = m.getConnection();

        ArrayList<Pengguna> listPengguna = new ArrayList<>();

        String readSQL = "SELECT * FROM pengguna";
        try {

            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(readSQL);

            Pengguna penggunaHasilQuery;
            while (ResultSet.next()){
                System.out.println(resultSet.getString("id"));
                penggunaHasilQuery = new Pengguna(
                  resultSet.getInt("id"),
                  resultSet.getInt("username"),
                  resultSet.getInt("password"),
                  resultSet.getInt("namaLengkap"),
                  resultSet.getInt("level"),
                );
                listPengguna.add(penggunaHasilQuery);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listPengguna;
    }
    public void update(){}
    public void delete(){}

    public void login(){}
    public void updatePassword(){}
    public void resetPassword(){}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
