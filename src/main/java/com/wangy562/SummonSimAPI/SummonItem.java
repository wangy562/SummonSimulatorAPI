package com.wangy562.SummonSimAPI;


import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class SummonItem {

    private String id;

    private Integer rarity;  // Three, Four, or Five stars
    private String name;
    private String type;  // Character or weapon

    public SummonItem(String id, Integer rarity, String name, String type) {
        this.id = id;
        this.rarity = rarity;
        this.name = name;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getRarity() {
        return rarity;
    }

    public void setRarity(Integer rarity) {
        this.rarity = rarity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "SummonItem{" +
                "id='" + id + '\'' +
                ", rarity=" + rarity +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SummonItem that = (SummonItem) o;

        if (!getRarity().equals(that.getRarity())) return false;
        if (!getName().equals(that.getName())) return false;
        return getType().equals(that.getType());
    }
}
