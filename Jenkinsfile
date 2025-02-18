pipeline {
    agent any
    environment { 
      PATH = "C:\Program Files\apache-maven-3.9.9\bin:$PATH"
    }
    stages {

        stage ('Build') {
            steps {
                bat "mvn clean install"
            }
        }
    }
}