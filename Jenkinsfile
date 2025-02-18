
/* Requires the Docker Pipeline plugin */
pipeline {
    agent { docker { image 'maven' } }
    stages {
        stage('build') {
            steps {
                sh 'mvn spring-boot:run'
            }
        }
    }
}