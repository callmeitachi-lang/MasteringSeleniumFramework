package org.selenium.apiactions;

import groovyjarjarantlr4.v4.codegen.OutputModelWalker;
import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.selenium.practice.driverfactory.DriverManager;

import java.util.HashMap;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class SignupApi {
    Properties prop;
    DriverManager driverManager = new DriverManager();
    private Cookies cookies;


    public Cookies getCookies()
    {
        return this.cookies;
    }

    /**
     * Using Jsoup to retrive the value by using css value
     * use the method if the api response is in HTML(To parse it)
     * @return the unique value of the element
     */
    public String fetchNonceValueWithJSoup()
    {
        Response response=getSigUpDetails();
        Document doc=Jsoup.parse(response.body().prettyPrint());
        Element element =doc.selectFirst("#woocommerce-register-nonce");
return element.attr("value");
    }


    private Response getSigUpDetails() {
        driverManager = new DriverManager();
        cookies = new Cookies();
        prop = driverManager.init_properties(prop);
        Response response = given()
                .cookies(cookies)
                .baseUri(prop.getProperty("Baseurl"))
                .log().all()
                .when()
                .get("/account")
                .then()
                .log()
                .all()
                .extract()
                .response();
        if (response.statusCode() != 200) {
            throw new RuntimeException("Abort!!!!!");
        }
        return response;

    }


    public Response registerApi() {
        driverManager = new DriverManager();
       Cookies cookies = new Cookies();
        prop = driverManager.init_properties(prop);
        Header header=new Header("content-type","application/x-www-form-urlencoded");
        Headers headers=new Headers(header);
        HashMap<String,String> formPaths=new HashMap<>();
        formPaths.put("username","userDemo6");
        formPaths.put("email","userDemo6@gmail.com");
        formPaths.put("password","userDemo@123467");
        formPaths.put("woocommerce-register-nonce",fetchNonceValueWithJSoup());
        formPaths.put("register","Register");


        Response responsetype = given()

                .baseUri(prop.getProperty("Baseurl"))
                .headers(headers)
                .formParams(formPaths)
                .cookies(cookies)
                .log().all()
                .when()
                .post("/account")
                .then()
                .log()
                .all()
                .extract()
                .response();

        if (responsetype.statusCode() != 302) {
            throw new RuntimeException("Abort!!!!!");
        }

        this.cookies=responsetype.getDetailedCookies();
        return responsetype;

    }


}
