pipeline {
    agent any
    tools { 
        maven 'MAVEN' 
        jdk 'JAVA' 
    }
    stages {
        stage ('Initialize') {
            steps {
                bat '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                ''' 
            }
        }

        stage ('Build') {
            steps {
                bat "mvn spring-boot:run"
            }
        }
    }
}