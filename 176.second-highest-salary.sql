<<<<<<< HEAD
SELECT (SELECT DISTINCT Salary FROM Employee
ORDER BY Salary DESC
    OFFSET 1 ROW
    FETCH NEXT 1 ROW ONLY
) AS SecondHighestSalary
=======
SELECT (SELECT DISTINCT Salary FROM Employee
ORDER BY Salary DESC
    OFFSET 1 ROW
    FETCH NEXT 1 ROW ONLY
) AS SecondHighestSalary
>>>>>>> a07c39f2ecee05469bc7938cd2530a4d83ca0284
