# BreoMaster

# Information
This repository holds the API and scripts for generating video out of twitter content.
It's a spring boot application. Internally the service calls the shell scripts that 
uses the tools such as "imagemagick" and "ffmpeg" to produce the video.

# Technologies
- Microservice : Java 8, Spring boot
- Shell scripts
- Ffmpeg
- Imagemagick

# Environments
There are four different environments provided. 
1. default => It is "dev" profile by default.
2. dev => This is development environment.
3. qa => This is QA environment.
4. prod => This is production environment.

## Default
```sh
$ mvn clean install
$ mvn spring-boot:run
```

## Development
```sh
$ mvn clean install
$ mvn clean install
$ mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

## QA
```sh
$ mvn clean install
$ mvn spring-boot:run -Dspring-boot.run.profiles=qa
```

## Prod
```sh
$ mvn clean install
$ mvn clean install
$ mvn spring-boot:run -Dspring-boot.run.profiles=prod
```

# End points
> http://localhost:8080/getvideo
- Request type :  POST
- List of paramaters
| Parameters | README |
| ------ | ------ |
| requestId | Unique identifier for the request |
| name | Name of the twitter account |
| twitter_handle | Twitter handle name |
| bio | Profile summary of the twitter account |
| location | Location |
| website | Website |
| date_joined | Date when the person joined twitter |
| tweet_count | Number of tweets |
| following | Number of people the person is following |
| followers | Number of people following this account |
| likes | Number of tweets like by the account |
| profile_picture_url | Twitter profile picture URL |
| background_picture_url | Background picture URL |
| tweets_content | '####' separated list of tweets for the video |
- Output
- Success : returns the mov file 
