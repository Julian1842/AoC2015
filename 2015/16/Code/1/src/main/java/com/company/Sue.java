package com.company;

public class Sue {
    private Integer id = null;
    private Integer children = null;
    private Integer cats = null;
    private Integer samoyeds = null;
    private Integer pomeranians = null;
    private Integer akitas = null;
    private Integer vizslas = null;
    private Integer goldfish = null;
    private Integer trees = null;
    private Integer cars = null;
    private Integer perfumes = null;

    public Sue() {
    }

    public Sue(Integer children, Integer cats, Integer samoyeds, Integer pomeranians, Integer akitas, Integer vizslas, Integer goldfish, Integer trees, Integer cars, Integer perfumes) {
        this.children = children;
        this.cats = cats;
        this.samoyeds = samoyeds;
        this.pomeranians = pomeranians;
        this.akitas = akitas;
        this.vizslas = vizslas;
        this.goldfish = goldfish;
        this.trees = trees;
        this.cars = cars;
        this.perfumes = perfumes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getChildren() {
        return children;
    }

    public void setChildren(Integer children) {
        this.children = children;
    }

    public Integer getCats() {
        return cats;
    }

    public void setCats(Integer cats) {
        this.cats = cats;
    }

    public Integer getSamoyeds() {
        return samoyeds;
    }

    public void setSamoyeds(Integer samoyeds) {
        this.samoyeds = samoyeds;
    }

    public Integer getPomeranians() {
        return pomeranians;
    }

    public void setPomeranians(Integer pomeranians) {
        this.pomeranians = pomeranians;
    }

    public Integer getAkitas() {
        return akitas;
    }

    public void setAkitas(Integer akitas) {
        this.akitas = akitas;
    }

    public Integer getVizslas() {
        return vizslas;
    }

    public void setVizslas(Integer vizslas) {
        this.vizslas = vizslas;
    }

    public Integer getGoldfish() {
        return goldfish;
    }

    public void setGoldfish(Integer goldfish) {
        this.goldfish = goldfish;
    }

    public Integer getTrees() {
        return trees;
    }

    public void setTrees(Integer trees) {
        this.trees = trees;
    }

    public Integer getCars() {
        return cars;
    }

    public void setCars(Integer cars) {
        this.cars = cars;
    }

    public Integer getPerfumes() {
        return perfumes;
    }

    public void setPerfumes(Integer perfumes) {
        this.perfumes = perfumes;
    }
}
