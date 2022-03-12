package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;
import guru.qa.pages.components.Calendar;
import guru.qa.tests.StudentRegistrationFormWithTestBaseTests;
import io.qameta.allure.Step;


import java.io.File;
import java.util.logging.Logger;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Condition.text;


public class RegistrationPage {
    private Calendar calendarComponent = new Calendar();
    private static Logger log = Logger.getLogger(StudentRegistrationFormWithTestBaseTests.class.getName());



    private SelenideElement headerTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderRoleSelect = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            uploadPictureInput = $("#uploadPicture"),
            hobbiesUserSelect = $("#hobbiesWrapper"),
            currentAddressInput = $("#currentAddress"),
            stateSelect = $("#state"),
            stateSelectList = $("#stateCity-wrapper"),
            citySelect = $("#city"),
            citySelectList = $("#stateCity-wrapper"),
            getButtonDataFormOpen = $("#submit"),
            resultTables = $(".table-responsive"),
            getButtonDataFormClose = $("#closeLargeModal"),
            textModalWindow = $("#example-modal-sizes-title-lg");

    @Step("Открываем страницу с регистрацией")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        headerTitle.shouldHave(text("Student Registration Form"));
        return this;
    }
    @Step("Вводим Имя")
    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }
    @Step("Вводим Фамилию")
    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }
    @Step("Вводим Email")
    public RegistrationPage setEmailName(String userEmail) {
        userEmailInput.setValue(userEmail);
        return this;
    }

    @Step("Выбираем пол")
    public RegistrationPage setGender(String gender) {
        genderRoleSelect.$(byText(gender)).click();
        return this;
    }

    @Step("Выбираем дату рождения")
    public RegistrationPage setBirthDate(String day, String month, String year) {
        calendarComponent.setDate(day, month, year);
        return this;
    }

    @Step("Вводим номер телефона")
    public RegistrationPage setUserNumber(String userNumber) {
        userNumberInput.setValue(userNumber);
        return this;
    }

    @Step("Вводим специализацию (полное название)")
    public RegistrationPage setSubjectsFull(String inputText) {
        subjectsInput.click();
        subjectsInput.setValue(inputText).pressEnter();
        return this;
    }

    @Step("Вводим специализацию (часть названия)")
    public RegistrationPage setSubjectsShort(String inputText, String listText) {
        subjectsInput.click();
        subjectsInput.setValue(inputText);
        $(byText(listText)).click();
        return this;
    }

    @Step("Выбираем хобби")
    public RegistrationPage setHobbiesUser(String[] hobbiesUser) {
        for (String user : hobbiesUser) {
            hobbiesUserSelect.$(byText(user)).click();
        }
        return this;
    }

    @Step("Вводим адрес")
    public RegistrationPage setCurrentAddress(String Address) {
        currentAddressInput.setValue(Address);
        return this;
    }

    @Step("Выбираем штат")
    public RegistrationPage selectState(String state) {
        stateSelect.click();
        stateSelectList.$(byText(state)).click();
        return this;
    }

    @Step("Выбираем город")
    public RegistrationPage selectCity(String city) {
        citySelect.click();
        citySelectList.$(byText(city)).click();
        return this;
    }

    @Step("Проверяем название формы")
    public RegistrationPage checkForm(String contentLable, String contentValues) {
        resultTables.$(byText(contentLable)).parent().shouldHave(text(contentValues));
        return this;
    }

    @Step("Проверяем содержимое полей таблицы с результатами")
    public RegistrationPage checkFormIteration(String contentLable, String[] contentValues) {
        for (String value : contentValues) {
            resultTables.$(byText(contentLable)).parent().shouldHave(text(value));
        }
        return this;
    }

    @Step("Проверяем, что таблица с результатами открылась")
    public RegistrationPage openResultDataForm(String textModal) {
        getButtonDataFormOpen.click();
        textModalWindow.shouldHave(text(textModal));
        return this;
    }

    @Step("Закрываем таблицу с результатами")
    public RegistrationPage closeResultDataForm() {
        getButtonDataFormClose.click();
        getButtonDataFormClose.shouldNotBe(visible);
        return this;
    }


}
