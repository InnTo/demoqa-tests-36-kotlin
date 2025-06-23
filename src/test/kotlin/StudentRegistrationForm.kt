import com.codeborne.selenide.Condition
import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selectors
import com.codeborne.selenide.Selenide
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

class StudentRegistrationForm {

    companion object {
        @BeforeAll
        @JvmStatic // Важно добавить эту аннотацию
        fun beforeAll() {
            Configuration.browserSize = "1920x1080"
            Configuration.pageLoadStrategy = "eager"
            Configuration.baseUrl = "https://demoqa.com"
        }
    }

    @Test
    fun fillRegistrationFormTest() {
        Selenide.open("/automation-practice-form")

        //Заполнение формы
        Selenide.`$`("#firstName").setValue("Test")
        Selenide.`$`("#lastName").setValue("TestLastName")
        Selenide.`$`("#userEmail").setValue("Test@test.ru")
        Selenide.`$`(Selectors.byText("Male")).click()
        Selenide.`$`("#userNumber").setValue("8961530834")

        Selenide.`$`("#dateOfBirthInput").clear()
        Selenide.`$`(".react-datepicker__month-select").selectOption("April")
        Selenide.`$`(".react-datepicker__year-select").selectOption("2002")
        Selenide.`$$`(".react-datepicker__day").findBy(Condition.text("30")).click()

        Selenide.`$`("#subjectsInput").setValue("Maths")
        Selenide.`$$`(".subjects-auto-complete__option").findBy(Condition.text("Maths")).click() //. указывает, что это класс, а не тег, можно явно прописывать класс


        Selenide.`$`(Selectors.byText("Sports")).click()
        Selenide.`$`("#uploadPicture").uploadFromClasspath("test.jpg")
        Selenide.`$`("#currentAddress").setValue("Current test address")

        Selenide.`$`("#state").click()
        Selenide.`$`(Selectors.byText("Uttar Pradesh")).click()
        Selenide.`$`("#city").click()
        Selenide.`$`(Selectors.byText("Agra")).click()

        Selenide.`$`("#submit").click()

        //Проверка заполнения
        Selenide.`$`(".table-responsive").shouldHave(Condition.text("Test TestLastName"))
        Selenide.`$`(".table-responsive").shouldHave(Condition.text("Test@test.ru"))
        Selenide.`$`(".table-responsive").shouldHave(Condition.text("Male"))
        Selenide.`$`(".table-responsive").shouldHave(Condition.text("8961530834"))
        Selenide.`$`(".table-responsive").shouldHave(Condition.text("30 April,2002"))
        Selenide.`$`(".table-responsive").shouldHave(Condition.text("Maths"))
        Selenide.`$`(".table-responsive").shouldHave(Condition.text("Sports"))
        Selenide.`$`(".table-responsive").shouldHave(Condition.text("test.jpg"))
        Selenide.`$`(".table-responsive").shouldHave(Condition.text("Current test address"))
        Selenide.`$`(".table-responsive").shouldHave(Condition.text("Uttar Pradesh Agra"))
    }
}