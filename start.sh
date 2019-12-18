#!/bin/bash
nohup java -jar SpringBootTest-0.0.1.jar > nohup.out  2>&1 &

tail -f nohup.out

