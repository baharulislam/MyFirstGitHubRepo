#! /bin/sh
cd ./lib
fuser -n tcp -k 4444
fuser -n tcp -k 5556 
java -jar selenium-server-standalone-2.53.0.jar -role hub  &
java -Downloadswebdriver.chrome.driver=./chromedriver.exe -jar selenium-server-standalone-2.53.0.jar -role webdriver -hub http://localhost:4444/grid/register -port 5556 -platform=Linux -browser browserName=chrome,maxInstances=5  &
ant  testng-execution
