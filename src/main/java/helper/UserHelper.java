package helper;
import constants.Constants;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import static io.restassured.RestAssured.given;

public class UserHelper {

    @Step("Генерим тело пользователя с паролем заданной длинны")
    public UserRegistration generateRandomUserCredentials(int passwordLength) {
        String name = RandomStringUtils.randomAlphabetic(8);
        String email = RandomStringUtils.randomAlphabetic(5) + "@" + RandomStringUtils.randomAlphabetic(4) + ".com";
        String password = RandomStringUtils.randomAlphabetic(passwordLength);
        UserRegistration userRegistration = new UserRegistration(email, password, name);
        return userRegistration;
    }

    @Step("Регестрируем пользователя через бэкенд метод")
    public User apiUserRegistration(UserRegistration userRegistration) {
        given().log().all()
                .header("Content-type", "application/json")
                .baseUri(Constants.hostname)
                .body(userRegistration)
                .when()
                .post(Constants.REGISTER_USER).then().statusCode(200);
        User user = new User(userRegistration.getEmail(), userRegistration.getPassword());
        return user;
    }

    @Step("Удаляем пользователя через бэкенд метод")
    public void deleteUser(User user) {
        // Логинимся пользователем
        Response response = given().log().all()
                .header("Content-type", "application/json")
                .baseUri(Constants.hostname)
                .body(user)
                .when()
                .post(Constants.USER_LOGIN);
        //Удаляем пользователя
        given().log().all()
                .header("authorization", response.getBody().as(LoginUserResponse.class).getAccessToken())
                .header("Content-type", "application/json")
                .baseUri(Constants.hostname)
                .when()
                .delete(Constants.USER_RUD).then().statusCode(202);
    }
}