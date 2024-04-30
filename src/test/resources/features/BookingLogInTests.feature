Feature: LogIn
#go to booking.com
#login as registered user
#find booking in Madrid, 1 month from now, 2 adults for 5 days
#the first and the last hotel in the list add to favorites
#verify, that "heart" button become red
#verify, that those 2 items appeared in the "My next trip" list
  Scenario: Booking LogIn
    Given navigate to booking home page
    * close alert
    * click on "//a[@data-testid='header-sign-in-button']" button
    * wait for page loaded
    * type in email "dimitrybakum@gmail.com"
    * wait for 3 seconds
    #* click on "//div//span[contains(text(), 'Далее')]" button
    * click on "//button[@type='submit']/span[contains(text(), 'Продолжить через электронную почту')]" button
    * wait for 3 seconds
    * click [Submit] button
    * wait for 3 seconds
    * wait for element "//input[@type='password']"
    * type in pwd "1234567!Q1q"
    * click [Submit] button
    * wait for 3 seconds
    * switch to iframe
    * wait for 3 seconds
    * press button "//div[@aria-label='Нажать и удерживать']"
    * type in search field "Madrid"
