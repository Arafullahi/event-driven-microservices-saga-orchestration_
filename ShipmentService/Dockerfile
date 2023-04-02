FROM maven:3-openjdk-11-slim as build

WORKDIR /app

COPY  ../settings.xml settings.xml
COPY ShipmentService/pom.xml ./

COPY ShipmentService/src ./src
COPY ./entrypoint.sh ./
RUN apt-get update && apt-get install dos2unix && dos2unix /app/entrypoint.sh && chmod +x /app/entrypoint.sh

#Start application
ENTRYPOINT ["/app/entrypoint.sh"]
CMD ["bash"]