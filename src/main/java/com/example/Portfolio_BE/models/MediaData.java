package com.example.Portfolio_BE.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcType;
import org.hibernate.annotations.Type;
import org.hibernate.dialect.PostgreSQLCastingInetJdbcType;
import org.hibernate.dialect.PostgreSQLEnumJdbcType;
import org.hibernate.dialect.PostgreSQLOrdinalEnumJdbcType;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "mediadata")
public class MediaData {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "projectid")
    private int projectId;
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private MediaType type;
    @Column(name = "address")
    private String address;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description; // Optional (nullable)
}
