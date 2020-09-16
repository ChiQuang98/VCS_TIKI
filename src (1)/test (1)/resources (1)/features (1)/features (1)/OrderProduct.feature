Feature: Order products

  Scenario Outline: Order products by searching name
    Given I access to Tiki.vn
#    When I login with username is "0366189608" and password is "441998"
    And I search product with keyword is "apple"
    And I choose product with the ordinal numbers is "2"
    Then this product will be displayed with corrected "<name>" and "<price>" in the screen
    When I add product to cart with quantity is "<quantity>"
    Then I should see the product's name is "<name>",price is "<price>" and quantity is "<quantity>" in cart

    Examples:
      | name                                                                                             | price   | quantity |
      | Tai Nghe Bluetooth Apple AirPods 2 True Wireless - MV7N2 - Nhập Khẩu Chính Hãng - Hộp Sạc Thường | 3579000 | 2        |