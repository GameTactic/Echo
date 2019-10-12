FROM openjdk:11-jre-slim
MAINTAINER Niko Granö <niko@ironlions.fi>

# Add Maven dependencies (not shaded into the artifact; Docker-cached)
#ADD target/lib /usr/share/gametactic/lib # Disabled due we do not have libs.
ARG JAR_FILE
ADD target/${JAR_FILE} /usr/share/gametactic/echo.jar

ENTRYPOINT ["/usr/bin/java", "-jar", "/usr/share/gametactic/echo.jar"]