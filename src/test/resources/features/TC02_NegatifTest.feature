Feature: General Store
  Scenario: TC02 Negatif Test
    When Ulke menusundan "Argentina" secilir
    And isim kutusu bos birakilir
    And cinsiyet seceneklerinden "Male" secilir
    And Lets Shop butonuna tiklanir
    Then Hata mesajinin "Please enter your name" oldugu dogrulanir
