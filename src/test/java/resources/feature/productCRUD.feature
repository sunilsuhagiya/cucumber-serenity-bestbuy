Feature: Testing different request on the best buy API

  As a user I want to test bestbuy application

  Scenario Outline: Products CRUD Test
    When I create product with name "<name>" type "<type>" price"<price>" shipping"<shipping>" upc"<upc>" description"<description>" manufacture"<manufacture>" model"<model>" url"<url>" image"<image>"
    And I verify user created
    And I update product with name "<name>" type "<type>" price"<price>" shipping"<shipping>" upc"<upc>" description"<description>" manufacture"<manufacture>" model"<model>" url"<url>" image"<image>"
    And I check product updated successfully
    And I delete product
    Then I verify that product deleted successfully
    Examples:
      | name     | type     | price | shipping   | upc                               | description | manufacturer | model | url                                                                                                       | image                                                                                                     |
      | Duracell | HardGood | 8.50  | 7854226784 | Compatible with select electronic | Duracell    | MN1500B8Z    | SG    | http://www.bestbuy.com/site/duracell-aa-batteries-8-pack/127687.p?id=1051384045676&skuId=127687&cmp=RMXCC | http://img.bbystatic.com/BestBuy_US/images/products/1276/127687_sa.jpg                                    |
