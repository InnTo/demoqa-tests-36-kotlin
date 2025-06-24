import com.codeborne.selenide.Condition.*
import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selectors.*
import com.codeborne.selenide.Selenide.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

class StudentRegistrationForm {

    companion object {
        @BeforeAll
        @JvmStatic // Важно добавить эту аннотацию
        fun setUp () {
            Configuration.browserSize = "1920x1080"
            Configuration.pageLoadStrategy = "eager"
            Configuration.baseUrl = "https://demoqa.com"
        }
    }

    @Test
    fun fillRegistrationFormTest() {
        open("/automation-practice-form")

        executeJavaScript<Unit>("$('footer').remove();");
        executeJavaScript<Unit>("$('#fixedban').remove();");


        //Заполнение формы
        element("#firstName").setValue("Test")
        element("#lastName").setValue("TestLastName")
        element("#userEmail").setValue("Test@test.ru")
        element(byText("Male")).click()
        element("#userNumber").setValue("8961530834")

        element("#dateOfBirthInput").clear()
        element(".react-datepicker__month-select").selectOption("April")
        element(".react-datepicker__year-select").selectOption("2002")
        elements(".react-datepicker__day").findBy(text("30")).click()

        element("#subjectsInput").setValue("Maths")
        elements(".subjects-auto-complete__option").findBy(text("Maths")).click() //. указывает, что это класс, а не тег, можно явно прописывать класс


        element(byText("Sports")).click()
        element("#uploadPicture").uploadFromClasspath("test.jpg")
        element("#currentAddress").setValue("Current test address")

        element("#state").click()
        element(byText("Uttar Pradesh")).click()
        element("#city").click()
        element(byText("Agra")).click()

        element("#submit").click()

        //Проверка заполнения
        element(".table-responsive").shouldHave(text("Test TestLastName"))
        element(".table-responsive").shouldHave(text("Test@test.ru"))
        element(".table-responsive").shouldHave(text("Male"))
        element(".table-responsive").shouldHave(text("8961530834"))
        element(".table-responsive").shouldHave(text("30 April,2002"))
        element(".table-responsive").shouldHave(text("Maths"))
        element(".table-responsive").shouldHave(text("Sports"))
        element(".table-responsive").shouldHave(text("test.jpg"))
        element(".table-responsive").shouldHave(text("Current test address"))
        element(".table-responsive").shouldHave(text("Uttar Pradesh Agra"))
    }
}