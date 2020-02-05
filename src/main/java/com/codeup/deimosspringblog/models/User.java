package com.codeup.deimosspringblog.models;
import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @ManyToMany (cascade = CascadeType.ALL)
    @JoinTable(
            name="users_posts",
            joinColumns={@JoinColumn(name="user_id")},
            inverseJoinColumns={@JoinColumn(name="post_id")}
    )
    private List<Post> posts;

}
