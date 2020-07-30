# firstroshambo
firstroshambo
-------------
This Roshambo version is for only one score table's gamer.

---

Considerations
--------------
* User send round to server -> getting a result
* Result is stored locally -> A table stores results
* When user press "Restart game" -> Internal table remove results
* It is not necessary a backend design pattern. Because it's so simple.

---

Backend considerations
----------------------
* Only need:
  * RestController
  * Service for evaluate result
* TDD for service logic
* Data structures
* Enum round selection
* Enum result
  
Frontend Considerations
-----------------------
* **Components**:
* Make round selector (rock/paper/scissors)
* Make Playing Button
* Make Restart Button
* Result of round compent (rock/paper/scissor sad/happy)
* Table showing rounds results
* **Service**:
* **Class**
* ...
* Using bootstrap for resposive
