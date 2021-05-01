
# church-people
**Build Status:**
[![Build Status](https://travis-ci.com/church-source/church-services.svg?branch=master)](https://travis-ci.com/church-source/church-services)
**Code Coverage Status:**
[![codecov](https://codecov.io/gh/church-source/church-services/branch/master/graph/badge.svg)](https://codecov.io/gh/church-source/church-services)

A church services API

### Local Dev Environment
To build: `gradlew build`

To run: `gradlew bootRun`

### Docker Environment
The following will bring up the environment with using images built on dockerhub. 
1. Bring up the containers with docker-compose: `sudo docker-compose up -d`
2. Access API in port 8081 (as configured in the docker-compose.yml)
