Feature: General Store
  Scenario: TC01 Pozitif Test
    When Ulke menusundan "Austria" secilir
    And isim kutusuna "Safinaz" girilir
    And cinsiyet seceneklerinden "Female" secilir
    And Lets Shop butonuna tiklanir
    Then Sayfa basliginin "Products" oldugu dogrulanir


