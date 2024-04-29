Feature: BookingPrahaSearchTests;

  Scenario: BookingPrahaSearch
    Given navigate to booking home page
    * wait for page loaded
    * wait for registration alert
    * close alert
    * type in search field "Прага"
    * select praha from search results
    #* close date picker
    * click [Submit] button
    * wait for page loaded
    * close date picker
    #* wait for element "RATING_CONTAINER_XPATH"
    * scroll to rating container
    * select rating 9 checkbox
    * wait for page loaded
    #* wait for element "RATING_APPLIED_XPATH"
    * click on "//div[@data-testid='property-card-container']//div[@data-testid='title']" button
    * wait for new tab
    * wait for page loaded
    * check out rating for Praha should be 9
    Then destroy driver
