Sensi
--------

Social sentiment application implements Weka API

Run
--------

1. Clone or download the project source code
2. On MySQL server create database 'sensi'
3. Go to top level folder and run maven install :
```
mvn install
```
4. Wait until maven download dependency complete and install on your local maven repo
5. Go to web/ folder :
```
cd web/
```
6. Run server and deploy webapp :

```
mvn jetty:run
```

OR package as war and deploy to server manually

```
mvn package
```
