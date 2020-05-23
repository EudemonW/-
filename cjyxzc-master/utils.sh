#!/bin/bash

JAVAPID=`ps aux|grep java| grep main-service|awk '{print $2}'`
pushd ~/gitcode/cjyxzc > /dev/null 2>&1

killFunc()
{
    kill -9 $JAVAPID
}

pullCodeFunc()
{
    git pull
}

startJar()
{
    mvn clean install -Dmaven.test.skip=true
    nohup java -jar --spring.profiles.active=prod main-service/target/main-service-0.0.1-SNAPSHOT.jar > runlog 2>&1 &
}

case $1 in
    kill)
	killFunc
	echo "kill ${JAVAPID} "
      ;;
    sync)
	pullCodeFunc
	echo "git sync "
      ;;
    restart)
	killFunc
	startJar
        echo "restart jar " 
      ;;
    main)
	killFunc
	pullCodeFunc
	startJar
        echo "restart jar after git sync " 
      ;;
    start)
	startJar
        echo "start jar " 
      ;;
    ps)
        echo "java pid ${JAVAPID}" 
      ;;
    *)
        echo "Invalid option"
      ;;
esac

popd > /dev/null 2>&1
