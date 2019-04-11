#!/bin/bash
echo "INICIANDO BUILD DO NOTIFICATION"
echo "PARANDO OS CONTAINERS"
docker stop ws && docker stop nginx && docker stop nginx-nt && docker stop notification

#pull e build do mpr-notification
git pull && mvn clean install

path=target/notification.jar

if [ -f "$path" ]; then
    echo "Removendo os containers e as imagens anteriores"
    docker rm -f notification && docker rmi mpr/notification
    docker rm -f nginx-nt && docker rmi mpr/nginx-nt
    echo "Iniciando o compose"
    docker-compose up -d
    echo "FIM DO BUILD"
    echo "ESPERA!!!! PRECISA SUBIR OS OUTROS CONTAINERS...."
    docker start ws && docker start nginx
    echo "AGORA FECHOU!"

else
    echo "ERROR: Algum erro no build não gerou o jar. Implementar envio de email"
    docker start notification
fi
