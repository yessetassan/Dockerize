package com.project.springApp;


import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@Table(name = "good")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

}
