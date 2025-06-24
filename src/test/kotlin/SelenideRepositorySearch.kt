import com.codeborne.selenide.Condition.*
import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selectors.*
import com.codeborne.selenide.Selenide.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

class SelenideRepositorySearch {

    companion object {
        @BeforeAll
        fun setUp() {  //аннотация BeforeAll должна идти с методом static
            Configuration.browserSize = "1920x1080"
            Configuration.pageLoadStrategy = "eager"
        }
    }

    @Test
    fun shouldFindSelenideRepositoryAtTheTopTest() {
        open("https://github.com/")
        element(".search-input").click()
        element("#query-builder-test").setValue("Selenide").pressEnter()
        elements("[data-testid=results-list]").first().`$`("a").click()
        element("#repository-container-header").shouldHave(text("selenide / selenide"))
    }
}