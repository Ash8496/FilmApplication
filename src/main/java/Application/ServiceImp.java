package Application;

import java.sql.*;
import java.util.ArrayList;

public class ServiceImp implements Service {

    private static Connection conn = null;

    static {
        String url = "jdbc:mysql://localhost:3306/filmdb";
        String userName = "root";
        String password = "tiger";

        try {
            conn = DriverManager.getConnection(url, userName, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    @Override
    public int addFilm(Film newFilm) {
        int n = 0 ;
        String qry = "INSERT INTO film_info (film_name, film_year, film_lang, film_rating) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement stat = conn.prepareStatement(qry);
            stat.setString(1, newFilm.getFilmName());
            stat.setInt(2, newFilm.getFilmYear());
            stat.setString(3, newFilm.getFilmLang());
            stat.setInt(4, newFilm.getFilmRating());

            n= stat.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Insert error");

        }return n;
    }
    @Override
    public int updatefilm(String name, int year) {
        int n = 0 ;
        String qry = "UPDATE film_info SET film_year = ? WHERE film_name = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(qry);
            statement.setInt(1, year);
            statement.setString(2, name);
            n=statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("UPDATE ERROR");
        }return n;
    }


    @Override
    public ArrayList<Film> filterRate() {
        String qry = "SELECT * FROM film_info ORDER BY film_rating DESC";
        ArrayList<Film> list = new ArrayList<>();

        try {
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(qry);
            while (rs.next()) {
                Film film = new Film();
                film.setFilmId(rs.getInt(1));
                film.setFilmName(rs.getString(2));
                film.setFilmYear(rs.getInt(3));
                film.setFilmLang(rs.getString(4));
                film.setFilmRating(rs.getInt(5));
                list.add(film);
            }
        } catch (SQLException e) {

        }
        return list;
    }


    @Override
    public ArrayList<Film> oscarNom() {
        String qry = "SELECT * FROM film_info ORDER BY film_rating DESC LIMIT 5";
        ArrayList<Film> list = new ArrayList<>();

        try {
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(qry);
            while (rs.next()) {
                Film film = new Film();
                film.setFilmId(rs.getInt(1));
                film.setFilmName(rs.getString(2));
                film.setFilmYear(rs.getInt(3));
                film.setFilmLang(rs.getString(4));
                film.setFilmRating(rs.getInt(5));
                list.add(film);
            }
        } catch (SQLException e) {

        }
        return list;
    }

}