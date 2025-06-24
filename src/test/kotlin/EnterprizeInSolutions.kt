import com.codeborne.selenide.Condition.text
import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selectors.byText
import com.codeborne.selenide.Selenide.*
import com.codeborne.selenide.Selenide.open
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

class EnterprizeInSolutions {

    companion object {
        @BeforeAll
        fun setUp() {  //аннотация BeforeAll должна идти с методом static
            Configuration.browserSize = "1920x1080"
            Configuration.pageLoadStrategy = "eager"
        }
    }

    @Test
    fun shouldHaveEnterprisesPageTest() {
        open("https://github.com/")
        element(".HeaderMenu-nav").`$`(byText("Solutions")).hover()
        element(byText("Enterprises")).click()
        element("html").shouldHave(text("The AI-powered\ndeveloper platform"))
    }

}