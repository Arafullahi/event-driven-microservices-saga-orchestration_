#!/bin/sh
# You can set here anything you need before starting the spring boot application
mvn -s settings.xml clean spring-boot:run -DskipTests=true