
/* Requires the Docker Pipeline plugin */
pipeline {
    agent { docker { image 'maven:3.9.9-eclipse-temurin-17' } }
    stages {
        stage('build') {
            steps {
                sh 'mvn spring-boot:run'
            }
        }
    }
}