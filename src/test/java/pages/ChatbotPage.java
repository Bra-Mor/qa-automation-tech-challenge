package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChatbotPage extends BasePage {
    private String selectBot = "//span[normalize-space()='ZapBot']";
    private String IntenstsOption = "//i18n-t[normalize-space()='Intents']";
    private String intentAdd = "//span[normalize-space()='Añadir intención']";
    private String nameIntent = "//input[@placeholder='Nombre de la intención']";
    private String descriptionIntent = "//input[@placeholder='Descripción de la intención']";
    private String saveIntent = "//span[normalize-space()='Guardar']";
    private String newExample = "//span[normalize-space()='Nuevo ejemplo']";
    private String messageClient = "//input[@placeholder='Mensaje del cliente']";
    private String Alert = "//div[@role='alert' and contains(@class,'Vue-Toastification__toast-body')]";
    private String buttonOptions = "//button[@aria-haspopup='menu']";
    private String editOption = "//div[@class='v-list-item-title' and text()='Editar']";
    private String buttonTestBot = "//button[contains(@class, 'btn-floating-right-bottom')]";
    private String inputBot = "//textarea[@placeholder='Escribe un mensaje']";
    private String senButton = "//button[.//span[text()='Enviar']]";
    private String obtenerText = "//span[contains(@class,'a-tag--primary')]//span[last()]";
    By filterTable = By.xpath("//td//span");

    public ChatbotPage() {
        super(driver);
    }

    public void switchTabAndSelectBot() {
        switchToNewTab();
    }

    public void redirectToChatbotDashboard() {
        clickElement(selectBot);
    }

    public void SelectIntentsOption() {
        clickElement(IntenstsOption);
    }

    public void addIntent(String name, String description, String exampleMessage) throws InterruptedException {
        clickElement(intentAdd);
        Thread.sleep(2000);
        write(nameIntent, name);
        write(descriptionIntent, description);
        clickElement(newExample);
        write(messageClient, exampleMessage);
        clickElement(saveIntent);
    }

    public void editIntent(String name, String description, String exampleMessage) throws InterruptedException {
        Thread.sleep(2000);
        write(nameIntent, name);
        write(descriptionIntent, description);
        clickElement(newExample);
        write(messageClient, exampleMessage);
        clickElement(saveIntent);
    }

    public String getAlert() {
        return textFromElement(Alert);
    }

    public void editAlert() {
        clickElement(buttonOptions);
        clickElement(editOption);
    }

    public void testBot() throws InterruptedException {
        Thread.sleep(2000);
        clickElement(buttonTestBot);
        Thread.sleep(2000);
        write(inputBot, "Precio?");
        clickElement(senButton);
    }

    public String getBotResponse() throws InterruptedException {
        Thread.sleep(5000);
        return textFromElement(obtenerText);

    }

    public List<WebElement> filterTable() {
        return bringMeAllElements(filterTable);
    }
}
