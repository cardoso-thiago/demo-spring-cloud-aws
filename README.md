# Demo Spring Cloud AWS

Na raiz do projeto, executar o comando `docker-compose up` para subir a Localstack.

## SNS

- Comando para criar o tópico: `aws --endpoint-url=http://localhost:4566 sns create-topic --name person-notification`
- Comando para se inscrever no tópico (Linux): `aws --endpoint-url=http://localhost:4566 sns subscribe --protocol http --notification-endpoint http://172.17.0.1:8080/sns --topic-arn <arn do comando anterior>`
- Comando para se inscrever no tópico (Mac e Windows): `aws --endpoint-url=http://localhost:4566 sns subscribe --protocol http --notification-endpoint http://host.docker.internal:8080/sns --topic-arn <arn do comando anterior>`
- Comando para envio de uma notificação via `SnsTemplate`: `curl localhost:8080/send/http/notification`