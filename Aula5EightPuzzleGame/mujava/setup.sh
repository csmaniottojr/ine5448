#!/bin/sh	
export JAVA_HOME=/usr/lib/jvm/java-8-oracle/
export MJDIR=/home/cesar/workspace_testes/Aula5EightPuzzleGame/mujava
export CLASSPATH=$JAVA_HOME/lib/tools.jar:$MJDIR/mujava.jar:$MJDIR/openjava.jar:$MJDIR/hamcrest-all-1.3.jar:$MJDIR/junit-4.12.jar
echo $CLASSPATH
java mujava.gui.RunTestMain > output.txt
