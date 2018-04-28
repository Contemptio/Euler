Euler problem 44 - Pentagonal Numbers
-------------------------------------

Pentagonal Logic
----------------

Generates a pentagonal number for the given index n.

> pentagonal :: Integral a => a -> a
> pentagonal n = quot (n * (3 * n - 1)) 2

Generates a list of pentagonal numbers from 1 to n.

> pentList :: Integral a => a -> [a]
> pentList n = map pentagonal [1..n]

Checks if a number is pentagonal. A number is pentagonal if (1/6 (+ || -) sqrt((24n + 1)/36) is even.

> isPentagonal :: Integer -> Bool
> isPentagonal = isInt . formula
> formula n = ((sqrt (24 * (fromInteger n) + 1)) + 1) / 6

Solution
--------

Brute-force solution. Creates two lists of pentagonal numbers P_1 -> P_n where n = 10000,
creates tuples of the respective differences and sums and finally filters the list for
tuples where both the sum and difference are pentagonal.

> listA = pentList 2500
> listB = pentList 2500
>
> diffList = filter (\(x, y) -> isPentagonal x && isPentagonal y) [(b - a, a + b) | a <- listA, b <- listB]
> 
> solution = minimumBy fst diffList

Auxiliary
---------

Checks if a number is an int, that is, for this problem we can calculate whether a result
has a rest or not (courtesy of SO-user yairchu, ref 1).

> isInt :: RealFrac a => a -> Bool
> isInt n = n == fromInteger (round n)

Returns the minimum element where the ordering is determined by the transformation function func
(courtesy of EDAN40, ref 2).

> minimumBy :: (Ord b) => (a -> b) -> [a] -> a
> minimumBy func xs = head $ filter ((==minVal) . func) xs
> 	where minVal = minimum $ map func xs

Debug and validity tests
------------------------

> testIsPentagonal = foldl1 (&&) $ map isPentagonal $
> 				pentList 100000
> numPent n = head $ map round $ filter isInt [formula n]

References
----------

1.	http://stackoverflow.com/questions/1164003/how-do-i-test-if-a-floating-point-number-is-an-integer-in-haskell

2.	http://cs.lth.se/edan40/
