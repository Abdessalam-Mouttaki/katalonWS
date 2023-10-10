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
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.url_global)

temperature = (WebUI.getText(findTestObject('Object Repository/Page_Current Temperature/Temperature')).split()[0]).toInteger()

if (temperature < 19) {
    WebUI.click(findTestObject('Object Repository/Page_Current Temperature/button_Buy moisturizers'))

    products = ['almond', 'aloe']
} else {
    WebUI.click(findTestObject('Object Repository/Page_Current Temperature/button_Buy sunscreens'))

    products = ['spf-30', 'spf-50']
}

product_1 = (products[0])

product_2 = (products[1])

xpath_product_1 = "//p[contains(translate(., 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'),'$product_1')]/following-sibling::button"

xpath_product_2 = "//p[contains(translate(., 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'),'$product_2')]/following-sibling::button"

product_1 = WebUI.modifyObjectProperty(findTestObject('Object Repository/Products/product_1'), 'xpath', 'equals', xpath_product_1, 
    true)

product_2 = WebUI.modifyObjectProperty(findTestObject('Object Repository/Products/product_2'), 'xpath', 'equals', xpath_product_2, 
    true)

WebUI.click(product_1)

WebUI.click(product_2)

WebUI.click(findTestObject('Object Repository/Page_The Best Sunscreens in the World/span_2 item(s)'))

WebUI.click(findTestObject('Object Repository/Page_Cart Items/button_Pay with Card'))

WebUI.setText(findTestObject('Object Repository/Page_Cart Items/input_email'), email)

WebUI.sendKeys(findTestObject('Object Repository/Page_Cart Items/input_card_number'), card_number_1)

WebUI.sendKeys(findTestObject('Object Repository/Page_Cart Items/input_card_number'), card_number_1)

WebUI.sendKeys(findTestObject('Object Repository/Page_Cart Items/input_card_number'), card_number_1)

WebUI.sendKeys(findTestObject('Object Repository/Page_Cart Items/input_card_number'), card_number_2)

WebUI.sendKeys(findTestObject('Object Repository/Page_Cart Items/input_cc-exp'), cc_exp_1)

WebUI.sendKeys(findTestObject('Object Repository/Page_Cart Items/input_cc-exp'), cc_exp_2)

WebUI.setText(findTestObject('Object Repository/Page_Cart Items/input_cc-csc'), cc_csc)

WebUI.setText(findTestObject('Object Repository/Page_Cart Items/input_Code_Postal'), code_postal)

WebUI.click(findTestObject('Object Repository/Page_Cart Items/button_Submit'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Confirmation/h2_PAYMENT SUCCESS'), 2)

WebUI.closeBrowser()

