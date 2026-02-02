package com.jsp.taskapi.data.tags;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jsp.taskapi.data.tasks.Task;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "tags")
@EqualsAndHashCode(onlyExplicitlyIncluded = true) //dont add equals and hashcode
public class Tags {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tagId;

    @Column(name = "tagName",nullable = false)
    private String tagName;

    @ManyToMany(mappedBy = "tags")
    @JsonIgnore
    private Set<Task> tasks = new HashSet<>();

}
