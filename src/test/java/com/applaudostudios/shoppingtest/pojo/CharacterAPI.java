package com.applaudostudios.shoppingtest.pojo;

import java.util.Arrays;

/*
   This class provides methods to print CharacterAPI objects information
   @author: Yonatan E Juarez
   @version: 08/19/2021
 */
public class CharacterAPI {

    //properties definition
    private String char_id;
    private String name;
    private String birthday;
    private String occupations[] = null;
    private String img;
    private String status;
    private String appearance[] = null;
    private String nickname;
    private String portrayed;

    /*
    default constructor
     */
    public CharacterAPI(){

    }

    /*
    this constructor enables create an object receiving all values
    @param char_id
    @param name
    @param birthday
    @param occupations
    @param status
    @param appearance
    @param nickname
    @param portrayed
     */
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

    /*
    set value to char_id property
    @param char_id String object
     */
    public void setChar_id(String char_id) {
        this.char_id = char_id;
    }

    /*
    set value to name property
    @param name String object
    */
    public void setName(String name) {
        this.name = name;
    }

    /*
    set value to birthday property
    @param birthday String object
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /*
    set value to occupations property
    @param occupations String Array
     */
    public void setOccupations(String[] occupations) {
        this.occupations = occupations;
    }

    /*
    set value to img property
    @param img String object
     */
    public void setImg(String img) {
        this.img = img;
    }

    /*
    set value to img status property
    @param status String object
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /*
    set value to appearance status property
    @param appearance String array
     */
    public void setAppearance(String[] appearance) {
        this.appearance = appearance;
    }

    /*
    set value to appearance nickname property
    @param appearance String object
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /*
    set value to appearance portrayed property
    @param portrayed String object
     */
    public void setPortrayed(String portrayed) {
        this.portrayed = portrayed;
    }

    /*
    @return char_id
     */
    public String getChar_id() {
        return char_id;
    }

    /*
    @return name
     */
    public String getName() {
        return name;
    }

    /*
    @return birthday
     */
    public String getBirthday() {
        return birthday;
    }

    /*
    @return occupations
     */
    public String[] getOccupations() {
        return occupations;
    }

    /*
    @return img
     */
    public String getImg() {
        return img;
    }

    /*
    @return status
     */
    public String getStatus() {
        return status;
    }

    /*
    @return appearance
     */
    public String[] getAppearance() {
        return appearance;
    }

    /*
    @return nickname
     */
    public String getNickname() {
        return nickname;
    }

    public String getPortrayed() {
        return portrayed;
    }

    /*
    this method return a String sequence with actual values
    @return String sequence
     */
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
