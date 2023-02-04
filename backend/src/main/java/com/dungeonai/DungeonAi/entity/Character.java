package com.dungeonai.DungeonAi.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "\"characters\"")
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "image", length = 1000000000)
    private String image;

    @Column(name = "appearance")
    private String appearance;

    @Column(name = "current_health")
    private int currentHealth;

    @Column(name = "max_health")
    private int maxHealth;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "game_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Game game;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Skill> skills = new HashSet<>();

    public Character(String name, String appearance) {
        this.name = name;
        this.appearance = appearance;
    }

    public Character() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAppearance() {
        return appearance;
    }

    public void setAppearance(String appearance) {
        this.appearance = appearance;
    }

    @JsonProperty("current_health")
    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    @JsonProperty("max_health")
    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public void addSkill(Skill skill) {
        skills.add(skill);
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }
}
