#!/bin/bash

cd "$(dirname "$0")"

mvn clean compile

mvn exec:java -Dexec.mainClass="Main.Multi_Process.Player1_Client"
