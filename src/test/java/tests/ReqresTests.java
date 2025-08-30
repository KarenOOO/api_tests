package tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import models.ListUsersResponseModel;
import models.SingleUserResponseModel;
import models.CrudUserResponseModel;
import models.UserRequestModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static specs.UsersSpecs.*;


@Tag("all_api")
@Owner("@medina")
public class ReqresTests extends BaseTest {


    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Создание нового пользователя")
    void createUserTest() {
        UserRequestModel request = step("Подготовока данных для запроса", () ->
                new UserRequestModel("morpheus", "leader"));

        CrudUserResponseModel response = step("Создаем пользователя", () ->
                given(baseRequestSpec)
                        .body(request)
                        .when()
                        .post(USERS_PATH)
                        .then()
                        .spec(getResponseSpec(201))
                        .extract()
                        .as(CrudUserResponseModel.class));

        step("Проверка ответа", () -> {
            assertThat(response.getName()).isEqualTo(request.getName());
            assertThat(response.getJob()).isEqualTo(request.getJob());
            assertThat(response.getId())
                    .as("ID пользователя не должно быть null")
                    .isNotNull();
            assertThat(response.getCreatedAt())
                    .as("Созданная дата должна соответствовать ISO шаблону")
                    .matches("\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}\\.\\d{3}Z");
        });
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Получение списка пользователей")
    void usersListTest() {
        ListUsersResponseModel response = step("Получить список пользователей", () ->
                given(baseRequestSpec)
                        .queryParam("page", 2)
                        .when()
                        .get(USERS_PATH)
                        .then()
                        .spec(getResponseSpec(200))
                        .extract()
                        .as(ListUsersResponseModel.class));

        step("Проверка ответа", () -> {
            assertThat(response.getPage()).isEqualTo(2);
            assertThat(response.getData())
                    .as("Список пользователей не должен быть пустым")
                    .isNotEmpty();
        });
    }


    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Получение данных конкретного пользователя")
    void singleUserTest() {
        SingleUserResponseModel response = step("Получаем пользователя по ID", () ->
                given(baseRequestSpec)
                        .pathParam("id", 2)
                        .when()
                        .get(USER_BY_ID_PATH)
                        .then()
                        .spec(getResponseSpec(200))
                        .extract()
                        .as(SingleUserResponseModel.class));

        step("Проверка ответа", () -> {
            assertThat(response.getData().getId()).isEqualTo(2);
            assertThat(response.getData().getEmail())
                    .as("Email должен содержать @ и . символы")
                    .contains("@")
                    .contains(".");
        });
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Частичное обновление пользователя")
    void updateUserPatchMethodTest() {
        UserRequestModel request = step("Подготовока данных для запроса", () ->
                new UserRequestModel("neo", "the one"));

        CrudUserResponseModel response = step("Обновляем пользователя методом PATCH", () ->
                given(baseRequestSpec)
                        .pathParam("id", 2)
                        .body(request)
                        .when()
                        .patch(USER_BY_ID_PATH)
                        .then()
                        .spec(getResponseSpec(200))
                        .extract()
                        .as(CrudUserResponseModel.class));

        step("Проверка ответа", () -> {
            assertThat(response.getName()).isEqualTo(request.getName());
            assertThat(response.getJob()).isEqualTo(request.getJob());
        });
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Полное обновление пользователя")
    void updateUserPutMethodTest() {
        UserRequestModel request = step("Подготовока данных для запроса", () ->
                new UserRequestModel("neo", "the one"));

        CrudUserResponseModel response = step("Обновляем пользователя методом PUT", () ->
                given(baseRequestSpec)
                        .pathParam("id", 2)
                        .body(request)
                        .when()
                        .put(USER_BY_ID_PATH)
                        .then()
                        .spec(getResponseSpec(200))
                        .extract()
                        .as(CrudUserResponseModel.class));

        step("Проверка ответа", () -> {
            assertThat(response.getName()).isEqualTo(request.getName());
            assertThat(response.getJob()).isEqualTo(request.getJob());
        });
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Удаление пользователя" )
    void deleteUserTest() {
        step("Удаляем пользователя", () ->
                given(baseRequestSpec)
                        .pathParam("id", 2)
                        .when()
                        .delete(USER_BY_ID_PATH)
                        .then()
                        .spec(getResponseSpec(204)));
    }


}