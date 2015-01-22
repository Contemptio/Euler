Euler problem 56 - Powerful digit sum
-------------------------------------

Problem Analysis
----------------

It is quite reasonable to believe that the answer lies somewhere where a and b are both really high. The solver starts at a = b = 90. Even so, some form of formally specified constraint is better than a hunch.
	According to a "Doctor Ricky" from mathforum.org, we can calculate the number of digits a number have by using the formula

	n_digits = b * log_10 a + 1, rounded down,

which tells us, even if we assume the worst (1 followed by 0's) and best (all 9's) cases, b needs to be very high, and while a doesn't needs to be as high, the solution likely lies in the higher values of a. log_10 99 is approximately 1.996. If we impose the arbitrary restriction that log_10 a >= 1.9 we can select a reasonable starting point for a as well;

	log_10 a = 1.9 => a = 10^1.9 ~ 79.

Since Haskell evaluates multiplication of extremely quickly, this euler problem is trivial. Transform numbers a^b to digits, and sum them, inspecting which has the greatest sum.

> digitSum :: Integer -> Integer
> digitSum = sum . digits

Solution
--------



> aLimit = 100
> bLimit = 100
>
> solve  = maximum $ solver 79 90
> solver a b 
>	| a >= aLimit = solver 0 (b + 1)
>	| b >= bLimit = []
>	| otherwise = digitSum (a^b) : solver (a + 1) b

Auxiliary
---------

The function digits was taken from 52_PermutedMultiples.lhs

> digits :: Integer -> [Integer]
> digits 0 = []
> digits n = (digits (n `quot` 10)) ++ [n `mod` 10] 

References
----------
1. http://mathforum.org/library/drmath/view/70510.html