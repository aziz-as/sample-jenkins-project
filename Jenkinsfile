pipeline {
    agent any
    tools { 
        maven 'MAVEN' 
        jdk 'JAVA' 
    }
stages {

		stage('Build'){
			steps {
				bat "mvn clean install -DskipTests"
			}
		}

		stage('Test'){
			steps{
				bat "mvn test"
			}
		}

		stage('Deploy') {
			steps {
			    bat "mvn deploy"
			}
		}
	}
}