package org.rxmanager.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;

@Data
@Entity
@Table(indexes = {@Index(columnList = "id"), @Index(columnList = "name")})
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, updatable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private HashSet<String> variants;

    public void setName(String name) {
        this.name = name.toUpperCase();
    }
}
