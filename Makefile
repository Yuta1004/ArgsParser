JAVA := java
JAVAC := javac

OPTS :=
JAVA_OPTS = $(OPTS) -classpath bin
JAVAC_OPTS := $(OPTS) -sourcepath src -d bin

exec:
	$(call BUILD_AND_RUN, src/Main.java, Main)

test:
	$(call BUILD_AND_RUN, src/Test.java, Test)

define BUILD_AND_RUN
	$(JAVAC) $(JAVAC_OPTS) $1
	$(JAVA) $(JAVA_OPTS) $1
endef
