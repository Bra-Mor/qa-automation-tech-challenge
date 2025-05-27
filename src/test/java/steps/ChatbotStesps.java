package steps;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.*;

import pages.LoginPage;
import pages.ChatbotPage;

public class ChatbotStesps {
    LoginPage login = new LoginPage();
    ChatbotPage chatBotsPage = new ChatbotPage();

    @Given("I navigate to broly.adere.so")
    public void inNavigateAderesoPage() {
        login.navigateToAderesoWeb();
    }

    @When("I enter a valid username and password")
    public void login() {
        login.fillUsernameInput("usuarioPrueba.com");
        login.fillPasswordInput("test123");
        login.clickButton();
    }

    @When("I navigate to Adereso Studio")
    public void clickAderesoStudio() throws InterruptedException {
        login.clickNavigationBars();
    }

    @When("I click on the chatbot ZapBot")
    public void clickChatBot() {
        chatBotsPage.switchTabAndSelectBot();
        chatBotsPage.redirectToChatbotDashboard();
    }

    @When("I select the intents section")
    public void createIntents() throws InterruptedException {
        Thread.sleep(3000);
        chatBotsPage.SelectIntentsOption();
    }

    @When("I add a new intent")
    public void addIntent() throws InterruptedException {
        chatBotsPage.addIntent("consulta", "Usuario pregunta por el precio de un producto", "¿precio?");
    }

    @Then("a success alert should appear")
    public void validateAlert() throws InterruptedException {
        Thread.sleep(1000);
        String textAlert = chatBotsPage.getAlert();
        Assert.assertEquals("Intenciones guardadas exitosamente", textAlert);
    }

    @When("I click the action button and select edit")
    public void clickActionAndSelectEdit() throws InterruptedException {
        Thread.sleep(2000);
        chatBotsPage.editAlert();
    }

    @When("I update the intent")
    public void editIntent() throws InterruptedException {
        chatBotsPage.editIntent("Saludo", "Usuario saluda", "Hola!");

    }

    @When("I add an intent with an already existing name")
    public void addIntentWithExistingName() throws InterruptedException {
        chatBotsPage.addIntent("consulta", "test", "");
    }

    @Then("an error alert should appear")
    public void shouldSeeUpdateErrorAlert() throws InterruptedException {
        Thread.sleep(1000);
        String textAlert = chatBotsPage.getAlert();
        Assert.assertEquals("Error al actualizar las intenciones", textAlert);
    }

    @When("I add a new intent without filling in the required fields")
    public void createIntentWithoutDescription() throws InterruptedException {
        chatBotsPage.addIntent("Pregunta", "Usuario tiene una consulta", "");
    }

    @Then("the intent should not be added to the list")
    public void verifyIntentNotAddedToList() {
        List<WebElement> lista = chatBotsPage.filterTable();
        for (WebElement elemento : lista) {
            String texto = elemento.getText().trim();
            Assert.assertFalse(texto.isEmpty(), "Se encontró un campo vacío en la tabla.");
        }
    }

    @When("I click on the Edit button and type a word from the intent examples")
    public void clickOnTestBotButton() throws InterruptedException {
        Thread.sleep(2000);
        chatBotsPage.testBot();
    }

    @Then("the bot should recognize the intent")
    public void verifyBotRecognizesIntent() throws InterruptedException {
        String intention = chatBotsPage.getBotResponse();
        Assert.assertEquals("CONSULTA", intention);
    }

}
