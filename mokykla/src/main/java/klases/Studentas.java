package klases;

import javax.persistence.*;
import java.util.List;

@Entity(name = "studentai")

public class Studentas implements Comparable<Studentas> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String vardas;

    private String pavarde;

    @Column(name = "el_pastas")
    private String elPastas;

    @OneToMany(
            mappedBy = "studentas",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Pazymis> pazymiai;


    @Override
    public String toString() {
        return "Studentas{" +
                "id=" + id +
                ", vardas='" + vardas + '\'' +
                ", pavarde='" + pavarde + '\'' +
                ", elPastas='" + elPastas + '\'' +
                ", pazymiai=" + pazymiai +
                '}'+"\n";
    }
    @Override
    public int compareTo(Studentas o){
        int compare=getPavarde().compareTo(o.getPavarde());
        if (compare<=0)return compare;

        return getVardas().compareTo(o.getVardas());
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

    public String getElPastas() {
        return elPastas;
    }

    public void setElPastas(String el_pastas) {
        this.elPastas = el_pastas;
    }

    public List<Pazymis> getPazymiai() {
        return pazymiai;
    }

    public void setPazymiai(List<Pazymis> pazymis) {
        this.pazymiai = pazymis;
    }
}
