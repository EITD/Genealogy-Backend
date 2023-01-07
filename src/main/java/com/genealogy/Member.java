package com.genealogy;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Member {
    @Id
    @SequenceGenerator(name = "member_id_sequence", sequenceName = "member_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_id_sequence")
    private Integer id;
    private String courtesy;
    private Integer generation;
    private String name;
    private Integer parentId;
    private String description;

    public Member(Integer id, String courtesy, Integer generation, String name, Integer parentId, String description) {
        this.id = id;
        this.courtesy = courtesy;
        this.generation = generation;
        this.name = name;
        this.parentId = parentId;
        this.description = description;
    }

    public Member() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourtesy() {
        return courtesy;
    }

    public void setCourtesy(String courtesy) {
        this.courtesy = courtesy;
    }

    public Integer getGeneration() {
        return generation;
    }

    public void setGeneration(Integer generation) {
        this.generation = generation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(id, member.id) && Objects.equals(courtesy, member.courtesy) && Objects.equals(generation, member.generation) && Objects.equals(name, member.name) && Objects.equals(parentId, member.parentId) && Objects.equals(description, member.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, courtesy, generation, name, parentId, description);
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", courtesy='" + courtesy + '\'' +
                ", generation=" + generation +
                ", name='" + name + '\'' +
                ", parentId=" + parentId +
                ", description='" + description + '\'' +
                '}';
    }
}
