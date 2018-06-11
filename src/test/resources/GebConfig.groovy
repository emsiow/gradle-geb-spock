import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions

atCheckWaiting = 5

waiting {
    timeout = 5
    includeCauseInMessage = true
}

environments {

    chrome {
        driver = {
            WebDriverManager.chromedriver().setup()
            ChromeOptions options = new ChromeOptions()
            options.addArguments("--window-size=1920,1080")
            new ChromeDriver(options)
        }
    }

    chromeHeadless {
        driver = {
            WebDriverManager.chromedriver().setup()
            ChromeOptions options = new ChromeOptions()
            options.addArguments("headless")
            options.addArguments("--no-sandbox")
            options.addArguments("--window-size=1920,1080")
            new ChromeDriver(options)
        }
    }
}


