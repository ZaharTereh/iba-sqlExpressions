package by.iba.springboot.tereh.springbootapp.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "user_log")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sql_query")
    private String sqlQuery;

    @Column(name = "message")
    private String message;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,
                          CascadeType.REFRESH,CascadeType.PERSIST})
    @JoinColumn(name = "user_id")
    private User user;
}
