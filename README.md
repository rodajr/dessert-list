# Dessert List - testing/practicing Spring-Boot

Stuff used:
- Spring Tool Suite 4;
- java 8;
- Spring-boot 2;
- swagger and the url -> http://localhost:8081/swagger-ui.html;
- MariaDB - sql dump file -> dump-dessertDB-202001022245.

* I used 8081 port on application.properties because I had other stuff runing on my computer :D

# UPDATE 02/01/2019 / 2019-01-02
- Repository created - 02/01/2019 / 2019-01-02.

# UPDATE 13/01/2019 / 2019-01-13
 - JWT(spring-boot-starter-security) security for token (jjwt) / bearer authentication.

# UPDATE 20/01/2019 / 2019-01-20
 - unit test (3 tests);
 - jacoco included(I ran sonar from a docker).
 
 
 #TODO
 - create more tests for sonar.
  
 * docker command used on this:
 - docker run -d --name sonarqube -p 9000:9000 sonarqube
 
 ** run as maven build with this settings:
 - on Goals > sonar:sonar;
 - on JRE tab, VM arguments > -Dsonar.host.url=http://<your-docker-ip-or-localhost>:9000