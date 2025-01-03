package com.srl.N2quizsrl.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Word")
public class Word {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "japanese")
    private String japanese;

    @Column(name = "cara_baca")
    private String caraBaca;

    @Column(name = "english")
    private String english;

    @Column(name = "section")
    private Long section;

    @Column(name = "chapter")
    private Long chapter;

    @Column(name = "mastery")
    private Long mastery;
}
