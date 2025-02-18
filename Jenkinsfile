pipeline {
    agent any
    tools { 
        maven 'Maven 3.9.9' 
        jdk 'jdk17' 
    }
    stages {
        stage ('Initialize') {
            steps {
                sh '''
                    echo "JAVA = ${JAVA}"
                    echo "MAVEN = ${MAVEN}"
                ''' 
            }
        }

        stage ('Build') {
            steps {
                echo 'This is a minimal pipeline.'
            }
        }
    }
}