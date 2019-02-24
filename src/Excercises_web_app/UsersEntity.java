package Excercises_web_app;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "AppJEE", catalog = "")
public class UsersEntity {
    private int id;
    private String name;
    private String surname;
    private String nick;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getImie() {
        return name;
    }

    public void setImie(String imie) {
        this.name = name;
    }

    @Basic
    @Column(name = "surname")
    public String getNazwisko() {
        return surname;
    }

    public void setNazwisko(String nazwisko) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "nick")
    public String getPrzezwisko() {
        return nick;
    }

    public void setPrzezwisko(String przezwisko) {
        this.nick = nick;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersEntity that = (UsersEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(nick, that.nick);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, nick);
    }
}
