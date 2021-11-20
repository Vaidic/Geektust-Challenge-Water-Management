#!/bin/bash

gradle clean build -x test --no-daemon
java -jar build/libs/geektrust.jar sample_input/input1.txt