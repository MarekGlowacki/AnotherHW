package Excercises_web_app;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "uzytkownik", schema = "AppJEE", catalog = "")
public class UzytkownikEntity {
    private int id;
    private String imie;
    private String nazwisko;
    private String przezwisko;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "imie")
    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    @Basic
    @Column(name = "nazwisko")
    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    @Basic
    @Column(name = "przezwisko")
    public String getPrzezwisko() {
        return przezwisko;
    }

    public void setPrzezwisko(String przezwisko) {
        this.przezwisko = przezwisko;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UzytkownikEntity that = (UzytkownikEntity) o;
        return id == that.id &&
                Objects.equals(imie, that.imie) &&
                Objects.equals(nazwisko, that.nazwisko) &&
                Objects.equals(przezwisko, that.przezwisko);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, imie, nazwisko, przezwisko);
    }
}
