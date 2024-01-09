select Salary * months, count(*)
from Employee
where (Salary * months) = (select max(months * salary) from Employee)
group by Salary * months;