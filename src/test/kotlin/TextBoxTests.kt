import com.codeborne.selenide.Condition
import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

class TextBoxTests {

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
    fun fillFormTest() {
        Selenide.open("/text-box")
        Selenide.`$`("#userName").setValue("Test")
        Selenide.`$`("#userEmail").setValue("Test@test.ru")
        Selenide.`$`("#currentAddress").setValue("Test address")
        Selenide.`$`("#permanentAddress").setValue("Another test address")
        Selenide.`$`("#submit").click()

        Selenide.`$`("#output #name").shouldHave(Condition.text("Test"))
        Selenide.`$`("#output #email").shouldHave(Condition.text("Test@test.ru"))
        Selenide.`$`("#output #currentAddress").shouldHave(Condition.text("Test address"))
        Selenide.`$`("#output #permanentAddress").shouldHave(Condition.text("Another test address"))
    }

}
