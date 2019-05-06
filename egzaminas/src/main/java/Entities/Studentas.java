package Entities;

import javax.persistence.*;
import java.util.Comparator;

/**
 * studento klase, is kurios sukurima lentele i duomenu baze
 *
 * @generatedValue - autoIncrimentas padaro ,kad automatiskai sukuriamas id ,kai naujas irasas sukuriamas.
 */


@Entity(name = "studentai")
public class Studentas implements Comparable<Studentas> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    private String vardas;

    private String pavarde;

    @Column(name = "gimimo_metai")

    private int gimimoMetai;

    private int kursas;

    @Column(name = "studijuojama_kalba")
    private String studijuojamaKalba;


    @Override
    public String toString() {
        return "Studentas{" +
                "id=" + id +
                ", vardas='" + vardas + '\'' +
                ", pavarde='" + pavarde + '\'' +
                ", gimimoMetai=" + gimimoMetai +
                ", kursas=" + kursas +
                ", studijuojamaKalba=" + studijuojamaKalba +
                '}';
    }

    @Override
    public int compareTo(Studentas o) {
        return Comparator.comparing(Studentas::getStudijuojamaKalba)
                .thenComparing(Studentas::getKursas)
                .thenComparing(Studentas::getVardas)
                .compare(this, o);

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVardas() {
        return vardas;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public String getPavarde() {
        return pavarde;
    }

    public void setPavarde(String pavarde) {
        this.pavarde = pavarde;
    }

    public int getGimimoMetai() {
        return gimimoMetai;
    }

    public void setGimimoMetai(int gimimoMetai) {
        this.gimimoMetai = gimimoMetai;
    }

    public int getKursas() {
        return kursas;
    }

    public void setKursas(int kursas) {
        this.kursas = kursas;
    }

    public String getStudijuojamaKalba() {
        return studijuojamaKalba;
    }

    public void setStudijuojamaKalba(String studijuojamaKalba) {
        this.studijuojamaKalba = studijuojamaKalba;
    }
}
