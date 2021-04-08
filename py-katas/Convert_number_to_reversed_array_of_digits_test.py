from Convert_number_to_reversed_array_of_digits import digitize

def basic_test_cases():

    def test(actual , expected):
        str = 'test failed\nwas: ', actual, '\nexpected: ', expected
        assert actual == expected, str
    def first_test():
        test(digitize(35231), [1, 3, 2, 5, 3])
        #assert  list == , "test failed was: " + list + "expected" 
    def second_test():
        assert (digitize(23582357) == [7, 5, 3, 2, 8, 5, 3, 2]), "2 test failed"
    def third_test():
        assert (digitize(984764738) == [8, 3, 7, 4, 6, 7, 4, 8, 9]), "3 test failed"
    def fourth_test():
        assert (digitize(45762893920) == [
                      0, 2, 9, 3, 9, 8, 2, 6, 7, 5, 4]), "4 test failed"
    def fifth_test():
        assert (digitize(548702838394) == [
                     4, 9, 3, 8, 3, 8, 2, 0, 7, 8, 4, 5]), "5 test failed"
    
    first_test()
    second_test()
    third_test()
    fourth_test()
    fifth_test()

basic_test_cases()
