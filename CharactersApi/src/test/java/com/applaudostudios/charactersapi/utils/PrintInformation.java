package com.applaudostudios.charactersapi.utils;

import com.applaudostudios.charactersapi.pojo.CharacterAPI;

/*
   This class provides methods to print CharacterAPI objects information
   @author: Yonatan E Juarez
   @version: 08/19/2021
 */
public class PrintInformation {

    /*
    this method prints birthday from CharacterAPI object
    @param charApi CharacterAPI object
     */
    public static void printCharApiBirthday(CharacterAPI charApi){
        System.out.print(charApi.getName());
        System.out.print("'s birthday: " + charApi.getBirthday());
        System.out.println("");
        System.out.println("------------------------------------------------------");
    }

    /*
    this method prints all CharacterAPI objects information coming in the array
    @param charApiS CharacterAPI array
     */
    public static void printAllCharInfo(CharacterAPI[] charApiS){
        for (CharacterAPI charApi : charApiS) {
            printCharInfo(charApi);
        }
    }

    /*
    this method prints CharacterAPI object information
    @param charApi CharacterAPI object
     */
    public static void printCharInfo(CharacterAPI charApi){
        System.out.println("Character name: \"" + charApi.getName() + "\"");
        System.out.println("Portrayed: \"" + charApi.getPortrayed() + "\"");
        System.out.println("------------------------------------------------------");
    }

}
