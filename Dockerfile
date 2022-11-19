# syntax=docker/dockerfile:1

FROM eclipse-temurin:8-jdk
EXPOSE 8080
ADD ./target/test-classes/test/AddToCartTest.class AddToCartTest.class
ENTRYPOINT ["java","-jar","AddToCartTest.class"]

RUN sed -i -- 's&deb http://deb.debian.org/debian jessie-updates main&#deb http://deb.debian.org/debian jessie-updates main&g' /etc/apt/sources.list && \
  apt-get update && apt-get install wget -y && \
  apt-get update && apt-get install -y gnupg2 && \
  apt-get install -y bash && \
  apt-get -yqq install curl unzip && \
  wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add - && \
  echo "deb http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list && \
  apt-get update && apt-get -qqy install ${CHROME_VERSION:-google-chrome-stable}

ENV CHROME_BINARY "/apps/google-chrome-stable"

# Install Chrome WebDriver
RUN CHROMEDRIVER_VERSION=`curl -sS chromedriver.storage.googleapis.com/LATEST_RELEASE` && \
    mkdir -p /apps/chromedriver-$CHROMEDRIVER_VERSION && \
    curl -sS -o /tmp/chromedriver_linux64.zip http://chromedriver.storage.googleapis.com/$CHROMEDRIVER_VERSION/chromedriver_linux64.zip && \
    unzip -qq /tmp/chromedriver_linux64.zip -d /apps/chromedriver-$CHROMEDRIVER_VERSION && \
    rm /tmp/chromedriver_linux64.zip && \
    chmod +x /apps/chromedriver-$CHROMEDRIVER_VERSION/chromedriver && \
    ln -fs /apps/chromedriver-$CHROMEDRIVER_VERSION/chromedriver /usr/local/bin/chromedriver
ENV CHROME_DRIVER "/usr/local/bin/google-chrome-stable"
