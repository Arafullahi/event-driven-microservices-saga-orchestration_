FROM maven:3-openjdk-11-slim as build

WORKDIR /app
ARG arg
RUN echo $arg > ./settings.xml
COPY pom.xml ./

COPY src ./src
RUN echo ${IMAGEREGISTRY}
RUN echo "imageRegistry is : ${IMAGEREGISTRY}"
RUN --mount=type=secret,id=IMAGEREGISTRY \
    echo "imageRegistry: ${IMAGEREGISTRY}, $IMAGEREGISTRY"
RUN echo "imageRegistry: ${IMAGEREGISTRY}"
RUN ["mvn",  "-s",  "settings.xml", "clean", "install"]