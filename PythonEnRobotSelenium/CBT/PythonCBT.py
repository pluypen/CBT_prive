from selenium import webdriver
from selenium.webdriver.common.desired_capabilities import DesiredCapabilities
from time import sleep

caps = {
     'os_version': '10',
     'os': 'Windows',
     'browser': 'chrome',
     'browser_version': 'latest',
     'name': 'Parallel Test1', # test name
     'build': 'browserstack-build-1' # Your tests will be organized within this build
}

driver = webdriver.Remote(
     command_executor='https://pascal_rDhTa5:xPxLNTLHpoUsz9uwBZst@hub-cloud.browserstack.com/wd/hub',
     desired_capabilities=caps)
driver.get("https://www.google.com")
# sleep(2)
driver.implicitly_wait(20)


element = driver.find_element_by_xpath("//button/div[text()='Ik ga akkoord']")
element.click()

driver.get_screenshot_as_file("c:\\temp\\selenium\\screenshot1.png")
print (driver.capabilities)
element = driver.find_element_by_name("q")
element.send_keys("selenium")
element.submit()


driver.get_screenshot_as_file("c:\\temp\\selenium\\screenshot2.png")

driver.close()
