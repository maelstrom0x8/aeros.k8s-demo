# demo

Demo Spring application used for learning Kubernetes.

- Make changes and commit them
- Add tag
    `git tag vX.X.X`
- Push tag to remote (CI will be triggered for only changes with tags)
- `docker pull maelstrom0x8/demo:vX.X.X-arch` to get image from docker hub

A sample K8s manifest file

```yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: demo-service
  labels:
    name: demo
spec:
  selector:
    matchLabels:
      name: demo
  replicas: 4
  template:
    metadata:
      name: aeros-demo
      labels:
        name: demo
    spec:
      containers:
        - name: demo-native
          image: maelstrom0x8/demo:v0.0.4-x86_64
          ports:
          - containerPort: 9090
          resources:
            limits:
              cpu: 100m
              memory: 500Mi
            


--- 

apiVersion: v1
kind: Service
metadata:
  name: dm-svc
  labels:
    name: demo
spec:
  selector:
    name: demo
  ports:
  - port: 8988
    protocol: TCP
    targetPort: 9090
  type: ClusterIP

```
