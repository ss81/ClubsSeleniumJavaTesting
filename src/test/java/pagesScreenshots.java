import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class pagesScreenshots {

    @Test
    public void testPages() {
        System.setProperty("webdriver.chrome.driver", "./chromedriver-2.32");

        WebDriver driver = new ChromeDriver();

        driver.get("http://www.raiders.com/news/article-1/Bridgestone-Elite-Performance-Moment-Of-The-Week-Preseason-Week-4/8dd0f9d8-475f-4f6d-869a-71673a9d1e15");

        driver.manage().window().maximize();
        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportRetina(100, 0, 0, 2)).takeScreenshot(driver);
        File actualFile = new File("./111.png");
        try {
            ImageIO.write(screenshot.getImage(), "png", actualFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver.close();
    }
}
