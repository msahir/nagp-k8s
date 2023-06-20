This repo contains the application as well as the deployment files. It also contains the docker file to create the docker image. But a docker image is already pushed in the docker hub which can be pulled and used while deployment.</br>
The link to code repo is: https://github.com/msahir/nagp-k8s 
</br>
The link to docker hub image is: https://hub.docker.com/repository/docker/mohitaheer/nagp-k8s/general

Steps to run the application in the kubernates cluster:
  1. Transfer all the deployment files in your cluster.
  2. Execute the svc-namespace.yml file to create namespace.</br>
      ```Command : kubectl apply -f svc-namespace.yml```
  3. Execute the svc-secrets.yaml to create the secrets which contain mysql database password.</br>
      ```Command : kubectl apply -f svc-secrets.yml```
  4. Execute the svc-configMap.yaml to create the configs used by application to connect to mysql database.</br>
       ```Command : kubectl apply -f svc-configMap.yml```
  5. Execute the db-deployment.yaml to start the mysql server on a pod.</br>
       ```Command : kubectl apply -f db-deployment.yml```
  6. Execute the svc-deployment.yaml to start the application server in 4 pods. It will also create a LoadBalancer service to expose the application from outside world.</br>
       ```Command : kubectl apply -f svc-deployment.yml```
  7. Check the status of all resource and extract the public IP from the LoadBalancer service.</br>
      ```Command : kubectl get all -n nagp```
  8. Post request to post the product data. Postman can be used:</br>
       ```URL: POST http://<public_ip>:8080/products```</br>
       </br>
       ```
       Payload: {
                   "name":"Smart Toy",
                   "brand": "Lego",
                   "price": 1000
                }
       ```
  10. Get request to get all the product details.</br>
        ```URL: GET http://<public_ip>:8080/products```
  11. Delete all the kubernates resource when not in use.</br>
        ```Command: kubectl delete all --all -n nagp```
 
         


       
    
