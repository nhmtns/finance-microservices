# finance-microservices
Learning Microservices. 

This project crates microservices using spring boot / spring cloud

To Build:

$ mvn clean package -f ${current.project.path} -DskipTests

To Run:

    - First start Eureka Server 
        ( $ java -jar ${current.project.path}/target/finance-microservices-0.0.1-SNAPSHOT.jar reg 8090 )
    - Next  start each service  
        ( $ java -jar ${current.project.path}/target/finance-microservices-0.0.1-SNAPSHOT.jar accounts 8091)
    
    Note: If you change the ports for these services, then change entries in respective 
    <service-name>-server.yml file under /resources/<service-name>-server folder
    
Running in Eclipse Che:
    - if you are running under eclipse che, see the values of http://${server.port.8090} and http://${server.port.8091} to access each service respectively    



Setting up in Eclipse Che:
In eclipse Che, import project and setup following 'commands':
    run = scl enable rh-maven33 'mvn compile spring-boot:run -f ${current.project.path}'

    run-reg = java -jar ${current.project.path}/target/finance-microservices-0.0.1-SNAPSHOT.jar reg 8080
    http://${server.port.8080}

    run-account = java -jar ${current.project.path}/target/finance-microservices-0.0.1-SNAPSHOT.jar accounts 4401

    debug = scl enable rh-maven33 'mvn spring-boot:run -Drun.jvmArguments="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5005" -f ${current.project.path}'

    clean-pkg = mvn clean package -f ${current.project.path} -DskipTests