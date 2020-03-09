JAVA := java
JAVAC := javac

OPTS :=
JAVA_OPTS = $(OPTS) -classpath bin
JAVAC_OPTS := $(OPTS) -sourcepath src -d bin


make:
	make build
	make run

run:
	$(JAVA) $(JAVA_OPTS) Main

build: src/Main.java
	$(JAVAC) $(JAVAC_OPTS) src/Main.java

