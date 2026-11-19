package vn.iotstar.webcourse.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Videos")
public class Video implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "NVARCHAR(255)", nullable = false)
    private String title;

    @Column(columnDefinition = "NVARCHAR(MAX)")
    private String description;

    @Column(name = "file_path", length = 500, nullable = false)
    private String filePath;

    private int views = 0;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Video() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getFilePath() { return filePath; }
    public void setFilePath(String filePath) { this.filePath = filePath; }

    public int getViews() { return views; }
    public void setViews(int views) { this.views = views; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}