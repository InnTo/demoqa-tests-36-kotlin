import com.codeborne.selenide.Condition.text
import com.codeborne.selenide.Configuration
import com.codeborne.selenide.DragAndDropOptions
import com.codeborne.selenide.Selenide.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

class DragAndDrop {

    companion object {
        @BeforeAll
        fun setUp() {  //аннотация BeforeAll должна идти с методом static
            Configuration.browserSize = "1920x1080"
            Configuration.pageLoadStrategy = "eager"
        }
    }

    @Test
    fun dragAndDropAcrionTest() {
        open("https://the-internet.herokuapp.com/drag_and_drop")
        actions()
            .clickAndHold(element("#column-a"))
            .moveToElement(element("#column-b"))
            .release()
            .build()
            .perform()
        element("#column-a").shouldHave(text("B"))
        element("#column-b").shouldHave(text("A"))
    }

    @Test
    fun dragAndDropElementTest() {
        open("https://the-internet.herokuapp.com/drag_and_drop")
        element("#column-a").dragAndDrop(DragAndDropOptions.to("#column-b"))

        element("#column-a").shouldHave(text("B"))
        element("#column-b").shouldHave(text("A"))
    }
}