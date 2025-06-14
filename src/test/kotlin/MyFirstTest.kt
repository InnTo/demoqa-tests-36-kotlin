import org.junit.jupiter.api.Test
import com.codeborne.selenide.Selenide.* // Статический импорт для Selenide

class MyFirstTest {

    @Test
    fun `test google search`() {
        open("https://www.google.com")
        element("[name=q]").setValue("Selenide").pressEnter()
        // Add assertions here (e.g., assertThat(title()).contains("Selenide"))
    }
}