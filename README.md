---
title: LineMate
description: We wait in line for people.
author: Paul Groce
created:  2016 May 5
---

--------
LineMate
--------

---
LineMate is an ecommerce website that allows users to purchase goods through their phone that they would otherwise have to wait in line for 
in person. The original idea for the project was centered around a very busy concession stand that could (and would) do more business if not 
for the extremely long wait time in line, which was turning people away. 
---

--------
FEATURES
--------

---
1. User Login/Signup

LineMate's signup screen requires you to enter a mobile phone number. Other than that, the login and signup functionality is pretty basic. 
In the future I plan on expanding the "index" menu to include a more detailed personal info/registration section (including payment options,
alternate contact information, etc).

2. Gallery of Items and Shopping Cart

LineMate's menu functionality includes a short list of food items displayed based on their type. The items and their data are stored on a MySQL database 
using MAMP. The listings for these items include item name, price, a short description (optional), and any special notes for the order. LineMate's current
menu contents (and to some extent) functionality is based on and around the concession stand menu at a private recreation club in western Massachusettes. 
It is my wision that a more marketable version of LineMate might be designed in a broader fashion to accomodate use in services/businesses other than concessions 
(admissions, for example maybe). 

3. Checkout

LineMate's checkout functionality again utilizes MySQL via MAMP. Like the login and signup, this feature is pretty standard in the way that it works. When 
an order is submitted, the appropriate data is stored on both the User and Order tables of the database and the user is redirected to an order summary/status 
screen. My hope is that after a little research, I'll be able to write a decently accurate algorithm to calculate "estimated time to ready" fore each order based 
on how many orders exist ahead of the current order and what kind of items those orders consist of. 

4. CRUD functionality: create, read, update, delete items and other objects

With LineMate's current CRUD functionality, the user is able to select items from multiple menu lists, enter a quantity and any special requests for each item selected,
and remove items from the current "orderList". The next significant functional feature in the works is the ability to edit an existing order as long as the order status 
and/or "estimated time to ready" has not passsed a certain threshold. 
