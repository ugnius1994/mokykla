package klases;

import javax.persistence.*;
import java.time.LocalDate;


@Entity(name = "pazymiai")
public class Pazymis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate data;

    private int pazymys;

    @ManyToOne(fetch = FetchType.LAZY)
    private Studentas studentas;

    @Override
    public String toString() {
        return "Pazymis{" +
                "id=" + id +
                ", data=" + data +
                ", pazymis=" + pazymys +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getPazymys() {
        return pazymys;
    }

    public void setPazymys(int pazymis) {
        this.pazymys = pazymis;
    }

    public Studentas getStudentas() {
        return studentas;
    }

    public void setStudentas(Studentas studentas) {
        this.studentas = studentas;
    }
}
