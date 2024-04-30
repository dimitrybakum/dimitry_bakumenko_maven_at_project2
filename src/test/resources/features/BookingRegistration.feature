Feature: SignUp

  Background:
    Given navigate to "https://trashmail.com/" page
    * fill out real email
    * select number of forwards value 1 day
    * click on [Get mail] button
    * store temp email address

  Scenario: Booking SignUp
    Given navigate to booking home page
    * close alert
    * click on signUp button
    * fill out temp email
    * click [Submit] button
    * wait for page loaded
    * add password
    * confirm password
    * click on create account button
    * wait for 3 seconds
    * switch to iframe
    * wait for element "//div[@aria-label='Нажать и удерживать']//p"
    * press button

