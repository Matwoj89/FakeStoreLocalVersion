package TestyPOM;

import PageObjects.CartPage;
import PageObjects.CheckoutPage;
import PageObjects.OrderReceivedPage;
import PageObjects.ProductPage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PaymentTests extends BaseTest {

    private String name = "Ola";
    private String lastName = "Nowak";
    private String countryCode = "BE";
    private String address = "Wielicka 2/15";
    private String postalCode = "80-001";
    private String city = "Sopot";
    private String phone = "66666666";
    private String emailAddress = "test1@testelka.pl";
    private String cardNumber = "4242424242424242";
    private String expirationDate = "0530";
    private String cvcCode = "123";

    @Test
    public void buyWithoutAccountTest() {
        ProductPage productPage = new ProductPage(driver).goTo("https://fakestore.testelka.pl/product/egipt-el-gouna/");
        productPage.demoNotice.close();
        CartPage cartPage = productPage.addToCart().viewCart();
        CheckoutPage checkoutPage = cartPage.goToCheckout();
        OrderReceivedPage orderReceivedPage = checkoutPage.typeName(name)
                .typeLastName(lastName)
                .chooseCountry(countryCode)
                .typeAddress(address)
                .typePostalCode(postalCode)
                .typeCity(city)
                .typePhone(phone)
                .typeEmail(emailAddress)
                .typeCardNumber(cardNumber)
                .typeCardExpirationDate(expirationDate)
                .typeCvcCode(cvcCode)
                .selectAcceptTerms()
                .order();
        boolean isOrderSuccessful = orderReceivedPage.isOrderSuccessful();
        assertTrue(isOrderSuccessful, "No order successful message found.");

    }
}
