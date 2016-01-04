package com.autumncode.alloys;

import lombok.Data;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Data
public class Alloy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    @ElementCollection
    @MapKeyClass(Element.class)
    @MapKeyColumn(name = "element")
    Map<Element, Double> composition = new HashMap<>();
}
