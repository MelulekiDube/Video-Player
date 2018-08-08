#Makefile for compiling the taxi class
# Meluleki Dube
# 28 March 2017
BINDIR=bin
SRCDIR=src
DOCDIR=doc
JAVAC=javac
JFLAGS= -Xlint:all -Xlint:-unchecked 

.SUFFIXES: .java .class
.java.class:
	$(JAVAC)  $(JFLAGS)  $<
CLASSES=$(SRCDIR)/Word
default:
	@echo "**********Compiling the files now***************"
	${JAVAC} -d $(BINDIR) ${SRCDIR}/*.java
	@echo "**********Done find the compiled files under bin***************"
	
run:
	java -cp $(BINDIR) Main
	
clean:
	@echo "Clearing all contents of bin directory"
	@rm -f  $(BINDIR)/*.class
	@echo "Done!!!!"

