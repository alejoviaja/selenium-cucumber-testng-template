Feature: This feature will provide different ways of interacting

  with the booking platform
  I as a client
  want to fill my personal data out
  So I can book a flight



  Background:
    Given the user goes to the booking portal


    @happyRegistry
    Scenario Outline: happy user registration
      When fills out the personal data "<firstName>" and "<lastName>"
      * personal address "<email>" "<password>" "<street>" "<city>" "<state>" "<zip>"
      Then a successful header should appear

      Examples:
      |firstName|lastName|email              |password|street|city|state|zip   |
      |alejo    |viaja   |alextrips@gmail.com|123     |Diasg |corn|Texas|110550|
      |alejo    |viaja   |alextrips@gmail.com|123     |Diasg |corn|Texas|110550|


    Scenario Outline: edge user registration
      When fills out the personal data "<firstName>" and "<lastName>"
      * personal address "<email>" "<password>" "<street>" "<city>" "<state>" "<zip>"
      Then a successful header should appear

      Examples:
        |firstName|lastName|email              |password|street|city|state|zip   |
        |alejo    |viaja   |alextrips@gmail.com|123     |Diasg |corn|Texas|110550|

