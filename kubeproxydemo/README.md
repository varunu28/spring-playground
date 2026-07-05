# Kube-proxy Demo

## Setup
A simple Java service deployed on minikube with a `ClusterIP`

## How to deploy?
Run `skaffold run`

## Routing flow through kube-proxy
 - Get the `ClusterIP` of the service by running `kubectl get service --namespace kubeproxy-demo`
 - Run `minikube ssh`
 - Get the rule associated with service `sudo iptables-save | grep <ClusterIP>` to get the service chain
 - Inspect the service chain further to find the chain that kube-proxy created for the service by running `sudo iptables -t nat -L <Service Chain> -v -n`
 - As we have 3 replicas in deployment, we will see 3 additional service chains each representing a backend endpoint of our service pod
 - `iptables` perform endpoint selection based upon probability of each individual service chain
 - Final step of routing is to figure out network connection to single container `sudo iptables -t nat -L <Individual service chain> -v -n`
 - This step provides a DNAT(Destination network address translation)
