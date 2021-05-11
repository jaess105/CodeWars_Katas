def digitize(x):
	if(int(x/10) == 0):
		return [int(x)]
	else:
		return [int(x % 10)] + digitize(x/10)

print(digitize(123344))
print(digitize(443321))
print(digitize(5))
#digitize :: Int -> [Int]
#digitize x  | x `div` 10 == 0 = [x]
#	            | otherwise = [x `mod` 10] ++ digitize (div x 10)
