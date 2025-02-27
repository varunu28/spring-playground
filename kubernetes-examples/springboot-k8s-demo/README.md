# SpringBoot K8S Demo

## Create docker image
```bash
  docker build -t springboot-k8s-demo .
```

## Allow minikube to read images from local docker registry
```bash
  eval $(minikube docker-env)
```

## Create deployment
```bash
  kubectl apply -f kubernetes/deployment.yaml
```

## Create service
```bash
  kubectl apply -f kubernetes/service.yaml
```

## Tunnel service
```bash
  minikube service springboot-k8s-demo-service
```