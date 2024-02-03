#!/bin/bash

cd "$(dirname "$0")"

mvn clean compile

mvn exec:java -Dexec.mainClass="Main.PlayerCommunicationMain"

read -p "Press Enter to exit..."
