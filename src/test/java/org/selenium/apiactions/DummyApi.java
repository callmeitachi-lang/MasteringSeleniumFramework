package org.selenium.apiactions;

import io.restassured.http.Cookies;

public class DummyApi {

    public static void main(String[] args) {
        SignupApi signupApi = new SignupApi();

        signupApi.registerApi();
                       signupApi.getCookies();
System.out.println("Register cookies:::==>"+signupApi.getCookies());

        AddToCartApi addToCartApi=new AddToCartApi( signupApi.getCookies());

        addToCartApi.productApi("1198","1");


    }
}
