package Main;

import Entities.Studentas;
import Helpers.EntityManagerHelper;

import javax.persistence.EntityManager;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        EntityManager em = EntityManagerHelper.getEntityManager();
        List<Studentas> studentas = uzkrautiDuomenys();

        /**
         * isrusiuojama studento irasai pagal parametrus
         */
        studentas.sort(Studentas::compareTo);

        /**
         * atspausdinami studento irasai sukant cikla
         */

        for (Studentas studentas1 : studentas) {
            System.out.println("------------------------");
            System.out.println(studentas1);
        }
        System.out.println("------------------");
        System.out.println("gime 1990   " + studentuGimimoMetai(1990));
        System.out.println("-------------------------------------");
        System.out.println("gime 1991   " + studentuGimimoMetai(1991));
        em.close();

    }

    /**
     * uzkraunami studentu irasai is duombazes i  studentu lista
     * @return
     */

    public static List<Studentas> uzkrautiDuomenys() {
        EntityManager em = EntityManagerHelper.getEntityManager();
        List<Studentas> studentas = em.createQuery("select a from studentai a", Studentas.class).getResultList();

        return studentas;

    }

    public static int studentuGimimoMetai(int metai) {
        List<Studentas> studentai = uzkrautiDuomenys();
        int studentuSkai = 0;
        for (Studentas studentas : studentai) {
            if (studentas.getGimimoMetai() == metai) {

                studentuSkai++;
            }
        }
        return studentuSkai;
    }


}
