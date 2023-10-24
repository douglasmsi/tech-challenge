```shell

docker build -t dmsec .

aws ecr-public get-login-password --region us-east-1 | docker login --username AWS --password-stdin public.ecr.aws/n0p9h9c2

docker tag dmsec:latest public.ecr.aws/n0p9h9c2/dmsec:latest

docker push public.ecr.aws/n0p9h9c2/dmsec:latest

```
