Feature: BookingLondonSearchTests;

  Scenario: Booking London Search
    Given navigate to booking home page
    * wait for page loaded
    * wait for registration alert
    * close alert
    * type in search field "Лондон"
    * select london from search results
    * click [Submit] button
    * scroll to result 10
    * change ElementBgc To Green
    * change Element Title Color To Red
    Then take screenshot