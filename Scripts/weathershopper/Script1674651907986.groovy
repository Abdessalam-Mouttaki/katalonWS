import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.By as By
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser(GlobalVariable.website)

temperature = (WebUI.getText(findTestObject('Object Repository/Page_Current Temperature/Temperature')).split()[0]).toInteger()

if (temperature < 19) {
    WebUI.click(findTestObject('Object Repository/Page_Current Temperature/button_Buy moisturizers'))

    products = ['almond', 'aloe']
} else {
    WebUI.click(findTestObject('Object Repository/Page_Current Temperature/button_Buy sunscreens'))

    products = ['spf-30', 'spf-50']
}

product_1 = (products[0])

println(product_1)

product_2 = (products[1])

println(products[2])

xpath_product_1 = "//p[contains(translate(., 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'),'$product_1')]/following-sibling::p"

xpath_product_2 = "//p[contains(translate(., 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'),'$product_2')]/following-sibling::p"

product_1 = WebUI.modifyObjectProperty(findTestObject('Object Repository/Products/product_1'), 'xpath', 'equals', xpath_product_1, 
    true)

product_2 = WebUI.modifyObjectProperty(findTestObject('Object Repository/Products/product_2'), 'xpath', 'equals', xpath_product_2, 
    true)

List<WebElement> products_1_prices = WebUI.findWebElements(product_1, 10)

product_1_prices = []

for (int i = 0; i < products_1_prices.size; i++) {
    a = (products_1_prices.get(i).text.split()[-1])

    product_1_prices.add(a)
}

min_price_1 = product_1_prices.min()

List<WebElement> products_2_prices = WebUI.findWebElements(product_2, 10)

product_2_prices = []

for (int i = 0; i < products_2_prices.size; i++) {
    a = (products_2_prices.get(i).text.split()[-1])

    product_2_prices.add(a)
}

min_price_2 = product_2_prices.min()

xpath_add_product_1 = "//p[contains(translate(., 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'),'$min_price_1')]/following-sibling::button"

xpath_add_product_2 = "//p[contains(translate(., 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'),'$min_price_2')]/following-sibling::button"

add_product_1 = WebUI.modifyObjectProperty(findTestObject('Object Repository/Products/btn_add_product_1'), 'xpath', 'equals', 
    xpath_add_product_1, true)

add_product_2 = WebUI.modifyObjectProperty(findTestObject('Object Repository/Products/btn_add_product_2'), 'xpath', 'equals', 
    xpath_add_product_2, true)

WebUI.click(add_product_1)

WebUI.click(add_product_2)

WebUI.click(findTestObject('Page_The Best Sunscreens in the World/span_2 item(s)'))

WebUI.click(findTestObject('Object Repository/Page_Cart Items/button_Pay with Card'))

WebUI.sendKeys(findTestObject('Page_Cart Items/input_email'), 'test@test.com')


public void typeSlowly(String text, TestObject objet) {
	
	for (int i; i<text.length(); i++) {
		
		WebUI.sendKeys(objet, text.getAt(i))
		
	}
}


typeSlowly("4242424242424242", findTestObject('Object Repository/Page_Cart Items/input_card_number'))


typeSlowly("12/23", findTestObject('Object Repository/Page_Cart Items/input_cc-exp'))

WebUI.sendKeys(findTestObject('Page_Cart Items/input_cc-csc'), '123')

WebUI.sendKeys(findTestObject('Page_Cart Items/input_Code_Postal'), '75000')

WebUI.click(findTestObject('Page_Cart Items/button_Submit'))

WebUI.verifyElementText(findTestObject('Page_Confirmation/h2_PAYMENT SUCCESS'), 'PAYMENT SUCCESS')

WebUI.closeBrowser()

