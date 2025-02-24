package oduad.fi.finder.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.geo.Point;

@Data
@Entity
@Table(name = "preference")
public class Preference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id", nullable = false)
    private Profile profile;

    private int minAge;
    private int maxAge;
    private int maxDistance;
    private float minHeight;
    private float maxHeight;
    private String preferredGender;
    private boolean profilePicture;

    //@Column(columnDefinition = "geometry(Point, 4326)")
    //private Point location;


}
