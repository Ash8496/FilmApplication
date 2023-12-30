package Application;

import java.util.ArrayList;

public interface Service {
    int addFilm(Film newFilm);

    ArrayList<Film> filterRate();

    ArrayList<Film> oscarNom();

    int updatefilm(String name, int year);

}
