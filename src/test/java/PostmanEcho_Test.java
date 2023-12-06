import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static com.google.common.base.Predicates.equalTo;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class PostmanEcho_Test {

    @Test
    void shouldReturn() {
        // Given - When - Then
// Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .body("data") // отправляемые данные (заголовки и query можно выставлять аналогично)
// Выполняемые действия
                .when()
                .post("/post")
// Проверки
                .then()
                .statusCode(200)
                .body("data", Matchers.is("data"))
                //.body(matchesJsonSchemaInClasspath("postmanecho.schema.json"))
        ;
    }
}
// читать сюда
// https://testit.software/blog/post/rest-assured-i-postman-dva-podhoda-k-testirovaniyu-api
//https://habr.com/ru/companies/alfa/articles/745854/
