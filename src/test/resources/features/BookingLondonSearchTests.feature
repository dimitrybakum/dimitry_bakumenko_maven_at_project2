Feature: BookingLondonSearchTests;

  Scenario: Booking London Search
    Given navigate to booking home page
    When wait for page loaded
    When close alert
    When type in search field "Лондон"
    Then click [Search] button
    Then click [Submit] button
    #When wait for page loaded
    When scroll to result 10
    Then change ElementBgc To Green
    Then change Element Title Color To Red
    Then take screenshot