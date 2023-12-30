package Application;

import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {

    private static Service service = new ServiceImp() ;
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("\n==============================");
        System.out.println("Select Options");
        System.out.println("1. ADD FILM");
        System.out.println("2. UPDATE FILM");
        System.out.println("3. FILTER RATING");
        System.out.println("4. CHECK OSCAR NOMINEE");
        System.out.println("5. EXIT");
        int ch = sc.nextInt();
        sc.nextLine();


        switch (ch) {
            case 1:
                addFilm();
                break;
            case 2:
                updateFilm();
                break;
            case 3:
                filterRating();
                break;
            case 4:
                oscarNominee();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.err.println("INVALID CHOICE");

        }
        main(args);

    }
    private static void addFilm() {
        System.out.println("ENTER FILM NAME:");
        String fName =sc.nextLine();
        System.out.println("ENTER FILM YEAR ");
        int fYear = sc.nextInt();
        System.out.println("ENTER FILM LANGUAGE:");
        String fLang = sc.next();
        System.out.println("ENTER FILM RATING:");
        int fRating = sc.nextInt();

        Film newFilm = new Film(fName, fYear, fLang, fRating);
        int n = service.addFilm(newFilm);
        System.out.println(n + " FILM RECORD ADDED !!");

    }

    private static void updateFilm() {
        System.out.println("Enter Movie Name :");
        String name = sc.nextLine();
        System.out.println("Enter Updated Year :");
        int year = sc.nextInt();
        int n = service.updatefilm(name, year);
        System.out.println(n + " FILM RECORD UPDATED !!");
    }

    private static void filterRating() {
        ArrayList<Film> movie = service.filterRate();

        for (Film a : movie) {
            System.out.println("Movie ID: " + a.getFilmId());
            System.out.println("Movie Name: " + a.getFilmName());
            System.out.println("Year: " + a.getFilmYear());
            System.out.println("Language: " + a.getFilmLang());
            System.out.println("Rating: " + a.getFilmRating());
            System.out.println("\n==========================\n");
        }
    }

    private static void oscarNominee() {
        System.out.println("NOMINATED FOR THE OSCAR AWARDS.");
        ArrayList<Film> movie = service.oscarNom();

        for (Film a : movie) {
            System.out.println("Movie ID: " + a.getFilmId());
            System.out.println("Movie Name: " + a.getFilmName());
            System.out.println("Year: " + a.getFilmYear());
            System.out.println("Language: " + a.getFilmLang());
            System.out.println("Rating: " + a.getFilmRating());
            System.out.println("\n==========================\n");

        }
    }
}

