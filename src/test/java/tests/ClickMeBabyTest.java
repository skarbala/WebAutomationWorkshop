package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ClickMeBabyTest {

    @Test
    void itShouldDisplayOneClick(){
        // 1. otvorim stranku
        open("http://ajtyvit-app.westeurope.cloudapp.azure.com:8080/clickmebaby.php");
        // 2. kliknem na tlacidlo click me baby
        $(byId("clickMe")).click();
        // 3. overim pocet zobrazenych klikov
        $(byId("clicks")).shouldHave(Condition.text("1"));
        // 4. over text 'klik' na stranke
        $(byCssSelector("p.description")).shouldHave(Condition.text("klik"));
    }

    @Test
    void itShouldDisplayTwoClicks(){
        // 1. otvorim stranku
        open("http://ajtyvit-app.westeurope.cloudapp.azure.com:8080/clickmebaby.php");
        // 2. kliknem na tlacidlo click me baby 2x
        $(byId("clickMe")).click();
        $(byId("clickMe")).click();
        // 3. overim pocet zobrazenych klikov
        $(byId("clicks")).shouldHave(Condition.text("2"));
        // 4. over text 'kliky' na stranke
        $(byCssSelector("p.description")).shouldHave(Condition.text("kliky"));
    }

    @Test
    void itShouldDisplayFiveClicks(){
        open("http://ajtyvit-app.westeurope.cloudapp.azure.com:8080/clickmebaby.php");
        // 5x klikni na tlacidlo
        for (int i = 0; i < 5 ; i++) {
            $(byId("clickMe")).click();
        }
        // over pocet klikov
        $(byId("clicks")).shouldHave(Condition.text("5"));
        $(byCssSelector("p.description")).shouldHave(Condition.text("klikov"));
    }

    @Test
    void itShouldDisplayZeroClicksOnPageOpen() {
        open("http://ajtyvit-app.westeurope.cloudapp.azure.com:8080/clickmebaby.php");
        $(byId("clicks")).shouldHave(Condition.text("0"));
        $(byCssSelector("p.description")).shouldHave(Condition.text("klikov"));
    }

    @Test
    void itShouldDisplayCorrectTextForClickMeButton() {
        open("http://ajtyvit-app.westeurope.cloudapp.azure.com:8080/clickmebaby.php");
        $(byId("clickMe")).shouldHave(Condition.text("Click me !"));
    }

    @Test
    void itShouldDisplayHeading() {
        open("http://ajtyvit-app.westeurope.cloudapp.azure.com:8080/clickmebaby.php");
        $(byCssSelector("h1"))
                .shouldBe(Condition.visible)
                .shouldHave(Condition.exactText("Click me baby one more time"));

    }
}
