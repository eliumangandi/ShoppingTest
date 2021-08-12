package com.applaudostudios.pojo;

import java.util.Arrays;

public class CharacterAPI {

    //@JsonProperty("char_id")
    private String char_id;
    private String name;
    private String birthday;
    private String occupations[] = null;
    private String img;
    private String status;
    private String appearance[] = null;
    private String nickname;
    private String portrayed;

    public CharacterAPI(){

    }

    public CharacterAPI(String char_id, String name, String birthday,
                      String[] occupations, String img, String status,
                      String[] appearance, String nickname, String portrayed) {
        this.char_id = char_id;
        this.name = name;
        this.birthday = birthday;
        this.occupations = occupations;
        this.img = img;
        this.status = status;
        this.appearance = appearance;
        this.nickname = nickname;
        this.portrayed = portrayed;
    }

    public void setChar_id(String char_id) {
        this.char_id = char_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setOccupations(String[] occupations) {
        this.occupations = occupations;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAppearance(String[] appearance) {
        this.appearance = appearance;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setPortrayed(String portrayed) {
        this.portrayed = portrayed;
    }

    public String getChar_id() {
        return char_id;
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public String[] getOccupations() {
        return occupations;
    }

    public String getImg() {
        return img;
    }

    public String getStatus() {
        return status;
    }

    public String[] getAppearance() {
        return appearance;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPortrayed() {
        return portrayed;
    }

    @Override
    public String toString() {
        return "Character{" +
                "char_id='" + char_id + '\'' +
                ", name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", occupations=" + Arrays.toString(occupations) +
                ", img='" + img + '\'' +
                ", status='" + status + '\'' +
                ", appearance=" + Arrays.toString(appearance) +
                ", nickname='" + nickname + '\'' +
                ", portrayed='" + portrayed + '\'' +
                '}';
    }

}
