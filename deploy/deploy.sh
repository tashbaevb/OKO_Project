#!/usr/bin/env bash


mvn clean package -DskipTests

echo "Copy files ..."

scp -i ~/.ssh/gcloud-oko-ssh \
    ./target/*.jar \
    baiturtashbaev@34.141.109.206:~/deploko/hosting.jar

echo "Restart server ..."

ssh -i ~/.ssh/gcloud-oko-ssh baiturtashbaev@34.141.109.206 << EOF

pgrep java | xargs kill -9
nohup java -jar deploko/hosting.jar &

EOF

echo "Bye !"