TARGET=programm.c
BASENAME=$(notdir $(basename $(TARGET)))
OUT=$(BASENAME).o

DIR=$(dir $(TARGET))

TEST_SCRIPT_C := $(DIR)test_$(BASENAME).c
TEST_EXE := $(DIR)test_$(BASENAME).o

CRITERION_PATH := $(shell pwd)/criterion-2.4.2
CRITERION_LIB := $(CRITERION_PATH)/lib
CRITERION_INCLUDE := $(CRITERION_PATH)/include

.PHONY: $(OUT) $(TEST_EXE)

COMPILE: $(TARGET)
	gcc -Wall -Wextra $(TARGET) -o $(OUT)

$(OUT): $(TARGET)
	gcc -Wall -Wextra -DDEBUG $(TARGET) -o $(OUT)

RUN: $(TARGET) $(OUT)
	./$(OUT)

RUNV: $(OUT)
	valgrind --leak-check=yes ./$(OUT)

RUNT: $(OUT)
	time ./$(OUT)

$(TEST_EXE): $(TEST_SCRIPT_C) $(TARGET)
	gcc -Wall -Wextra -o $(TEST_EXE)\
	 $(TEST_SCRIPT_C) $(TARGET)\
	  -I$(CRITERION_INCLUDE) -L$(CRITERION_LIB) -lcriterion -Wl,-rpath=$(CRITERION_LIB)

test: $(TEST_EXE)
	LD_LIBRARY_PATH=$(CRITERION_LIB) ./$(TEST_EXE)
	

# Check that given variables are set and all have non-empty values,
# die with an error otherwise.
#
# Params:
#   1. Variable name(s) to test.
#   2. (optional) Error message to print.
check_defined = \
    $(strip $(foreach 1,$1, \
        $(call __check_defined,$1,$(strip $(value 2)))))
__check_defined = \
    $(if $(value $1),, \
      $(error Undefined $1$(if $2, ($2))))
