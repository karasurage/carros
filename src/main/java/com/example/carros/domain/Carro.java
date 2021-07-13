package com.example.carros.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(255) DEFAULT NULL")
    private String nome;

//    @Column(columnDefinition = "VARCHAR(255) DEFAULT NULL")
//    private String descricao;
//
//    @Column(name = "url_foto", columnDefinition = "VARCHAR(255) DEFAULT NULL")
//    private String urlFoto;
//
//    @Column(name = "url_video", columnDefinition = "VARCHAR(255) DEFAULT NULL")
//    private String urlVideo;
//
//    @Column(columnDefinition = "VARCHAR(255) DEFAULT NULL")
//    private String latitude;
//
//    @Column(columnDefinition = "VARCHAR(255) DEFAULT NULL")
//    private String longitude;

    @Column(columnDefinition = "VARCHAR(255) DEFAULT NULL")
    private String tipo;
}