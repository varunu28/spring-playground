# Kubernetes Ingress Demo

## What is it?
This is a simple demo application that showcases how to use Kubernetes Ingress to manage external access to services 
within a Kubernetes cluster. The application consists of a basic Spring Boot API that responds to HTTP requests.

## How to run?
 - First build the docker image & load it to minikube
    ```bash
   ./deployment/build.sh
   ```
 - Then start minikube
     ```bash
      minikube start
     ```
 - Apply deployment
    ```bash
    kubectl apply -f deployment/deployment.yaml
    ```
 - Apply ingress
    ```bash
    kubectl apply -f deployment/ingress.yaml
     ```
 - Once ingress IP is ready, run `minikube tunnel`
 - Now you can access the application via the ingress IP by running:
     ```bash
      curl --resolve "ingress-demo.com:80:127.0.0.1" -i http://ingress-demo.com/api/v1/sample
     ```
 - For accessing through a web client, add the following entry to your `/etc/hosts` file:
     ```
   127.0.0.1 ingress-demo.com
   ```