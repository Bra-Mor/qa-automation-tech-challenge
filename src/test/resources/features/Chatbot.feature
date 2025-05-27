@test1
Feature: Manage Bot Intents
    Verify that the user can successfully create and edit intents in the bot.

    Background: I am on the adereso web and i login.

        Given I navigate to broly.adere.so
        When I enter a valid username and password
        When I navigate to Adereso Studio
        When I click on the chatbot ZapBot
        When I select the intents section

    Scenario: Add an intent in the ZapBot chatbot
        When I add a new intent
        Then a success alert should appear

    Scenario: Test bot
        When I click on the Edit button and type a word from the intent examples
        Then the bot should recognize the intent

    Scenario: Prevent creation of an intent with a duplicate name
        When I add an intent with an already existing name
        Then an error alert should appear

    Scenario: Prevent adding an intent with empty required fields
        When I add a new intent without filling in the required fields
        Then the intent should not be added to the list

    Scenario: Edit an existing intent
        When I click the action button and select edit
        When I update the intent
        Then a success alert should appear


