package generalstore.hooks;

import generalstore.utils.ConfigReader;
import generalstore.utils.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;

import static generalstore.utils.ReusableMethods.raporuAc;

public class Hooks {
    @BeforeAll
    public static void beforeAll(){
        Driver.serverBaslat(ConfigReader.getProperty("localIPAdres"), Integer.parseInt(ConfigReader.getProperty("localPort")));
    }
    @Before
    public void setUp(){
      Driver.getDriver().activateApp("com.androidsample.generalstore");
    }

    @After
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()){ // hata alısa çalışacak. Hata resmini çekip kapatacak
        byte[] screenshotAs = Driver.getDriver().getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshotAs,"image/png","Hata Resmi");
        }
      Driver.getDriver().terminateApp("com.androidsample.generalstore"); // Hata almazsa bu çalışacak ve kapatacak.
    }

    @AfterAll
    public static void afterAll(){
        Driver.uygulamayiKapat();
        Driver.serverKapat();
        raporuAc();
    }

}
