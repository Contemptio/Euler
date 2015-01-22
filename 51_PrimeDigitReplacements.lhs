Euler Problem 51 - Prime Digit Replacements
-------------------------------------------

Problem Analysis
----------------
The task is to find the first prime number (going from 2 and upward) that which, through
substituting one or more numbers with an identical number, can produce exactly eight
other prime numbers. While straight-up brute forcing is possible (generate all primes,
check if one can be permuted to at least seven others) it is time-consuming. To lower the
computational load there are restrictions which can be imposed.	Firstly, we know that the
first number can not be substituted, since the last number in a prime > 10 belongs to
[1,3,7,9] (even numbers and 5 removed). Secondly, we can utilize the rule of division by 3:
if the digit sum of a number is divisible by 3, the number is divisible by 3. This leads to
an interesting conclusion (stolen from Kristian Edlund's blog, ref 2). If we add a repeated
number of 1 or 2 digits to any number, the digitsum will be altered by 0, 1 or 2 (since our
substititute digits needs to be eight from [0,9]. This is the same for any number of repeated
digits whose amount is not evenly divisible by 3. This means that the amount of repeated digits
needs to be 3n where n is 1, 2 or 3, the assumption being that the sought number is not longer
than ten digits.

Imports
-------

In order for the list management to work correctly, lists needs to be modifiable (Sequence.update),
and for the rest of the solution to work on lists without going too deep into external data structure
logic we would like to translate from a list to a sequence (Sequence.fromList) and back again
(Foldable.toList). Importing Data.Set is required for rmdups, removal of duplicate elements, which is
specified under "Stolen Functions." For rmdups to work as intended, sort is also needed.

> import Data.Sequence (fromList, update)
> import Data.Foldable (toList)
> import qualified Data.Set as Set
> import Data.List (sort)

Prime Logic
-----------

This function determines whether or not a number k is prime. It uses a trick where list comprehension
builds a list of all prime factors to k. Due to Haskell's lazy evaluation, this list terminates after
any prime factor is found.

> isPrime :: Integer -> Bool
> isPrime k = null [x | x <- [2..isqrt k], k `mod` x == 0]

A function that takes a list of digit lists and returns only the lists that constitute primes is needed.

> primes = filter isPrime . map number

List Management
---------------

Replaces all elements in list xs at indices from the list inds with the number n.

> replace :: [Int] -> Integer -> [Integer] -> [Integer]
> replace []	   _ xs = xs
> replace (i:inds) n xs = replace inds n $ updateList i n xs

Calls upon the function replace for each number [0..9]

> replaceThem :: [Int] -> [Integer] -> [[Integer]]
> replaceThem inds digits = replaceThem' inds 0 digits
> replaceThem' inds 10 digits = []
> replaceThem' inds k digits = replace inds k digits :
>	replaceThem' inds (k + 1) digits

Permutations
------------

Returns all permutations of three digits belonging to [0,9]. This crude solution can easily be expanded
to six or nine digits. All permutations containing duplicate indices are removed from the final list.

> threePerm = rinsedThreePerm threePerm'
>
> threePerm' =	[ [a,b,c] |
>			 a <- [0..5], b <- [0..5], c <- [0..5]
>		   	]
> 
> rinsedThreePerm :: Ord a => [[a]] -> [[a]]
> rinsedThreePerm = rmdups . map sort .
>	filter (\x -> length x == 3) . map rmdups

Solution
--------

What remains now is to go through all numbers, checking whether they can craft eight primes using
the same replacement indices list.

> solve = startSolve 2
> startSolve n = solveIt threePerm n
>
> solveIt []	   n
>	| isPrime (n + 1) = startSolve (n + 1)
>	| otherwise	  = solveIt [] (n + 1)
> solveIt (i:inds) n
>	| length posSol == 8 	= posSol
>	| otherwise		= solveIt inds n
>		where posSol = primes $ filter (\x -> head x /= 0) $ 
>			replaceThem i digit
>				where digit = digits n

Stolen Functions
----------------

The function rmdups (crafted by Stack Overflow user Nikita Volkov, ref 1) features a pretty quick
duplicate remover. While it is not complicated, it is clever.

> rmdups :: Ord a => [a] -> [a]
> rmdups = rmdups' Set.empty where
> rmdups' _ [] = []
> rmdups' a (b : c) = if Set.member b a
>   then rmdups' a c
>   else b : rmdups' (Set.insert b a) c

Auxiliary
---------

The function updateList will replace the element at the specified index with the specified replacement.
* The function digits will divide an integer into a list containing its digits.
* The function toWord will translate a list of integers into a single integer as per [1,2,3,4] -> 1234.
* The function isqrt pessimistically calculates the integer square root of the given number, i.e. the
  result to isqrt n will be ceiling(sqrt(x)).

> updateList :: Int -> a -> [a] -> [a]
> updateList x n ys = toList $ update x n $ fromList ys
>
> digits :: Integer -> [Integer]
> digits 0 = []
> digits n = (digits (n `quot` 10)) ++ [n `mod` 10] 
>
> number :: [Integer] -> Integer
> number = foldl1 ((+).(*10))
>
> isqrt :: Integer -> Integer
> isqrt = ceiling . sqrt . fromInteger

Notes
-----
This solution will terminate... Eventually.

References
----------

1. http://stackoverflow.com/questions/16108714/haskell-removing-duplicates-from-a-list
2. http://www.mathblog.dk/project-euler-51-eight-prime-family/
