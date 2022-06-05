import helper.MyConnection;

public class Main {
    public static void main(String[] args) {
//        MyConnection m = new MyConnection();
//        m.getConnection();

        Pengguna pengguna = new Pengguna();
        ArrayList<Pengguna> listPengguna = pengguna.read();

        for (Pengguna value: listPengguna){
            System.out.println(value.getNamaLengkap());
        }

//        Pengguna coba = new Pengguna(id: 4, username: "user3", password: "user3", namaLengkap: "User Tiga", level: "user");
        Pengguna coba = new Pengguna();
        coba.setUsername("user4");
        coba.setPassword("user4");
        coba.setnamaLengkap("user Empat");
        coba.setlevel("user4");
        coba.create();
    }
}
