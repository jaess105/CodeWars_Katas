def accum(s):
    return '-'.join(letter.upper() + letter.lower()*counter
             for counter, letter in enumerate(s))
