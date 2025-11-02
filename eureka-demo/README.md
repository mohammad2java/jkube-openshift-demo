# eureka-demo with jkube for openshit
--------------------------------------
1) to deploy
   mvn clean package oc:resource oc:build oc:deploy

2) to undeploy:
oc:undeploy

3) to test : check this endpoints login into portal - networking->routes
curl http://eureka-demo-amir87-tech-dev.apps.rm1.0a51.p1.openshiftapps.com/actuator/info

