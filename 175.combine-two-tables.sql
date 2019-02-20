<<<<<<< HEAD
SELECT FirstName, LastName, City, State
FROM Person LEFT JOIN Address
=======
SELECT FirstName, LastName, City, State
FROM Person LEFT JOIN Address
>>>>>>> a07c39f2ecee05469bc7938cd2530a4d83ca0284
ON Person.PersonID = Address.PersonID;