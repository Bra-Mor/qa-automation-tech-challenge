package pages;

public class LoginPage extends BasePage {
    private String inputEmail = "//input[@placeholder='Ej: Nombre@empresa.com' and @type='email']";
    private String inputPassword = "//input[@placeholder='Tu contraseña' and @type='password']";
    private String loginButton = "//button[contains(@class, 'login-button')]";
    private String AderessoStudio2 = "//span[normalize-space()='Administrador']";
    private String clickAderesoStudio = "//span[normalize-space()='Adereso Studio']";

    public LoginPage() {
        super(driver);
    }

    public void navigateToAderesoWeb() {
        navigateTo("https://broly.adere.so/vue/#/login");
    }

    public void fillUsernameInput(String email) {
        write(inputEmail, email);
    }

    public void fillPasswordInput(String password) {
        write(inputPassword, password);
    }

    public void clickButton() {
        clickElement(loginButton);
    }

    public void clickNavigationBars() throws InterruptedException {
        clickElement(AderessoStudio2);
        Thread.sleep(2000);
        clickElement(clickAderesoStudio);
    }
}
