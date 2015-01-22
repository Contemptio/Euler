Euler problem 53 - Combinatoric Selections
------------------------------------------

Problem Analysis
----------------

There is a tiny optimization (the writer thinks) to be made: instead of just pushing all numbers into
the combinatorial formula, we can investigate what it actually entails. (n k)^T means "choose k from
n candidates". Ignoring the formula and focusing instead of what its nominator and denominator means
specifically execution can be sped up. The nominator states how many ways there are to choose k from n,
order being relevant. The nominator states how many ways there are to choose those k selections.
This means that we can use the formula ((n * (n - 1) * ... * (n - k)) / k!) instead. The thing to note
here is that we have an equal amount of terms both in the nominator and denominator. The equation for a
binomial distribution is a bell curve, meaning that if we at one point t have more than 10^6 selections,
the number of selections that are higher than one million are (n - 2 * t). In essence we can ignore the
leading and trailing t possibilities.

Selection Formulas
------------------

Number of ways to choose k selections from n. Repetition is not allowed.

> choose :: Integer -> Integer -> Integer
> choose n k  = round $ choose' n k
> choose' 0 _ = 1
> choose' _ 0 = 1
> choose' n k = intDiv n k *
>	choose' (n - 1) (k - 1)

If at one point a distribution of n a selection t has more than 10^6 possibilities, this function
calculates how many k for that n will satisfy the same criterion.

> nSel :: Integer -> Integer -> Integer
> nSel n t = n - 2 * t + 1

Solution
--------

The first occurance of a selection greater than 10^6 was for n = 23. The solution starts at n = 24
with k = 1, raising k via iteration. Once choose is greater than 10^6, nSel calculates the possible
selections and the solver proceeds with n = 25, up to n = 100.

> limit = 10^6
> 
> solve = solver 23
> solver 101 = 0
> solver n = startSolve n 1 + solver (n + 1)
> startSolve n k
>	| choose n k > limit = nSel n k
>	| k > n = 0
>	| otherwise = startSolve n (k + 1)

Auxiliary
---------

> intDiv :: Integer -> Integer -> Rational
> intDiv a b = fromInteger a / fromInteger b
