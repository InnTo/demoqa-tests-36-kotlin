import com.codeborne.selenide.Condition.*
import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selectors.*
import com.codeborne.selenide.Selenide.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test


class BestContributorSelenide {

    companion object {
        @BeforeAll
        @JvmStatic // Важно добавить эту аннотацию
        fun setUp() {
            Configuration.browserSize = "1920x1080"
            Configuration.pageLoadStrategy = "eager"
        }
    }

    @Test
    fun findBestContributorTest() {
        open("https://github.com/selenide/selenide")
        element("div.Layout-sidebar").`$`(byText("Contributors"))
            .closest("h2").sibling(0).`$$`("li").first().hover()
        elements(".Popover").findBy(visible).shouldHave(text("Andrei Solntsev"))
    }
}