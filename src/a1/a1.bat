@echo off
set PATH=%PATH%;%JAVA_HOME%\bin
set CLASSPATH=%CLASSPATH%;.;
ECHO compiling class
javac a1.Starter.java
java a1.Starter