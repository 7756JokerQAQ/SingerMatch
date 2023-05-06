FROM openjdk:8

# Copy local code to the container image.
WORKDIR /app
COPY pom.xml .
COPY ./mySingerbackend-0.0.1-SNAPSHOT.jar ./mySingerbackend.jar
EXPOSE 8080
# Run the web service on container startup.
ENTRYPOINT ["java","-jar","-Xms100m","-Xmx100m"]
CMD ["mySingerbackend.jar"]
