package com.bomba.database;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table TRACK.
 */
public class track {

    private Long id;
    private String title;
    private String a_legal_name;
    private String stage_name;
    private String featured_a;
    private String album_title;
    private Integer track_number;
    private String genre;
    private String cut;
    private String producer;
    private String management;
    private String label;
    private String image_file;
    private String track_file;

    public track() {
    }

    public track(Long id) {
        this.id = id;
    }

    public track(Long id, String title, String a_legal_name, String stage_name, String featured_a, String album_title, Integer track_number, String genre, String cut, String producer, String management, String label, String image_file, String track_file) {
        this.id = id;
        this.title = title;
        this.a_legal_name = a_legal_name;
        this.stage_name = stage_name;
        this.featured_a = featured_a;
        this.album_title = album_title;
        this.track_number = track_number;
        this.genre = genre;
        this.cut = cut;
        this.producer = producer;
        this.management = management;
        this.label = label;
        this.image_file = image_file;
        this.track_file = track_file;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getA_legal_name() {
        return a_legal_name;
    }

    public void setA_legal_name(String a_legal_name) {
        this.a_legal_name = a_legal_name;
    }

    public String getStage_name() {
        return stage_name;
    }

    public void setStage_name(String stage_name) {
        this.stage_name = stage_name;
    }

    public String getFeatured_a() {
        return featured_a;
    }

    public void setFeatured_a(String featured_a) {
        this.featured_a = featured_a;
    }

    public String getAlbum_title() {
        return album_title;
    }

    public void setAlbum_title(String album_title) {
        this.album_title = album_title;
    }

    public Integer getTrack_number() {
        return track_number;
    }

    public void setTrack_number(Integer track_number) {
        this.track_number = track_number;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCut() {
        return cut;
    }

    public void setCut(String cut) {
        this.cut = cut;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getManagement() {
        return management;
    }

    public void setManagement(String management) {
        this.management = management;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getImage_file() {
        return image_file;
    }

    public void setImage_file(String image_file) {
        this.image_file = image_file;
    }

    public String getTrack_file() {
        return track_file;
    }

    public void setTrack_file(String track_file) {
        this.track_file = track_file;
    }

}