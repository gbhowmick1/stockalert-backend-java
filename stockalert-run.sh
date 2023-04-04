#!/bin/bash

sudo docker-compose -f  stockalert-backend-java.yml down &&
sudo docker build -t  stockalert-backend-java:latest  . &&
sudo docker-compose -f  stockalert-backend-java.yml  up -d


#   LOGIN TO EC2 AND  TAKE PULL FROM GIT AND RUN THE SCRIPT 
#               OR
#   FROM JENKINS - TAKE PULL FROM GIT AND  RUN THE SCRIPT AND API WILL BE RE-DEPLOYED

