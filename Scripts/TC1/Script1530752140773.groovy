import java.util.regex.Matcher
import java.util.regex.Pattern

import org.openqa.selenium.WebDriver

import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

Pattern pattern = Pattern.compile('https://www.googletagmanager.com/ns.html\\?id=GTM-[\\w]+')
WebUI.openBrowser('')
WebUI.navigateToUrl('http://demoaut-mimic.kazurayam.com/7728_testbed.html')

WebDriver driver = DriverFactory.getWebDriver()
def pageSource = driver.getPageSource()
WebUI.comment("${pageSource}")

Matcher matcher = pattern.matcher(pageSource)

def found = matcher.find()        // call find() method rather than matches() method
WebUI.verifyEqual(found, true)

def found2 = matcher.matches()
WebUI.verifyEqual(found2, false)

WebUI.closeBrowser()
