package org.selenium.apiactions;

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

public class AddToCartApi {

    DriverManager driverManager;
    Properties prop;

    private Cookies cookies;

    public AddToCartApi() {

    }

    public AddToCartApi(Cookies cookies) {
        this.cookies = cookies;
    }

    public Cookies getCookies() {
        return cookies;
    }

    public Response productApi(String productID,String quantity) {
        driverManager = new DriverManager();
         Cookies cookies = new Cookies();
        prop = driverManager.init_properties(prop);
        Header header = new Header("content-type", "application/x-www-form-urlencoded");
        Headers headers = new Headers(header);
        HashMap<String, String> formPaths = new HashMap<>();
        formPaths.put("product_sku", "");

        formPaths.put("product_id", productID);
        // formPaths.put("woocommerce-register-nonce",fetchNonceValueWithJSoup());
        formPaths.put("quantity", quantity);
        Response responsetype = given()

                .baseUri(prop.getProperty("Baseurl"))
                .headers(headers)
                .formParams(formPaths)
                .cookies(cookies)
                .log().all()
                .when()
                .post("/?wc-ajax=add_to_cart")
                .then()
                .log()
                .all()
                .extract()
                .response();

        if (responsetype.statusCode() != 200) {
            throw new RuntimeException("Abort!!!!!");
        }

        this.cookies = responsetype.getDetailedCookies();
        System.out.println("CART COOKIES ARE:::==>"+responsetype.getDetailedCookies());
        return responsetype;

    }
}
