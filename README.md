# secondroshambo
secondtroshambo
-------------
This Roshambo version is for subscription scores.

---

Considerations
--------------
* User send round to server -> getting a result
* Result is stored in server -> A table subscribe results from front
* When user press "Restart game" -> User must change Id

---

Backend considerations
----------------------
* Only need:
  * RestController
  * Service for evaluate result
* Data structures
* Using Kafka for propagate total scores
