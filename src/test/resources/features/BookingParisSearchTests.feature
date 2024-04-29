Feature: BookingParisSearchTests;

  Scenario: BookingParisSearch
    Given navigate to booking home page
    * wait for page loaded
    * wait for registration alert
    * close alert
    * type in search field "Париж"
    * select paris from search results
    * select dates in 3 out 10
    * select 5 persons and 5 rooms
    * click [Submit] button
    * wait for page loaded
    * close date picker
    * scroll to rating container
    * select rating 6 checkbox
    * wait for page loaded
    * expand filters
    * select filter from min to max
    * check out rating for Paris should be "Оценка 6,0"
    Then destroy driver
