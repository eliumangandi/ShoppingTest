package com.applaudostudios.charactersapi.charinfo;

import com.applaudostudios.charactersapi.pojo.CharacterAPI;
import com.applaudostudios.charactersapi.utils.PrintInformation;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

/*
   This class enables using testng framework
   @author: Yonatan E Juarez
   @version: 08/19/2021
 */
public class CharacterAuto {

    @Test
    public void charInfoAuto(){
        //this objet stores the response from the API
        Response response = RestAssured.get("https://www.breakingbadapi.com/api/characters/1");

        //converting the response to CharacterAPI array
        var characterApi = response.getBody().as(CharacterAPI[].class);

        //printing birthday info
        PrintInformation.printCharApiBirthday(characterApi[0]);

        //getting response from all characters
        response = RestAssured.get("https://www.breakingbadapi.com/api/characters/");

        //converting the response to CharacterAPI array
        var allCharApi = response.getBody().as(CharacterAPI[].class);

        //printing characters information
        PrintInformation.printAllCharInfo(allCharApi);


        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200);


    }

}
