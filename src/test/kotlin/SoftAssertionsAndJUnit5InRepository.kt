import com.codeborne.selenide.Condition.*
import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selectors.*
import com.codeborne.selenide.Selenide.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test


class SoftAssertionsAndJUnit5InRepository {

    companion object {
        @BeforeAll
        fun setUp() {  //аннотация BeforeAll должна идти с методом static
            Configuration.browserSize = "1920x1080"
            Configuration.pageLoadStrategy = "eager"
        }
    }

    @Test
    fun shouldHaveSoftAssertionsAndJUnit5InRepositoryTest() {
        open("https://github.com/selenide/selenide")
        `$`("#repository-container-header").`$`(byText("Wiki"))
            .closest("a").click()
        `$`(".markdown-body").`$`("ul").shouldHave(text("Soft assertions"))

        `$`(".markdown-body").`$`(byText("Soft assertions")).click()
        `$`("#wiki-content").shouldHave(text("Using JUnit5 extend test class:"))
    }
}