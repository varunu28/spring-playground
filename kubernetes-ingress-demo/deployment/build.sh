#!/bin/bash

./mvnw spring-boot:build-image

minikube image load kubernetes-ingress-demo:latest