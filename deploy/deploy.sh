#!/usr/bin/env bash


mvn clean package -DskipTests

echo "Copy files ..."

scp -i ~/.ssh/oko \
    ./target/*.jar \
    baiturtashbaev@34.89.216.69:~/deploko/hosting.jar

echo "Restart server ..."

ssh -i ~/.ssh/oko baiturtashbaev@34.89.216.69 << EOF

pgrep java | xargs kill -9
nohup java -jar deploko/hosting.jar &

EOF

echo "Bye !"