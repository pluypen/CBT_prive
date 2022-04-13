*** Settings ***
Library           SeleniumLibrary
Library           Dialogs

*** Test Cases ***
TC1
    ${grid_url}    Set variable    https://pascal_rDhTa5:xPxLNTLHpoUsz9uwBZst@hub-cloud.browserstack.com/wd/hub
    ${caps}    evaluate    {'os_version': '10', 'os': 'Windows', 'browser': 'chrome','browser_version': 'latest', 'name': 'Parallel Test1', 'build': 'browserstack-build-1'}
    comment    ${executor}    Evaluate    selenium.webdriver.remote.remote_connection.RemoteConnection('${grid_url}')    selenium.webdriver
    comment    Create Webdriver    Remote    command_executor=${executor}    desired_capabilities=${caps}
    comment    go to    https:\\www.google.com
    open browser    https:\\www.google.com    Chrome    remote_url=${grid_url}    desired_capabilities=${caps}
    click element    //button/div[text()='Ik ga akkoord']
    wait until element is enabled    xpath=//input[@name='q']
    input text    xpath=//input[@name='q']    selenium
    click button    //input[@name='btnK']
    capture page screenshot
    [Teardown]    Close Browser
