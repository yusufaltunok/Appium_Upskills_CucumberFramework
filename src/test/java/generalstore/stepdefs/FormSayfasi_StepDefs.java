package generalstore.stepdefs;

import generalstore.pages.FormSayfasi;
import generalstore.utils.ReusableMethods;
import io.appium.java_client.AppiumBy;
import io.cucumber.java.en.*;
import org.junit.Assert;

import static generalstore.utils.Driver.driver;

public class FormSayfasi_StepDefs {
    FormSayfasi formSayfasi = new FormSayfasi();
    @When("Ulke menusundan {string} secilir")
    public void ulke_menusundan_secilir(String ulke) {
        formSayfasi.ulkeMenusu.click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + ulke + "\"))"));
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"" + ulke + "\"]")).click();
    }

    @When("isim kutusuna {string} girilir")
    public void isim_kutusuna_girilir(String isim) {
        formSayfasi.isimAlani.sendKeys(isim);
    }

    @When("cinsiyet seceneklerinden {string} secilir")
    public void cinsiyet_seceneklerinden_secilir(String cinsiyet) {
        if (cinsiyet.equalsIgnoreCase("female")) {
            formSayfasi.cinsiyetFemale.click();
        } else {
            formSayfasi.cinsiyetMale.click();
        }
    }

    @When("Lets Shop butonuna tiklanir")
    public void lets_shop_butonuna_tiklanir() {
        formSayfasi.letsShopButonu.click();
    }

    @Then("Sayfa basliginin {string} oldugu dogrulanir")
    public void sayfa_basliginin_oldugu_dogrulanir(String baslik) {
        ReusableMethods.bekle(2);
        Assert.assertEquals(formSayfasi.sayfaBasligi.getText(), baslik);
    }

    @And("isim kutusu bos birakilir")
    public void isimKutusuBosBirakilir() {
        formSayfasi.isimAlani.sendKeys("");
    }

    @Then("Hata mesajinin {string} oldugu dogrulanir")
    public void hataMesajininOlduguDogrulanir(String mesaj) {
        Assert.assertEquals(formSayfasi.hataMesaji.getAttribute("name"), mesaj);
    }
}
