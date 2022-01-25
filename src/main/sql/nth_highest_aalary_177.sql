# 177. Nth Highest Salary
# https://leetcode.com/problems/nth-highest-salary/
# Write an SQL query to report the nth highest salary from the Employee table.
# If there is no nth highest salary, the query should report null.


CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  DECLARE M INT;
  SET M=N-1;
  RETURN (
      # Write your MySQL query statement below.
     select distinct salary from Employee order by salary desc limit 1 offset M
  );
END
