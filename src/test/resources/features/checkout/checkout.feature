Feature: Checkout

  # This scenario lets us duplicate values to make them fit across all code.
  # We have to improve that scenario to make sure we don't allow developers to just hardcode stuff to make
  # all the tests pass.
  Scenario: Checkout a banana
    Given the price of a "banana" is 40c
    When I checkout 1 "banana"
    Then the total price should be 40c

  # We use the "triangulation principle" to force developers to make a solution that will be useful.
  # We basically make sure that we have more cases that have to be fulfilled as requirements
  # The first change from the previous scenario is that this is a scenario OUTLINE
  Scenario Outline: Checkout bananas
    # A scenario outline lets us specify multiple scenarios at once using a TABLE
    Given the price of a "banana" is 40c

    # NB the <count> and <total> fields.
    # TODO: We had to create 2 new steps that are not used or those two lines get underlined.
    When I checkout <count> "banana"
    Then the total price should be <total>c

    # This is where triangulation happens - The table turning this scenario into a scenario outline
    Examples:
    | count | total |
    |   1   |   40  |
    |   2   |   80  |

  # What if we checkout two bananas separately?
  # We had to heavily modify the steps definitions and the implementation
  Scenario: Two bananas scanned separately
    Given the price of a "banana" is 40c
    When I checkout 1 "banana"
    And I checkout 1 "banana"
    Then the total price should be 80c

  # What if we sell apples too? This again leads to a major code refactoring
  Scenario: A banana and an apple
    Given the price of a "banana" is 40c
    And the price of a "apple" is 25c
    When I checkout 2 "banana"
    And I checkout 1 "apple"
    Then the total price should be 105c
