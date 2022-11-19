# syntax=docker/dockerfile:1

FROM standalone-chrome:latest

COPY .mvn/ .mvn
RUN ./mvnw dependency:resolve

ADD ExecuteScripts.ps1 ./
ENTRYPOINT ["/bin/bash","ExecuteScripts.ps1"]