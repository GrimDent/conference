package com.IT.conference.prelections;

import com.IT.conference.users.Users;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Prelections {
    @Id
    @SequenceGenerator(
            name="prelections_sequence",
            sequenceName = "prelections_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "prelections_sequence"
    )
    private Long id;
    @NotNull
    private String thematic_path;
    @NotNull
    private String start_hour;
    @NotNull
    private String title;

    @ManyToMany(mappedBy = "register")
    private List<Users> audience = new ArrayList<>();

    public Prelections() {
    }

    public Prelections(Long id,
                       String thematic_path,
                       String start_hour,
                       String title) {
        this.id = id;
        this.thematic_path = thematic_path;
        this.start_hour = start_hour;
        this.title = title;
    }

    public Prelections(String thematic_path,
                       String start_hour,
                       String title) {
        this.thematic_path = thematic_path;
        this.start_hour = start_hour;
        this.title = title;
    }

    public Prelections(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Prelections(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getThematic_path() {
        return thematic_path;
    }

    public void setThematic_path(String thematic_path) {
        this.thematic_path = thematic_path;
    }

    public String getStart_hour() {
        return start_hour;
    }

    public void setStart_hour(String start_hour) {
        this.start_hour = start_hour;
    }

    public void audience(Users user){
        audience.add(user);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Prelections{" +
                "Id=" + id +
                ", thematic_path='" + thematic_path + '\'' +
                ", start_hour='" + start_hour + '\'' +
                ", title='" + title + '\'' +
                ", audience=" + audience +
                '}';
    }
}
