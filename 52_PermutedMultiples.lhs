Euler problem 52 - Permuted Multiples
-------------------------------------

Problem Analysis
----------------

The solution to this problem is pretty straight-forward. There is a small optimation to be made,
namely instead of calculating each of the c * x (c is [1,6]) immediately, an iterative calculation
and control will allow discarding a faulty candidate earlier. Also, x must be a multiple of 9, since
in order for a number to produce the same digit sum after multiplication, it needs to be multiplied by 3.

Imports
-------

Data.List will enable sorting of lists, which is useful for checking digit equality.

> import Data.List (sort)

Equality
--------

Investigates whether or not two digit lists are equal, regardless of digit ordering.

> digEq :: Integer -> Integer -> Bool
> digEq a b = sortDig a == sortDig b
>
> sortDig = sort . digits

Solution
--------

The solution investigates, for each number n = [1,2..Solution] if n, 2n, ..., 6n contains the same digits.
As soon as a c * n is wrong, the next number is investigated. This is enable via Haskell's lazy evaluation.

> solve = solver 9
> solver n
>	| eqAll n 2 == True = n
>	| otherwise = solver (n + 9)
> eqAll n k
>	| k >= 7 = True
>	| otherwise = digEq n (k * n) && eqAll n (k + 1)

Auxiliary
---------

The functions digits and number are taken from
51_PrimeDigitReplacement.lhs . They allow digits to number conversion and reconversion respectively.

> digits :: Integer -> [Integer]
> digits 0 = []
> digits n = (digits (n `quot` 10)) ++ [n `mod` 10] 
>
> number :: [Integer] -> Integer
> number = foldl1 ((+).(*10))
