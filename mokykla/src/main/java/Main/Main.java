package Main;


import helpers.EntityManagerHelper;
import klases.Pazymis;
import klases.Studentas;

import javax.persistence.EntityManager;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Studentas> studentai = uzkrautiDuomenys();

        studentai.sort(Studentas::compareTo);


        for (Studentas studentas : studentai
        ) {
            System.out.println("---------------------------------");
            System.out.println(studentas);
            System.out.println("-------------------");
            System.out.println("vidurkis studento "+vienoVidurkis());


        }


        System.out.println("----------------------------");
        System.out.println("visu bendras vidurkis "+visuBendrasVidurkis(2018));

    }

    public static List<Studentas> uzkrautiDuomenys() {
        EntityManager em = EntityManagerHelper.getEntityManager();
        List<Studentas> studentas = em.createQuery("select a from studentai a", Studentas.class).getResultList();

        return studentas;



    }

    public static int vienoVidurkis() {
        List<Studentas> studentai = uzkrautiDuomenys();
        int sum = 0;
        int count = 0;
        for (Studentas s : studentai) {

            for (Pazymis p : s.getPazymiai()) {
                sum += p.getPazymys();
                count++;
            }
        }
        return Math.incrementExact(sum / count);
    }


    private static int visuBendrasVidurkis(int metai) {

        List<Studentas> studentai = uzkrautiDuomenys();
        int countAvg = 0;
        int studAvg = 0;

        for (Studentas s : studentai) {

            int count = 0;
            int sum = 0;

            for (Pazymis p : s.getPazymiai()) {

                if (p.getData().getYear() == metai) {

                    sum += p.getPazymys();
                }
                count++;
            }
            studAvg += (double) sum / count;
            countAvg++;
        }
        return  Math.incrementExact(studAvg / countAvg);
    }




}
